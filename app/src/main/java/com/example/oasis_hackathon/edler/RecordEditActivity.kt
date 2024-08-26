package com.example.oasis_hackathon.edler

import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.oasis_hackathon.R
import java.text.SimpleDateFormat
import java.util.*

class RecordEditActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.elder_record_edit)

        val elderDateTextView = findViewById<TextView>(R.id.elder_date)

        val currentDate = getCurrentDate()

        elderDateTextView.text = currentDate

        val rerecordButton = findViewById<ImageButton>(R.id.rerecord)
        rerecordButton.setOnClickListener {
            val intent = Intent(this, RecordActivity::class.java)
            startActivity(intent)
        }

        val recordCompleteButton = findViewById<ImageButton>(R.id.recordComplete)
        recordCompleteButton.setOnClickListener {
            val intent = Intent(this, ReadActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK
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
