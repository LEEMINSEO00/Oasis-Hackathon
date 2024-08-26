package com.example.oasis_hackathon.protector

import android.content.Intent
import android.os.Bundle
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import com.example.oasis_hackathon.R

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
