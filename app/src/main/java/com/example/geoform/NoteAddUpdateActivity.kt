package com.example.geoform

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.example.geoform.databinding.ActivityNoteAddUpdateBinding
import com.example.geoform.db.NoteHelper
import com.example.geoform.entity.Note
import java.text.SimpleDateFormat
import java.util.*

class NoteAddUpdateActivity : AppCompatActivity(), View.OnClickListener {

    private var isEdit = false
    private var note: Note? = null
    private var position: Int = 0
    private lateinit var noteHelper: NoteHelper

    private lateinit var binding: ActivityNoteAddUpdateBinding

    companion object {
        const val EXTRA_NOTE = "extra_note"
        const val EXTRA_POSITION = "extra_position"
        const val RESULT_ADD = 101
        const val RESULT_UPDATE = 201
        const val RESULT_DELETE = 301
        const val ALERT_DIALOG_CLOSE = 10
        const val ALERT_DIALOG_DELETE = 20
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNoteAddUpdateBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Init Note Helper
        noteHelper = NoteHelper.getInstance(applicationContext)
        noteHelper.open()

        // Get parcelable data
        note = intent.getParcelableExtra(EXTRA_NOTE)
        if (note != null) {
            position = intent.getIntExtra(EXTRA_POSITION, 0)
            isEdit = true
            note?.let {
                setFieldValue(it)
            }
        } else {
            note = Note()
        }

        // Edit action bar title
        val actionBarTitle: String
        val btnTitle: String

        if (isEdit) {
            actionBarTitle = "Ubah"
            btnTitle = "Update"
        } else {
            actionBarTitle = "Tambah"
            btnTitle = "Simpan"
        }
        supportActionBar?.title = actionBarTitle
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        binding.btnSubmit.text = btnTitle

        binding.btnSubmit.setOnClickListener(this)
    }

    private fun setFieldValue(note: Note) {
        binding.etNomorPole.setText(note.nomor_pole.trim())
        binding.etTipeTiang.setText(note.tipe_tiang.trim())
        binding.etEquipmentTiang.setText(note.equipment_tiang.trim())
        binding.etUkuranTiang.setText(note.ukuran_tiang.toString())
        binding.etJumlahTiang.setText(note.jumlah_tiang.toString())
        binding.etTipeGuyPole.setText(note.tipe_guy_pole.trim())
        binding.etJumlahGuyPole.setText(note.jumlah_guy_pole.toString())
        binding.etWellDiSupply.setText(note.well_di_supply.trim())
        binding.etFasilitasDiSupply.setText(note.fasilitas_di_supply.trim())
        binding.etTipeTanah.setText(note.tipe_tanah.trim())
        binding.etPoleGuard.setText(note.pole_guard.trim())
        binding.etJumlahCrossArm.setText(note.jumlah_cross_arm.toString())
        binding.etTipeCrossArm.setText(note.tipe_cross_arm.trim())
        binding.etPoleSleeveBawah.setText(note.pole_sleeve_bawah.trim())
        binding.etPoleSleeveAtas.setText(note.pole_sleeve_atas.trim())
        binding.etStatusSleeve.setText(note.status_sleeve.trim())
        binding.etKondisiLingkungan.setText(note.kondisi_lingkungan.trim())
        binding.etJarakTiangKeJalan.setText(note.jarak_tiang_ke_jalan.toString())
        binding.etDeskripsi.setText(note.deskripsi.trim())
    }

    private fun getFieldValues(): Note {
        // TODO: Tambahkan field tanggal
        return Note(
            nomor_pole 			 = binding.etNomorPole.text.toString().trim(),
            tipe_tiang 			 = binding.etTipeTiang.text.toString().trim(),
            equipment_tiang 	 = binding.etEquipmentTiang.text.toString().trim(),
            ukuran_tiang 		 = binding.etUkuranTiang.text.toString().trim().toIntOrNull() ?: 0,
            jumlah_tiang 		 = binding.etJumlahTiang.text.toString().trim().toIntOrNull() ?: 0,
            tipe_guy_pole 		 = binding.etTipeGuyPole.text.toString().trim(),
            jumlah_guy_pole 	 = binding.etJumlahGuyPole.text.toString().trim().toIntOrNull() ?: 0,
            well_di_supply 		 = binding.etWellDiSupply.text.toString().trim(),
            fasilitas_di_supply  = binding.etFasilitasDiSupply.text.toString().trim(),
            tipe_tanah 			 = binding.etTipeTanah.text.toString().trim(),
            pole_guard 			 = binding.etPoleGuard.text.toString().trim(),
            jumlah_cross_arm 	 = binding.etJumlahCrossArm.text.toString().trim().toIntOrNull() ?: 0,
            tipe_cross_arm 		 = binding.etTipeCrossArm.text.toString().trim(),
            pole_sleeve_bawah 	 = binding.etPoleSleeveBawah.text.toString().trim(),
            pole_sleeve_atas 	 = binding.etPoleSleeveAtas.text.toString().trim(),
            status_sleeve 		 = binding.etStatusSleeve.text.toString().trim(),
            kondisi_lingkungan 	 = binding.etKondisiLingkungan.text.toString().trim(),
            jarak_tiang_ke_jalan = binding.etJarakTiangKeJalan.text.toString().trim().toIntOrNull() ?: 0,
            deskripsi 			 = binding.etDeskripsi.text.toString().trim(),
            tanggal              = getCurrentDate()
        )
    }

