package com.example.oasis_hackathon.protector

import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
import com.example.oasis_hackathon.R

class ProLoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.protector_login)

        val protectorLoginButton = findViewById<ImageButton>(R.id.protector_kakaoLogin)
        protectorLoginButton.setOnClickListener {
            val intent = Intent(this, ProAddActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}
