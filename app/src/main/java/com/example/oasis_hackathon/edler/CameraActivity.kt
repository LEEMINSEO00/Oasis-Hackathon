package com.example.oasis_hackathon.edler

import android.graphics.Bitmap
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.example.oasis_hackathon.R

class CameraActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.elder_camera)

        val photoExImageView = findViewById<ImageView>(R.id.photoEx)

        val bitmap = intent.getParcelableExtra<Bitmap>("imageBitmap")

        if (bitmap != null) {
            photoExImageView.setImageBitmap(bitmap)
            photoExImageView.visibility = ImageView.VISIBLE
        }
    }
}