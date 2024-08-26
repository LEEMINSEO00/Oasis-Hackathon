package com.example.oasis_hackathon.edler

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.ProgressBar
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import com.example.oasis_hackathon.R

class CameraProgressActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.elder_camera_progress)

        val progressBar = findViewById<ProgressBar>(R.id.progress)

        val delayMillis = 5000L
        Handler(Looper.getMainLooper()).postDelayed({
            progressBar.isVisible = false

            val intent = Intent(this, CameraEditActivity::class.java)
            startActivity(intent)
            finish()
        }, delayMillis)
    }
}
