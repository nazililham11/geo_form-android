package com.example.geoform.helper

import android.database.Cursor
import com.example.geoform.db.DatabaseContract.NoteColumns
import com.example.geoform.entity.Note

object MappingHelper {

    fun mapCursorToArrayList(notesCursor: Cursor?): ArrayList<Note> {
        val notesList = ArrayList<Note>()

        notesCursor?.apply {
            while (moveToNext()) {
                val note = Note(
                    id                    = getInt(getColumnIndexOrThrow(NoteColumns.ID)),
                    nomor_pole            = getString(getColumnIndexOrThrow(NoteColumns.NOMOR_POLE)),
                    tipe_tiang            = getString(getColumnIndexOrThrow(NoteColumns.TIPE_TIANG)),
                    equipment_tiang       = getString(getColumnIndexOrThrow(NoteColumns.EQUIPMENT_TIANG)),
                    ukuran_tiang          = getInt(getColumnIndexOrThrow(NoteColumns.UKURAN_TIANG)),
                    jumlah_tiang          = getInt(getColumnIndexOrThrow(NoteColumns.JUMLAH_TIANG)),
                    tipe_guy_pole         = getString(getColumnIndexOrThrow(NoteColumns.TIPE_GUY_POLE)),
                    jumlah_guy_pole       = getInt(getColumnIndexOrThrow(NoteColumns.JUMLAH_GUY_POLE)),
                    well_di_supply        = getString(getColumnIndexOrThrow(NoteColumns.WELL_DI_SUPPLY)),
                    fasilitas_di_supply   = getString(getColumnIndexOrThrow(NoteColumns.FASILITAS_DI_SUPPLY)),
                    tipe_tanah            = getString(getColumnIndexOrThrow(NoteColumns.TIPE_TANAH)),
                    pole_guard            = getString(getColumnIndexOrThrow(NoteColumns.POLE_GUARD)),
                    jumlah_cross_arm      = getInt(getColumnIndexOrThrow(NoteColumns.JUMLAH_CROSS_ARM)),
                    tipe_cross_arm        = getString(getColumnIndexOrThrow(NoteColumns.TIPE_CROSS_ARM)),
                    pole_sleeve_bawah     = getString(getColumnIndexOrThrow(NoteColumns.POLE_SLEEVE_BAWAH)),
                    pole_sleeve_atas      = getString(getColumnIndexOrThrow(NoteColumns.POLE_SLEEVE_ATAS)),
                    status_sleeve         = getString(getColumnIndexOrThrow(NoteColumns.STATUS_SLEEVE)),
                    kondisi_lingkungan    = getString(getColumnIndexOrThrow(NoteColumns.KONDISI_LINGKUNGAN)),
                    jarak_tiang_ke_jalan  = getInt(getColumnIndexOrThrow(NoteColumns.JARAK_TIANG_KE_JALAN)),
                    deskripsi             = getString(getColumnIndexOrThrow(NoteColumns.DESKRIPSI)),
                    tanggal               = getString(getColumnIndexOrThrow(NoteColumns.TANGGAL)),
                )
                notesList.add(note)
            }
        }
        return notesList
    }
}