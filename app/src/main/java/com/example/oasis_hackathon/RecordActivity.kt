package com.example.oasis_hackathon

import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity

class RecordActivity : AppCompatActivity() {

    private var isRecording = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.elder_record)

        val recordStartButton = findViewById<ImageButton>(R.id.recordStart)
        val recordFinishButton = findViewById<ImageButton>(R.id.recordFinish)

        recordStartButton.setOnClickListener {
            if (!isRecording) {
                recordStartButton.setImageResource(R.drawable.record_pause)
                recordFinishButton.setImageResource(R.drawable.record_finish_gray)
                isRecording = true
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