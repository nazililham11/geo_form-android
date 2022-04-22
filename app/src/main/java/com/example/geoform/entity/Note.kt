package com.example.geoform.entity

import android.content.Context
import android.os.Parcelable
import com.example.geoform.R
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
    fun validate(context: Context) : ValidationResult{
        when {
            // Nomor Pole
            this.nomor_pole.isBlank() -> {
                return ValidationResult(true, getEmptyFieldErrorMsg(R.string.header_nomor_pole, false, context))
            }
            // Tipe Tiang
            this.tipe_tiang.isBlank() -> {
                return ValidationResult(true, getEmptyFieldErrorMsg(R.string.header_tipe_tiang, false, context))
            }
            // Equipment Tiang
            this.equipment_tiang.isBlank() -> {
                return ValidationResult(true, getEmptyFieldErrorMsg(R.string.header_equipment_tiang, false, context))
            }
            // Ukuran Tiang (Meter)
            this.ukuran_tiang <= 0 -> {
                return ValidationResult(true, getEmptyFieldErrorMsg(R.string.header_ukuran_tiang, true, context))
            }
            // Jumlah Tiang (Single/Double/Triple)
            this.jumlah_tiang <= 0 -> {
                return ValidationResult(true, getEmptyFieldErrorMsg(R.string.header_jumlah_tiang, true, context))
            }
            // Tipe Guy Pole (Pipe/Pasak/Anchor)
            this.tipe_guy_pole.isBlank() -> {
                return ValidationResult(true, getEmptyFieldErrorMsg(R.string.header_tipe_guy_pole, false, context))
            }
            // Jumlah Guy Pole
            this.jumlah_guy_pole <= 0 -> {
                return ValidationResult(true, getEmptyFieldErrorMsg(R.string.header_jumlah_guy_pole, true, context))
            }
            // Well Yang di Supply
            this.well_di_supply.isBlank() -> {
                return ValidationResult(true, getEmptyFieldErrorMsg(R.string.header_well_di_supply, false, context))
            }
            // Fasilitas yang di Supply
            this.fasilitas_di_supply.isBlank() -> {
                return ValidationResult(true, getEmptyFieldErrorMsg(R.string.header_fasilitas_di_supply, false, context))
            }
            // Tipe Tanah
            this.tipe_tanah.isBlank() -> {
                return ValidationResult(true, getEmptyFieldErrorMsg(R.string.header_tipe_tanah, false, context))
            }
            // Pole Guard (Ya/Tidak)
            this.pole_guard.isBlank() -> {
                return ValidationResult(true, getEmptyFieldErrorMsg(R.string.header_pole_guard, false, context))
            }
            // Jumlah Cross Arm
            this.jumlah_cross_arm <= 0 -> {
                return ValidationResult(true, getEmptyFieldErrorMsg(R.string.header_jumlah_cross_arm, true, context))
            }
            // Tipe Cross Arm
            this.tipe_cross_arm.isBlank() -> {
                return ValidationResult(true, getEmptyFieldErrorMsg(R.string.header_tipe_cross_arm, false, context))
            }
            // Pole Sleeve Bawah (Ya/Tidak)
            this.pole_sleeve_bawah.isBlank() -> {
                return ValidationResult(true, getEmptyFieldErrorMsg(R.string.header_pole_sleeve_bawah, false, context))
            }
            // Pole Sleeve Atas (Ya/Tidak)
            this.pole_sleeve_atas.isBlank() -> {
                return ValidationResult(true, getEmptyFieldErrorMsg(R.string.header_pole_sleeve_atas, false, context))
            }
            // Status Sleeve
            this.status_sleeve.isBlank() -> {
                return ValidationResult(true, getEmptyFieldErrorMsg(R.string.header_status_sleeve, false, context))
            }
            // Kondisi Lingkungan
            this.kondisi_lingkungan.isBlank() -> {
                return ValidationResult(true, getEmptyFieldErrorMsg(R.string.header_kondisi_lingkungan, false, context))
            }
            // Jarak Tiangh ke Jalan
            this.jarak_tiang_ke_jalan <= 0 -> {
                return ValidationResult(true, getEmptyFieldErrorMsg(R.string.header_jarak_tiang_ke_jalan, true, context))
            }
            // Deskripsi
            this.deskripsi.isBlank() -> {
                return ValidationResult(true, getEmptyFieldErrorMsg(R.string.header_deskripsi, false, context))
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

    private fun getEmptyFieldErrorMsg(field_id: Int, isNumeric: Boolean, context: Context): String{
        val msg = if (!isNumeric)
            context.getString(R.string.error_msg_field_empty)
        else
            context.getString(R.string.error_msg_field_empty_or_less_zero)

        val fieldName: String = context.getString(field_id)
        return msg.replace("$", fieldName)
    }
}