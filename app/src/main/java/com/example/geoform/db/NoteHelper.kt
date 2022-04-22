package com.example.geoform.db

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import com.example.geoform.db.DatabaseContract.NoteColumns
import com.example.geoform.entity.Note
import java.sql.SQLException
import com.example.geoform.db.DatabaseContract.NoteColumns.Companion as Col

class NoteHelper(context: Context) {

    private var dataBaseHelper: DatabaseHelper = DatabaseHelper(context)
    private lateinit var database: SQLiteDatabase

    companion object {
        private const val DATABASE_TABLE = Col.TABLE_NAME
        private var INSTANCE: NoteHelper? = null

        fun getInstance(context: Context): NoteHelper =
            INSTANCE ?: synchronized(this) {
                INSTANCE ?: NoteHelper(context)
            }
    }

    @Throws(SQLException::class)
    fun open() {
        database = dataBaseHelper.writableDatabase
    }

    fun close() {
        dataBaseHelper.close()

        if (database.isOpen)
            database.close()
    }

    fun queryAll(): Cursor {
        return database.query(
            DATABASE_TABLE,
            null,
            null,
            null,
            null,
            null,
            "${Col.ID} ASC"
        )
    }

    fun queryById(id: String): Cursor {
        return database.query(
            DATABASE_TABLE,
            null,
            "${Col.ID} = ?",
            arrayOf(id),
            null,
            null,
            null,
            null
        )
    }

    fun insert(note: Note): Long {
        val values = getContentValues(note)
        return database.insert(DATABASE_TABLE, null, values)
    }

    fun update(id: String, note: Note): Int {
        val values = getContentValues(note)
        return database.update(DATABASE_TABLE, values, "${Col.ID} = ?", arrayOf(id))
    }

    fun deleteById(id: String): Int {
        return database.delete(DATABASE_TABLE, "${Col.ID} = '$id'", null)
    }

    private fun getContentValues(note: Note): ContentValues {
        val value = ContentValues()
        value.put(Col.NOMOR_POLE,           note.nomor_pole)
        value.put(Col.TIPE_TIANG,           note.tipe_tiang)
        value.put(Col.EQUIPMENT_TIANG,      note.equipment_tiang)
        value.put(Col.UKURAN_TIANG,         note.ukuran_tiang)
        value.put(Col.JUMLAH_TIANG,         note.jumlah_tiang)
        value.put(Col.TIPE_GUY_POLE,        note.tipe_guy_pole)
        value.put(Col.JUMLAH_GUY_POLE,      note.jumlah_guy_pole)
        value.put(Col.WELL_DI_SUPPLY,       note.well_di_supply)
        value.put(Col.FASILITAS_DI_SUPPLY,  note.fasilitas_di_supply)
        value.put(Col.TIPE_TANAH,           note.tipe_tanah)
        value.put(Col.POLE_GUARD,           note.pole_guard)
        value.put(Col.JUMLAH_CROSS_ARM,     note.jumlah_cross_arm)
        value.put(Col.TIPE_CROSS_ARM,       note.tipe_cross_arm)
        value.put(Col.POLE_SLEEVE_BAWAH,    note.pole_sleeve_bawah)
        value.put(Col.POLE_SLEEVE_ATAS,     note.pole_sleeve_atas)
        value.put(Col.STATUS_SLEEVE,        note.status_sleeve)
        value.put(Col.KONDISI_LINGKUNGAN,   note.kondisi_lingkungan)
        value.put(Col.JARAK_TIANG_KE_JALAN, note.jarak_tiang_ke_jalan)
        value.put(Col.DESKRIPSI,            note.deskripsi)
        value.put(Col.TANGGAL,              note.tanggal)
        return value
    }


}