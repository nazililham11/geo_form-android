package com.example.geoform.helper

import android.database.Cursor
import com.example.geoform.db.DatabaseContract
import com.example.geoform.entity.Note

object MappingHelper {

    fun mapCursorToArrayLisy(notesCursor: Cursor?): ArrayList<Note> {
        val notesList = ArrayList<Note>()

        notesCursor?.apply {
            while (moveToNext()) {
                val id = getInt(getColumnIndexOrThrow(DatabaseContract.NoteColumns._ID))
                val polenumber =
                    getString(getColumnIndexOrThrow(DatabaseContract.NoteColumns.POLENUMBER))
                val description =
                    getString(getColumnIndexOrThrow(DatabaseContract.NoteColumns.DESCRIPTION))
                val date = getString(getColumnIndexOrThrow(DatabaseContract.NoteColumns.DATE))
                notesList.add(Note(id, polenumber, description, date))
            }
        }
        return notesList
    }
}

// lanjut 18