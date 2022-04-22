package com.example.geoform.helper

import android.content.Context
import com.opencsv.CSVWriter
import java.io.File
import java.io.FileWriter
import java.io.IOException

class ExcelExportHelper {

    fun write(context: Context, headers: ArrayList<String>, data: ArrayList<ArrayList<String>>) {

        try {
            val file = File(context.getExternalFilesDir(null), "file_1.csv")
            val outputfile: FileWriter = FileWriter(file)
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
        }
    }

}