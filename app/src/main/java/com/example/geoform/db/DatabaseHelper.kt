package com.example.geoform.db

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.example.geoform.db.DatabaseContract.NoteColumns

internal class DatabaseHelper(context: Context) :
    SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {

    companion object {
        private const val DATABASE_NAME = "dbnoteapp"
        private const val DATABASE_VERSION = 2

        private const val SQL_CREATE_TABLE_NOTE = "CREATE TABLE ${NoteColumns.TABLE_NAME}" +
                " (${NoteColumns.ID}                   INTEGER PRIMARY KEY AUTOINCREMENT," +
                " ${NoteColumns.NOMOR_POLE}            TEXT NOT NULL," +
                " ${NoteColumns.TIPE_TIANG}            TEXT NOT NULL," +
                " ${NoteColumns.EQUIPMENT_TIANG}       TEXT NOT NULL," +
                " ${NoteColumns.UKURAN_TIANG}          TEXT NOT NULL," +
                " ${NoteColumns.JUMLAH_TIANG}          TEXT NOT NULL," +
                " ${NoteColumns.TIPE_GUY_POLE}         TEXT NOT NULL," +
                " ${NoteColumns.JUMLAH_GUY_POLE}       TEXT NOT NULL," +
                " ${NoteColumns.WELL_DI_SUPPLY}        TEXT NOT NULL," +
                " ${NoteColumns.FASILITAS_DI_SUPPLY}   TEXT NOT NULL," +
                " ${NoteColumns.TIPE_TANAH}            TEXT NOT NULL," +
                " ${NoteColumns.POLE_GUARD}            TEXT NOT NULL," +
                " ${NoteColumns.JUMLAH_CROSS_ARM}      TEXT NOT NULL," +
                " ${NoteColumns.TIPE_CROSS_ARM}        TEXT NOT NULL," +
                " ${NoteColumns.POLE_SLEEVE_BAWAH}     TEXT NOT NULL," +
                " ${NoteColumns.POLE_SLEEVE_ATAS}      TEXT NOT NULL," +
                " ${NoteColumns.STATUS_SLEEVE}         TEXT NOT NULL," +
                " ${NoteColumns.KONDISI_LINGKUNGAN}    TEXT NOT NULL," +
                " ${NoteColumns.JARAK_TIANG_KE_JALAN}  TEXT NOT NULL," +
                " ${NoteColumns.DESKRIPSI}             TEXT NOT NULL," +
                " ${NoteColumns.TANGGAL}               TEXT NOT NULL)"
    }

    override fun onCreate(db: SQLiteDatabase) {
        db.execSQL(SQL_CREATE_TABLE_NOTE)
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.execSQL("DROP TABLE IF EXISTS ${NoteColumns.TABLE_NAME}")
        onCreate(db)
    }
}