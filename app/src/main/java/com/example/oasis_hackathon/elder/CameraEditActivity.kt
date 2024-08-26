package com.example.oasis_hackathon.elder

import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.oasis_hackathon.R
import java.text.SimpleDateFormat
import java.util.*

class CameraEditActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.elder_camera_edit)

        val elderDateTextView = findViewById<TextView>(R.id.elder_date)
        val currentDate = getCurrentDate()
        elderDateTextView.text = currentDate

        val recameraButton = findViewById<ImageButton>(R.id.recamera)
        recameraButton.setOnClickListener {
            val intent = Intent(this, CameraActivity::class.java)
            startActivity(intent)
        }

        val recordCompleteButton = findViewById<ImageButton>(R.id.cameraComplete)
        recordCompleteButton.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
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