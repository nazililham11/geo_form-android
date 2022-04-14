package com.example.geoform.entity

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize


@Parcelize
data class Note(
    var id: Int = 0,
    var polenumber: String? = null,
    var tipetiang: String? = null,
    var poleequip: String? = null,
    var sizepole: Int? = null,
    var polecoord: Int? = null,
    var guytype: String? = null,
    var guycoord: Int? = null,
    var wellsupply: String? = null,
    var facsupply: String? = null,
    var groundtype: String? = null,
    var poleguard: String? = null,
    var totalcross: Int? = null,
    var crosstype: String? = null,
    var polesleevebawah: String? = null,
    var polesleeveatas: String? = null,
    var statussleeve: String? = null,
    var envcond: String? = null,
    var jaraktiang: Int? = null,
    var description: String? = null,
    var date: String? = null
) : Parcelable