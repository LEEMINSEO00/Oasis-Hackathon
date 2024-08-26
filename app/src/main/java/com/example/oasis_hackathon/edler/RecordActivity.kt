package com.example.oasis_hackathon.edler

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.ImageButton
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.oasis_hackathon.R

class RecordActivity : AppCompatActivity() {

    private var isRecording = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.elder_record)

        val recordStartButton = findViewById<ImageButton>(R.id.recordStart)
        val recordFinishButton = findViewById<ImageButton>(R.id.recordFinish)
        val delayedTextView = findViewById<TextView>(R.id.recordedText)

        recordStartButton.setOnClickListener {
            if (!isRecording) {
                recordStartButton.setImageResource(R.drawable.record_pause)
                recordFinishButton.setImageResource(R.drawable.record_finish_gray)
                isRecording = true

                Handler(Looper.getMainLooper()).postDelayed({
                    delayedTextView.visibility = TextView.VISIBLE
                }, 1000)
            } else {
                recordStartButton.setImageResource(R.drawable.record_start)
                recordFinishButton.setImageResource(R.drawable.record_finish)
                isRecording = false
            }
        }

        recordFinishButton.setOnClickListener {
            if (!isRecording) {
                val intent = Intent(this, RecordEditActivity::class.java)
                startActivity(intent)
            }
        }
    }
}