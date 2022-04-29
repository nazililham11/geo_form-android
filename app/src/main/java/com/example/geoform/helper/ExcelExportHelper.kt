package com.example.geoform.helper

import android.content.Context
import com.opencsv.CSVWriter
import java.io.File
import java.io.FileWriter
import java.io.IOException

class ExcelExportHelper {

    fun write(context: Context, headers: ArrayList<String>, data: ArrayList<ArrayList<String>>): String? {
        var result: String?
        try {
            val file = File(context.getExternalFilesDir(null), "export.csv")
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