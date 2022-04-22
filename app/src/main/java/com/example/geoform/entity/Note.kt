package com.example.geoform.entity

import android.os.Parcelable
import kotlinx.parcelize.Parcelize


@Parcelize
data class Note(
    // ID [hidden]
    var id: Int = 0,
    // Nomor Pole
    var nomor_pole: String = "",
    // Tipe Tiang
    var tipe_tiang: String = "",
    // Equipment Tiang
    var equipment_tiang: String = "",
    // Ukuran Tiang (Meter)
    var ukuran_tiang: Int = 0,
    // Jumlah Tiang (Single/Double/Triple)
    var jumlah_tiang: Int = 0,
    // Tipe Guy Pole (Pipe/Pasak/Anchor)
    var tipe_guy_pole: String = "",
    // Jumlah Guy Pole
    var jumlah_guy_pole: Int = 0,
    // Well Yang di Supply
    var well_di_supply: String = "",
    // Fasilitas yang di Supply
    var fasilitas_di_supply: String = "",
    // Tipe Tanah
    var tipe_tanah: String = "",
    // Pole Guard (Ya/Tidak)
    var pole_guard: String = "",
    // Jumlah Cross Arm
    var jumlah_cross_arm: Int = 0,
    // Tipe Cross Arm
    var tipe_cross_arm: String = "",
    // Pole Sleeve Bawah (Ya/Tidak)
    var pole_sleeve_bawah: String = "",
    // Pole Sleeve Atas (Ya/Tidak)
    var pole_sleeve_atas: String = "",
    // Status Sleeve
    var status_sleeve: String = "",
    // Kondisi Lingkungan
    var kondisi_lingkungan: String = "",
    // Jarak Tiangh ke Jalan
    var jarak_tiang_ke_jalan: Int = 0,
    // Deskripsi
    var deskripsi: String = "",
    // Tanggal
    var tanggal: String = "",
) : Parcelable {
    fun getFieldTitle(): ArrayList<String> {
        return arrayListOf(
//            "ID [hidden]",
            "Nomor Pole",
            "Tipe Tiang",
            "Equipment Tiang",
            "Ukuran Tiang (Meter)",
            "Jumlah Tiang (Single/Double/Triple)",
            "Tipe Guy Pole (Pipe/Pasak/Anchor)",
            "Jumlah Guy Pole",
            "Well Yang di Supply",
            "Fasilitas yang di Supply",
            "Tipe Tanah",
            "Pole Guard (Ya/Tidak)",
            "Jumlah Cross Arm",
            "Tipe Cross Arm",
            "Pole Sleeve Bawah (Ya/Tidak)",
            "Pole Sleeve Atas (Ya/Tidak)",
            "Status Sleeve",
            "Kondisi Lingkungan",
            "Jarak Tiangh ke Jalan",
            "Deskripsi",
            "Tanggal"
        )
    }

    fun toArrayListOfString():ArrayList<String>{
        return arrayListOf(
//            this.id.toString(),
            this.nomor_pole,
            this.tipe_tiang,
            this.equipment_tiang,
            this.ukuran_tiang.toString(),
            this.jumlah_tiang.toString(),
            this.tipe_guy_pole,
            this.jumlah_guy_pole.toString(),
            this.well_di_supply,
            this.fasilitas_di_supply,
            this.tipe_tanah,
            this.pole_guard,
            this.jumlah_cross_arm.toString(),
            this.tipe_cross_arm,
            this.pole_sleeve_bawah,
            this.pole_sleeve_atas,
            this.status_sleeve,
            this.kondisi_lingkungan,
            this.jarak_tiang_ke_jalan.toString(),
            this.deskripsi,
            this.tanggal,
        )
    }
}