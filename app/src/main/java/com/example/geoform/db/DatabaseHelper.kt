package com.example.geoform.db

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.example.geoform.db.DatabaseContract.NoteColumns.Companion.TABLE_NAME

internal class DatabaseHelper(context: Context) :
    SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {

    companion object {
        private const val DATABASE_NAME = "dbnoteapp"
        private const val DATABASE_VERSION = 1

        private const val SQL_CREATE_TABLE_NOTE = "CREATE TABLE $TABLE_NAME" +
                " (${DatabaseContract.NoteColumns._ID} INTEGER PRIMARY KEY AUTOINCREMENT," +
                " ${DatabaseContract.NoteColumns.POLENUMBER} TEXT NOT NULL," +
                " ${DatabaseContract.NoteColumns.TIPETIANG} TEXT NOT NULL," +
                " ${DatabaseContract.NoteColumns.POLEEQUIP} TEXT NOT NULL," +
                " ${DatabaseContract.NoteColumns.SIZEPOLE} TEXT NOT NULL," +
                " ${DatabaseContract.NoteColumns.POLECOORD} TEXT NOT NULL," +
                " ${DatabaseContract.NoteColumns.GUYTYPE} TEXT NOT NULL," +
                " ${DatabaseContract.NoteColumns.GUYCOORD} TEXT NOT NULL," +
                " ${DatabaseContract.NoteColumns.WELLSUPPLY} TEXT NOT NULL," +
                " ${DatabaseContract.NoteColumns.FACSUPPLY} TEXT NOT NULL," +
                " ${DatabaseContract.NoteColumns.GROUNDTYPE} TEXT NOT NULL," +
                " ${DatabaseContract.NoteColumns.POLEGUARD} TEXT NOT NULL," +
                " ${DatabaseContract.NoteColumns.TOTALCROSS} TEXT NOT NULL," +
                " ${DatabaseContract.NoteColumns.CROSSTYPE} TEXT NOT NULL," +
                " ${DatabaseContract.NoteColumns.POLESLEEVEBAWAH} TEXT NOT NULL," +
                " ${DatabaseContract.NoteColumns.POLESLEEVEATAS} TEXT NOT NULL," +
                " ${DatabaseContract.NoteColumns.STATUSSLEEVE} TEXT NOT NULL," +
                " ${DatabaseContract.NoteColumns.ENVCOND} TEXT NOT NULL," +
                " ${DatabaseContract.NoteColumns.JARAKTIANG} TEXT NOT NULL," +
                " ${DatabaseContract.NoteColumns.DESCRIPTION} TEXT NOT NULL," +
                " ${DatabaseContract.NoteColumns.DATE} TEXT NOT NULL)"
    }

    override fun onCreate(db: SQLiteDatabase) {
        db.execSQL(SQL_CREATE_TABLE_NOTE)
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.execSQL("DROP TABLE IF EXISTS $TABLE_NAME")
        onCreate(db)
    }
}