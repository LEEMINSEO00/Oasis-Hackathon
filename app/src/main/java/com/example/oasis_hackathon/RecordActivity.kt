package com.example.oasis_hackathon

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

        //recordFinishButton.setImageResource(R.drawable.record_finish_gray)

        // recordStart 버튼 클릭 리스너 설정
        recordStartButton.setOnClickListener {
            if (!isRecording) {
                // 녹음 시작 상태
                recordStartButton.setImageResource(R.drawable.record_pause)
                recordFinishButton.setImageResource(R.drawable.record_finish_gray)
                isRecording = true  // 상태를 녹음 중으로 변경
            } else {
                // 녹음 중지 상태로 되돌림
                recordStartButton.setImageResource(R.drawable.record_start)
                recordFinishButton.setImageResource(R.drawable.record_finish)
                isRecording = false  // 상태를 녹음 중지로 변경
            }
        }
    }
}