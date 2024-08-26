package com.example.oasis_hackathon.edler

import android.content.Intent
import android.graphics.Bitmap
import android.os.Bundle
import android.provider.MediaStore
import android.widget.ImageButton
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.example.oasis_hackathon.R

class CameraActivity : AppCompatActivity() {

    val CAMERA_CODE = 98
    private lateinit var photoExImageView: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.elder_camera)

        photoExImageView = findViewById(R.id.photoEx)

        // 처음 Activity가 열렸을 때 intent로 전달된 이미지 표시
        val bitmap = intent.getParcelableExtra<Bitmap>("imageBitmap")
        if (bitmap != null) {
            photoExImageView.setImageBitmap(bitmap)
            photoExImageView.visibility = ImageView.VISIBLE
        }

        // recamera 버튼 클릭 시 카메라 앱을 다시 호출
        val recameraButton = findViewById<ImageButton>(R.id.recamera)
        recameraButton.setOnClickListener {
            callCamera()  // 카메라 앱 실행
        }

        // cameraComplete 버튼 클릭 시 다른 화면으로 이동
        val cameraCompleteButton = findViewById<ImageButton>(R.id.cameraComplete)
        cameraCompleteButton.setOnClickListener {
            val intent = Intent(this, CameraProgressActivity::class.java)
            startActivity(intent)
        }
    }

    // 카메라 호출 메서드
    private fun callCamera() {
        val cameraIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        startActivityForResult(cameraIntent, CAMERA_CODE)
    }

    // 카메라 결과 처리
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (resultCode == RESULT_OK && requestCode == CAMERA_CODE) {
            val bitmap = data?.extras?.get("data") as? Bitmap
            bitmap?.let {
                // 찍은 사진을 photoEx에 표시
                photoExImageView.setImageBitmap(bitmap)
                photoExImageView.visibility = ImageView.VISIBLE
            }
        }
    }
}
