package com.example.geoform.entity

import android.os.Parcelable
import kotlinx.parcelize.Parcelize


@Parcelize
data class Note(
    // ID [hidden]
    var id: Long = 0,
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
    fun validate() : ValidationResult{
        when {
            // Nomor Pole
            this.nomor_pole.isBlank() -> {
                return ValidationResult(true, "Nomor Poke Tidak Boleh Kosong")
            }
            // Tipe Tiang
            this.tipe_tiang.isBlank() -> {
                return ValidationResult(true, "Tipe Tiang Tidak Boleh Kosong")
            }
            // Equipment Tiang
            this.equipment_tiang.isBlank() -> {
                return ValidationResult(true, "Equipment Tiang Tidak Boleh Kosong")
            }
            // Ukuran Tiang (Meter)
            this.ukuran_tiang <= 0 -> {
                return ValidationResult(true, "Ukuran Tiang Tidak Boleh Nol Atau Bernilai Minus")
            }
            // Jumlah Tiang (Single/Double/Triple)
            this.jumlah_tiang <= 0 -> {
                return ValidationResult(true, "Jumlah Tiang Tidak Boleh Nol Atau Bernilai Minus")
            }
            // Tipe Guy Pole (Pipe/Pasak/Anchor)
            this.tipe_guy_pole.isBlank() -> {
                return ValidationResult(true, "Tipe Guy Pole Tidak Boleh Kosong")
            }
            // Jumlah Guy Pole
            this.jumlah_guy_pole <= 0 -> {
                return ValidationResult(true, "Jumlah Guy Pole Tidak Boleh Nol Atau Bernilai Minus")
            }
            // Well Yang di Supply
            this.well_di_supply.isBlank() -> {
                return ValidationResult(true, "Well Yang di Supply Tidak Boleh Kosong")
            }
            // Fasilitas yang di Supply
            this.fasilitas_di_supply.isBlank() -> {
                return ValidationResult(true, "Fasilitas yang di Supply Tidak Boleh Kosong")
            }
            // Tipe Tanah
            this.tipe_tanah.isBlank() -> {
                return ValidationResult(true, "Tipe Tanah Tidak Boleh Kosong")
            }
            // Pole Guard (Ya/Tidak)
            this.pole_guard.isBlank() -> {
                return ValidationResult(true, "Pole Guard Tidak Boleh Kosong")
            }
            // Jumlah Cross Arm
            this.jumlah_cross_arm <= 0 -> {
                return ValidationResult(true, "Jumlah Cross Arm Tidak Boleh Nol Atau Bernilai Minus")
            }
            // Tipe Cross Arm
            this.tipe_cross_arm.isBlank() -> {
                return ValidationResult(true, "Tipe Cross Arm Tidak Boleh Kosong")
            }
            // Pole Sleeve Bawah (Ya/Tidak)
            this.pole_sleeve_bawah.isBlank() -> {
                return ValidationResult(true, "Pole Sleeve Bawah Tidak Boleh Kosong")
            }
            // Pole Sleeve Atas (Ya/Tidak)
            this.pole_sleeve_atas.isBlank() -> {
                return ValidationResult(true, "Pole Sleeve Atas Tidak Boleh Kosong")
            }
            // Status Sleeve
            this.status_sleeve.isBlank() -> {
                return ValidationResult(true, "Status Sleeve Tidak Boleh Kosong")
            }
            // Kondisi Lingkungan
            this.kondisi_lingkungan.isBlank() -> {
                return ValidationResult(true, "Kondisi Lingkungan Tidak Boleh Kosong")
            }
            // Jarak Tiangh ke Jalan
            this.jarak_tiang_ke_jalan <= 0 -> {
                return ValidationResult(true, "Jarak Tiangh ke Jalan Tidak Boleh Nol Atau Bernilai Minus")
            }
            // Deskripsi
            this.deskripsi.isBlank() -> {
                return ValidationResult(true, "Deskripsi Tidak Boleh Kosong")
            }
            // Tanggal
//            this.tanggal.isBlank() -> {
//                return ValidationResult(true, "Tanggal Tidak Boleh Kosong")
//            }
            else -> {
                return ValidationResult(false, "OK")
            }
        }
    }

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