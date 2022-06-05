package com.example.geoform

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.content.ContextCompat
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.geoform.adapter.NoteAdapter
import com.example.geoform.databinding.ActivityMainBinding
import com.example.geoform.db.NoteHelper
import com.example.geoform.entity.Note
import com.example.geoform.helper.ExcelExportHelper
import com.example.geoform.helper.MappingHelper
import com.example.geoform.helper.NoteUtils
import com.google.android.material.snackbar.Snackbar
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import java.util.*
import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity() {

    companion object {
        private const val EXTRA_STATE = "EXTRA_STATE"
    }
    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: NoteAdapter
    private val PERMISSION_CODE = 1000

    val resultLauncher: ActivityResultLauncher<Intent> = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) { result ->
        if (result.data != null) {
            when (result.resultCode) {
                NoteAddUpdateActivity.RESULT_ADD -> {
                    val note = result.data?.getParcelableExtra<Note>(NoteAddUpdateActivity.EXTRA_NOTE)
                    if (note != null){
                        adapter.addItem(note)
                        binding.rvNotes.smoothScrollToPosition(adapter.itemCount - 1)
                        showSnackbarMessage("Satu item berhasil ditambahkan")
                    }
                }
                NoteAddUpdateActivity.RESULT_UPDATE -> {
                    val note = result.data?.getParcelableExtra<Note>(NoteAddUpdateActivity.EXTRA_NOTE)
                    if (note != null) {
                        val position =
                            result?.data?.getIntExtra(
                                NoteAddUpdateActivity.EXTRA_POSITION,
                                0
                            ) as Int
                        adapter.updateItem(position, note)
                        binding.rvNotes.smoothScrollToPosition(position)
                        showSnackbarMessage("Satu item berhasil diubah")
                    }
                }
                NoteAddUpdateActivity.RESULT_DELETE -> {
                    val position = result?.data?.getIntExtra(NoteAddUpdateActivity.EXTRA_POSITION, 0)
                    if (position != null) {
                        adapter.removeItem(position)
                        showSnackbarMessage("Satu item berhasil dihapus")
                    }
                }
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.title = "Geo Form"

        initRecyclerView()

        if (savedInstanceState == null) {
            loadNotesAsync()
        } else {
            val list = savedInstanceState.getParcelableArrayList<Note>(EXTRA_STATE)
            if (list != null) adapter.listNotes = list
        }
    }

    private fun initRecyclerView(){
        binding.rvNotes.layoutManager = LinearLayoutManager(this)
        binding.rvNotes.setHasFixedSize(true)
        adapter = NoteAdapter(object : NoteAdapter.OnItemClickCallback {
            override fun onItemClicked(selectedNote: Note?, position: Int?) {
                if (selectedNote != null){
                    val intent = Intent(this@MainActivity, NoteAddUpdateActivity::class.java)
                    intent.putExtra(NoteAddUpdateActivity.EXTRA_NOTE, selectedNote)
                    intent.putExtra(NoteAddUpdateActivity.EXTRA_POSITION, position)
                    resultLauncher.launch(intent)
                }
            }
        })
        binding.rvNotes.adapter = adapter

        binding.fabAdd.setOnClickListener {
            val intent = Intent(this@MainActivity, NoteAddUpdateActivity::class.java)
            resultLauncher.launch(intent)
        }
    }

    private fun loadNotesAsync() {
        lifecycleScope.launch {
            binding.progressbar.visibility = View.VISIBLE
            val noteHelper = NoteHelper.getInstance(applicationContext)
            noteHelper.open()
            val deferredNotes = async(Dispatchers.IO) {
                val cursor = noteHelper.queryAll()
                MappingHelper.mapCursorToArrayList(cursor)
            }
            binding.progressbar.visibility = View.INVISIBLE
            val notes = deferredNotes.await()
            if (notes.size > 0) {
                adapter.listNotes = notes
            } else {
                adapter.listNotes = ArrayList()
                showSnackbarMessage("Tidak ada data saat ini")
            }
            noteHelper.close()
        }
    }

    private fun showSnackbarMessage(message: String) {
        Snackbar.make(binding.rvNotes, message, Snackbar.LENGTH_SHORT).show()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putParcelableArrayList(EXTRA_STATE, adapter.listNotes)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item.itemId

        if (id == R.id.export_csv) {
            val permission = permissionCheck()
            if (permission) {
                return exportData()
            }
        }

        return super.onOptionsItemSelected(item)

    }

    private fun exportData(): Boolean {
        val data = adapter.listNotes
        val converted = ArrayList<ArrayList<String>>()
        for (note in data) {
            converted.add(NoteUtils().toArrayListOfString(note))
        }
        val headers = NoteUtils().getFieldTitle()
        val result = ExcelExportHelper().write(headers, converted)
        if (result != null) {
            Toast.makeText(this, "Export Berhasil", Toast.LENGTH_LONG).show()
            Toast.makeText(this, "Lokasi file \"${result}\"", Toast.LENGTH_LONG).show()
            return true
        }
        return false
    }

    private fun permissionCheck(): Boolean {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (checkSelfPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_DENIED) {
                val permission = arrayOf(Manifest.permission.WRITE_EXTERNAL_STORAGE)
                requestPermissions(permission, PERMISSION_CODE)
                return false
            }
        }
        return true
    }

    private fun onStoragePermissionResult(requestCode: Int, grantResults: IntArray) {
        if (requestCode == PERMISSION_CODE){
            if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                exportData()
            } else {
                Toast.makeText(this, "Permission Denied", Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        onStoragePermissionResult(requestCode, grantResults)
    }
}