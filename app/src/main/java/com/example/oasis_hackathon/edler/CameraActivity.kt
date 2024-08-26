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

class CameraActivity : AppCompatActivity() {

    val CAMERA_CODE = 98
    private lateinit var photoExImageView: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.elder_camera)

        val elderDateTextView = findViewById<TextView>(R.id.elder_date)
        val currentDate = getCurrentDate()
        elderDateTextView.text = currentDate

        photoExImageView = findViewById(R.id.photoEx)

        val bitmap = intent.getParcelableExtra<Bitmap>("imageBitmap")
        if (bitmap != null) {
            photoExImageView.setImageBitmap(bitmap)
            photoExImageView.visibility = ImageView.VISIBLE
        }

        val recameraButton = findViewById<ImageButton>(R.id.recamera)
        recameraButton.setOnClickListener {
            callCamera()
        }

        val cameraCompleteButton = findViewById<ImageButton>(R.id.cameraComplete)
        cameraCompleteButton.setOnClickListener {
            val intent = Intent(this, CameraProgressActivity::class.java)
            startActivity(intent)
        }
    }

    private fun callCamera() {
        val cameraIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        startActivityForResult(cameraIntent, CAMERA_CODE)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (resultCode == RESULT_OK && requestCode == CAMERA_CODE) {
            val bitmap = data?.extras?.get("data") as? Bitmap
            bitmap?.let {
                photoExImageView.setImageBitmap(bitmap)
                photoExImageView.visibility = ImageView.VISIBLE
            }
        }
    }

    private fun getCurrentDate(): String {
        val dateFormat = SimpleDateFormat("yyyy년 MM월 dd일", Locale.getDefault())
        val currentDate = Date()
        return dateFormat.format(currentDate)
    }
}