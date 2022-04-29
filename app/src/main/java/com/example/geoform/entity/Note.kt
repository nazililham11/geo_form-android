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
    var ukuran_tiang: String = "",
    // Jumlah Tiang (Single/Double/Triple)
    var jumlah_tiang: String = "",
    // Tipe Guy Pole (Pipe/Pasak/Anchor)
    var tipe_guy_pole: String = "",
    // Jumlah Guy Pole
    var jumlah_guy_pole: String = "",
    // Well Yang di Supply
    var well_di_supply: String = "",
    // Fasilitas yang di Supply
    var fasilitas_di_supply: String = "",
    // Tipe Tanah
    var tipe_tanah: String = "",
    // Pole Guard (Ya/Tidak)
    var pole_guard: String = "",
    // Jumlah Cross Arm
    var jumlah_cross_arm: String = "",
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
    // Jarak Tiang ke Jalan (Meter)
    var jarak_tiang_ke_jalan: String = "",
    // Deskripsi
    var deskripsi: String = "",
    // Tanggal
    var tanggal: String = "",
) : Parcelable
