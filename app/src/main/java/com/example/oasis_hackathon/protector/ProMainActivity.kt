package com.example.oasis_hackathon.protector

import android.app.DatePickerDialog
import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.oasis_hackathon.R
import com.example.oasis_hackathon.edler.ReadActivity
import com.example.oasis_hackathon.edler.RecordActivity
import com.example.oasis_hackathon.edler.WriteActivity
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale

class ProMainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.protector_no_analysis_result)

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

                    if (selectedDay == 25) {
                        val intent = Intent(this, ProAnalysisActivity::class.java)
                        startActivity(intent)
                    }
                },
                year, month, day
            )
            datePickerDialog.show()
        }
    }
}
