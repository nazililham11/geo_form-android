package com.example.geoform.db

import android.provider.BaseColumns

internal class DatabaseContract {

    internal class NoteColumns : BaseColumns {
        companion object {
            const val TABLE_NAME = "note"
            const val _ID = "_id"
            const val POLENUMBER = "polenumber"
            const val TIPETIANG = "tipetiang"
            const val POLEEQUIP = "poleequip"
            const val SIZEPOLE = "sizepole"
            const val POLECOORD = "polecoord"
            const val GUYTYPE = "guytype"
            const val GUYCOORD = "guycoord"
            const val WELLSUPPLY = "wellsupply"
            const val FACSUPPLY = "facsupply"
            const val GROUNDTYPE = "groundtype"
            const val POLEGUARD = "poleguard"
            const val TOTALCROSS = "totalcross"
            const val CROSSTYPE = "crosstype"
            const val POLESLEEVEBAWAH = "polesleevebawah"
            const val POLESLEEVEATAS = "polesleeveatas"
            const val STATUSSLEEVE = "statussleeve"
            const val ENVCOND = "envcond"
            const val JARAKTIANG = "jaraktiang"
            const val DESCRIPTION = "description"
            const val DATE = "date"
        }
    }
}