    override fun onClick(view: View) {
        if (view.id == R.id.btn_submit) {
            val data = getFieldValues()

            // Validasi
            val isValid = data.validate()
            val noteId: Long = note?.id ?: 0
            data.id = noteId
            if (isValid.isError){
                Toast.makeText(
                    this@NoteAddUpdateActivity,
                    isValid.errorMessage,
                    Toast.LENGTH_LONG
                ).show()
                return
            }

            if (isEdit) {
                if (noteId == 0L) {
                    Toast.makeText(
                        this@NoteAddUpdateActivity,
                        "Gagal mendapatkan id",
                        Toast.LENGTH_LONG
                    ).show()
                    return
                }
                updateToDatabase(data)
            } else {
                insertToDatabase(data)
            }
        }
    }

    private fun insertToDatabase(data: Note) {
        data.tanggal = getCurrentDate()
        val result = noteHelper.insert(data)
        if (result > 0) {
            data.id = result
            val intent = Intent()
            intent.putExtra(EXTRA_NOTE, data)
            setResult(RESULT_ADD, intent)
            finish()
        } else {
            Toast.makeText(
                this@NoteAddUpdateActivity,
                "Gagal menambah data",
                Toast.LENGTH_SHORT
            ).show()
        }
    }

    private fun updateToDatabase(data: Note) {
        val result = noteHelper.update(note?.id.toString(), data).toLong()
        if (result > 0) {
            val intent = Intent()
            intent.putExtra(EXTRA_NOTE, data)
            intent.putExtra(EXTRA_POSITION, position)
            setResult(RESULT_UPDATE, intent)
            finish()
        } else {
            Toast.makeText(
                this@NoteAddUpdateActivity,
                "Gagal mengupdate data",
                Toast.LENGTH_SHORT
            ).show()
        }
    }

    private fun deleteDataInDatabase() {
        val result = noteHelper.deleteById(note?.id.toString()).toLong()
        if (result > 0) {
            val intent = Intent()
            intent.putExtra(EXTRA_POSITION, position)
            setResult(RESULT_DELETE, intent)
            finish()
        } else {
            Toast.makeText(
                this@NoteAddUpdateActivity,
                "Gagal menghapus data",
                Toast.LENGTH_SHORT
            ).show()
        }
    }

    private fun getCurrentDate(): String {
        val dateFormat = SimpleDateFormat("yyyy/MM/dd  HH:mm:ss", Locale.getDefault())
        val date = Date()
        return dateFormat.format(date)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        if (isEdit) {
            menuInflater.inflate(R.menu.menu_form, menu)
        }
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.action_delete -> showAlertDialog(ALERT_DIALOG_DELETE)
            android.R.id.home -> showAlertDialog(ALERT_DIALOG_CLOSE)
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onBackPressed() {
        showAlertDialog(ALERT_DIALOG_CLOSE)
    }

    private fun showAlertDialog(type: Int) {
        val isDialogClose = type == ALERT_DIALOG_CLOSE
        val dialogTitle: String
        val dialogMessage: String

        if (isDialogClose) {
            dialogTitle = "Batal"
            dialogMessage = "Apakah anda ingin membatalkan perubahan pada form?"
        } else {
            dialogMessage = "Apakah anda yakin ingin menghapus item ini?"
            dialogTitle = "Hapus Note"
        }

        val alertDialogBuilder = AlertDialog.Builder(this)

        alertDialogBuilder.setTitle(dialogTitle)
        alertDialogBuilder
            .setMessage(dialogMessage)
            .setCancelable(false)
            .setPositiveButton("Ya") { _, _ ->
                if (isDialogClose) {
                    finish()
                } else {
                    deleteDataInDatabase()
                }
            }
            .setNegativeButton("Tidak") { dialog, _ -> dialog.cancel() }
        val alertDialog = alertDialogBuilder.create()
        alertDialog.show()
    }
}
