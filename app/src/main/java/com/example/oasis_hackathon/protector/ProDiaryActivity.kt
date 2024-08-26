package com.example.oasis_hackathon.protector

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.oasis_hackathon.R

class ProDiaryActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.protector_check_diary)

        /*
        val protectorLoginButton = findViewById<ImageButton>(R.id.checkDiary)
        protectorLoginButton.setOnClickListener {
            val intent = Intent(this, ProMainActivity::class.java)
            startActivity(intent)
            finish()
        }*/
    }
}
