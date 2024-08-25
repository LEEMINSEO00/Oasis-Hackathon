package com.example.oasis_hackathon

import android.app.DatePickerDialog
import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale

class MainActivity  : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.elder_main)

        val elderDate = findViewById<TextView>(R.id.elder_date)

        val calendar = Calendar.getInstance()
        val dateFormat = SimpleDateFormat("yyyy년 MM월 dd일", Locale.getDefault())
        val currentDate = dateFormat.format(calendar.time)
        elderDate.text = currentDate

        elderDate.setOnClickListener {
            val year = calendar.get(Calendar.YEAR)
            val month = calendar.get(Calendar.MONTH)
            val day = calendar.get(Calendar.DAY_OF_MONTH)

            val datePickerDialog = DatePickerDialog(
                this,
                { _, selectedYear, selectedMonth, selectedDay ->
                    val formattedDate = "${selectedYear}년 ${selectedMonth + 1}월 ${selectedDay}일"
                    elderDate.text = formattedDate

                    if (selectedDay == 24) {
                        val intent = Intent(this, ReadActivity::class.java)
                        startActivity(intent)
                    }
                },
                year, month, day
            )
            datePickerDialog.show()
        }

        val recordMethodButton = findViewById<ImageButton>(R.id.elder_recordMethod)
        recordMethodButton.setOnClickListener {
            val intent = Intent(this, RecordActivity::class.java)
            startActivity(intent)
        }

        val cameraMethodButton = findViewById<ImageButton>(R.id.elder_cameraMethod)
        cameraMethodButton.setOnClickListener {
            val intent = Intent(this, CameraActivity::class.java)
            startActivity(intent)
        }

        val writeMethodButton = findViewById<ImageButton>(R.id.elder_writeMethod)
        writeMethodButton.setOnClickListener {
            val intent = Intent(this, WriteActivity::class.java)
            startActivity(intent)
        }

    }
}