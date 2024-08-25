package com.example.oasis_hackathon

import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity

class MainActivity  : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.elder_main)

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