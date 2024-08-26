package com.example.oasis_hackathon.protector

import android.app.DatePickerDialog
import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import android.widget.LinearLayout
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
        setContentView(R.layout.protector_notification)

        val negativeNotification = findViewById<LinearLayout>(R.id.negativeNotification)

        negativeNotification.setOnClickListener {
            val intent = Intent(this, ProAnalysisActivity::class.java)
            startActivity(intent)
        }
    }
}
