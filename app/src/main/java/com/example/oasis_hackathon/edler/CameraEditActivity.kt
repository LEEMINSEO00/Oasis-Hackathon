package com.example.oasis_hackathon.edler

import android.content.Intent
import android.graphics.Bitmap
import android.os.Bundle
import android.provider.MediaStore
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.oasis_hackathon.R
import java.text.SimpleDateFormat
import java.util.*

class CameraEditActivity : AppCompatActivity() {

    val CAMERA_CODE = 98
    private lateinit var photoExImageView: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.elder_camera_edit)

        val elderDateTextView = findViewById<TextView>(R.id.elder_date)
        val currentDate = getCurrentDate()
        elderDateTextView.text = currentDate

        //photoExImageView = findViewById(R.id.photoEx)

        // 재촬영 버튼 클릭 시 카메라 호출
        val recameraButton = findViewById<ImageButton>(R.id.recamera)
        recameraButton.setOnClickListener {
            callCamera()
        }

        val recordCompleteButton = findViewById<ImageButton>(R.id.cameraComplete)
        recordCompleteButton.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK
            startActivity(intent)
            finish()
        }
    }

    // 현재 날짜를 가져오는 함수
    private fun getCurrentDate(): String {
        val dateFormat = SimpleDateFormat("yyyy년 MM월 dd일", Locale.getDefault())
        val currentDate = Date()
        return dateFormat.format(currentDate)
    }

    // 카메라 호출 메서드
    private fun callCamera() {
        val cameraIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        startActivityForResult(cameraIntent, CAMERA_CODE)
    }

    // 카메라에서 결과를 받는 메서드
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (resultCode == RESULT_OK && requestCode == CAMERA_CODE) {
            val bitmap = data?.extras?.get("data") as? Bitmap
            bitmap?.let {
                photoExImageView.setImageBitmap(it)  // 사진을 ImageView에 설정
                photoExImageView.visibility = ImageView.VISIBLE
            }
        }
    }
}