package com.example.geoform.helper

import android.os.Environment
import com.opencsv.CSVWriter
import java.io.File
import java.io.FileWriter
import java.io.IOException

class ExcelExportHelper {
    fun write(headers: ArrayList<String>, data: ArrayList<ArrayList<String>>): String? {
        var result: String?
        try {
            val fileName = "export.csv"
            val basePath = Environment.getExternalStorageDirectory()?.absolutePath
            val file = File(basePath, fileName)
            val outputfile = FileWriter(file)
            result = file.absolutePath
            val writer = CSVWriter(outputfile)
            val header = headers.toTypedArray()
            writer.writeNext(header)
            for (column in data){
                writer.writeNext(column.toTypedArray())
            }
            writer.close()
        }
        catch (e: IOException) {
            // TODO Auto-generated catch block
            e.printStackTrace()
            result = null
        }
        return result
    }
}