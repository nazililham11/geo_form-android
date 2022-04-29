package com.example.geoform.helper

import android.content.Context
import com.example.geoform.R
import com.example.geoform.entity.Note
import com.example.geoform.entity.ValidationResult

class NoteUtils {
    fun validate(note: Note, context: Context) : ValidationResult {
        when {
            // Nomor Pole
            note.nomor_pole.isBlank() -> {
                return ValidationResult(true, getEmptyFieldErrorMsg(R.string.header_nomor_pole, context))
            }
            // Tipe Tiang
            note.tipe_tiang.isBlank() -> {
                return ValidationResult(true, getEmptyFieldErrorMsg(R.string.header_tipe_tiang, context))
            }
            // Equipment Tiang
            note.equipment_tiang.isBlank() -> {
                return ValidationResult(true, getEmptyFieldErrorMsg(R.string.header_equipment_tiang, context))
            }
            // Ukuran Tiang (Meter)
            note.ukuran_tiang.isBlank() -> {
                return ValidationResult(true, getEmptyFieldErrorMsg(R.string.header_ukuran_tiang, context))
            }
            // Jumlah Tiang (Single/Double/Triple)
            note.jumlah_tiang.isBlank() -> {
                return ValidationResult(true, getEmptyFieldErrorMsg(R.string.header_jumlah_tiang, context))
            }
            // Tipe Guy Pole (Pipe/Pasak/Anchor)
            note.tipe_guy_pole.isBlank() -> {
                return ValidationResult(true, getEmptyFieldErrorMsg(R.string.header_tipe_guy_pole, context))
            }
            // Jumlah Guy Pole
            note.jumlah_guy_pole.isBlank() -> {
                return ValidationResult(true, getEmptyFieldErrorMsg(R.string.header_jumlah_guy_pole, context))
            }
            // Well Yang di Supply
            note.well_di_supply.isBlank() -> {
                return ValidationResult(true, getEmptyFieldErrorMsg(R.string.header_well_di_supply, context))
            }
            // Fasilitas yang di Supply
            note.fasilitas_di_supply.isBlank() -> {
                return ValidationResult(true, getEmptyFieldErrorMsg(R.string.header_fasilitas_di_supply, context))
            }
            // Tipe Tanah
            note.tipe_tanah.isBlank() -> {
                return ValidationResult(true, getEmptyFieldErrorMsg(R.string.header_tipe_tanah, context))
            }
            // Pole Guard (Ya/Tidak)
            note.pole_guard.isBlank() -> {
                return ValidationResult(true, getEmptyFieldErrorMsg(R.string.header_pole_guard, context))
            }
            // Jumlah Cross Arm
            note.jumlah_cross_arm.isBlank() -> {
                return ValidationResult(true, getEmptyFieldErrorMsg(R.string.header_jumlah_cross_arm, context))
            }
            // Tipe Cross Arm
            note.tipe_cross_arm.isBlank() -> {
                return ValidationResult(true, getEmptyFieldErrorMsg(R.string.header_tipe_cross_arm, context))
            }
            // Pole Sleeve Bawah (Ya/Tidak)
            note.pole_sleeve_bawah.isBlank() -> {
                return ValidationResult(true, getEmptyFieldErrorMsg(R.string.header_pole_sleeve_bawah, context))
            }
            // Pole Sleeve Atas (Ya/Tidak)
            note.pole_sleeve_atas.isBlank() -> {
                return ValidationResult(true, getEmptyFieldErrorMsg(R.string.header_pole_sleeve_atas, context))
            }
            // Status Sleeve
            note.status_sleeve.isBlank() -> {
                return ValidationResult(true, getEmptyFieldErrorMsg(R.string.header_status_sleeve, context))
            }
            // Kondisi Lingkungan
            note.kondisi_lingkungan.isBlank() -> {
                return ValidationResult(true, getEmptyFieldErrorMsg(R.string.header_kondisi_lingkungan, context))
            }
            // Jarak Tiang ke Jalan
            note.jarak_tiang_ke_jalan.isBlank() -> {
                return ValidationResult(true, getEmptyFieldErrorMsg(R.string.header_jarak_tiang_ke_jalan, context))
            }
            // Deskripsi
            note.deskripsi.isBlank() -> {
                return ValidationResult(true, getEmptyFieldErrorMsg(R.string.header_deskripsi, context))
            }
            // Tanggal
//            note.tanggal.isBlank() -> {
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
            "Jarak Tiang ke Jalan (Meter)",
            "Deskripsi",
            "Tanggal"
        )
    }

    fun toArrayListOfString(note: Note): ArrayList<String>{
        return arrayListOf(
//            note.id.toString(),
            note.nomor_pole,
            note.tipe_tiang,
            note.equipment_tiang,
            note.ukuran_tiang,
            note.jumlah_tiang,
            note.tipe_guy_pole,
            note.jumlah_guy_pole,
            note.well_di_supply,
            note.fasilitas_di_supply,
            note.tipe_tanah,
            note.pole_guard,
            note.jumlah_cross_arm,
            note.tipe_cross_arm,
            note.pole_sleeve_bawah,
            note.pole_sleeve_atas,
            note.status_sleeve,
            note.kondisi_lingkungan,
            note.jarak_tiang_ke_jalan,
            note.deskripsi,
            note.tanggal,
        )
    }

    private fun getEmptyFieldErrorMsg(field_id: Int, context: Context): String{
        val msg = context.getString(R.string.error_msg_field_empty)
        val fieldName: String = context.getString(field_id)
        return msg.replace("$", fieldName)
    }
}