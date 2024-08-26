package com.example.oasis_hackathon.protector

import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
import com.example.oasis_hackathon.R

class ProAnalysisActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.protector_analysis_result)

        val protectorLoginButton = findViewById<ImageButton>(R.id.checkDiary)
        protectorLoginButton.setOnClickListener {
            val intent = Intent(this, ProDiaryActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}
