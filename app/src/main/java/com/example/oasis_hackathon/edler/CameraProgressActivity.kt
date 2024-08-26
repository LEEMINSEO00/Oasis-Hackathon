package com.example.oasis_hackathon.edler

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import com.example.oasis_hackathon.R

class CameraProgressActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.elder_camera_progress)

        Handler(Looper.getMainLooper()).postDelayed({
            val intent = Intent(this, CameraEditActivity::class.java)
            startActivity(intent)
            finish()
        }, 2000)
    }
}
