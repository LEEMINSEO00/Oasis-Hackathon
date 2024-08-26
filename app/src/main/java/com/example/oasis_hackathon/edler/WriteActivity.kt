package com.example.oasis_hackathon.edler

import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.oasis_hackathon.R
import java.text.SimpleDateFormat
import java.util.*

class WriteActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.elder_write)

        val elderDateTextView = findViewById<TextView>(R.id.elder_date)
        val currentDate = getCurrentDate()
        elderDateTextView.text = currentDate
        val completeLongButton = findViewById<ImageButton>(R.id.completeLong)

        completeLongButton.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }

    private fun getCurrentDate(): String {
        val dateFormat = SimpleDateFormat("yyyy년 MM월 dd일", Locale.getDefault())
        val currentDate = Date()
        return dateFormat.format(currentDate)
    }
}
