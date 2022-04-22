package com.example.geoform.db

import android.provider.BaseColumns

internal class DatabaseContract {

    internal class NoteColumns : BaseColumns {
        companion object {
            const val TABLE_NAME           = "note"
            const val ID                   = "id"
            const val NOMOR_POLE           = "nomor_pole"
            const val TIPE_TIANG           = "tipe_tiang"
            const val EQUIPMENT_TIANG      = "equipment_tiang"
            const val UKURAN_TIANG         = "ukuran_tiang"
            const val JUMLAH_TIANG         = "jumlah_tiang"
            const val TIPE_GUY_POLE        = "tipe_guy_pole"
            const val JUMLAH_GUY_POLE      = "jumlah_guy_pole"
            const val WELL_DI_SUPPLY       = "well_di_supply"
            const val FASILITAS_DI_SUPPLY  = "fasilitas_di_supply"
            const val TIPE_TANAH           = "tipe_tanah"
            const val POLE_GUARD           = "pole_guard"
            const val JUMLAH_CROSS_ARM     = "jumlah_cross_arm"
            const val TIPE_CROSS_ARM       = "tipe_cross_arm"
            const val POLE_SLEEVE_BAWAH    = "pole_sleeve_bawah"
            const val POLE_SLEEVE_ATAS     = "pole_sleeve_atas"
            const val STATUS_SLEEVE        = "status_sleeve"
            const val KONDISI_LINGKUNGAN   = "kondisi_lingkungan"
            const val JARAK_TIANG_KE_JALAN = "jarak_tiang_ke_jalan"
            const val DESKRIPSI            = "deskripsi"
            const val TANGGAL              = "tanggal"
        }
    }
}