package com.example.oasis_hackathon.edler

import android.Manifest
import android.app.Activity
import android.app.DatePickerDialog
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.os.Bundle
import android.provider.MediaStore
import android.widget.ImageButton
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.example.oasis_hackathon.R
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale

class MainActivity : AppCompatActivity() {

    val CAMERA_CODE = 98

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.elder_main)

        val elderDate = findViewById<TextView>(R.id.elder_date)

        val calendar = Calendar.getInstance()
        val dateFormat = SimpleDateFormat("yyyy년 MM월 dd일", Locale.getDefault())
        val currentDate = dateFormat.format(calendar.time)
        elderDate.text = currentDate

        elderDate.setOnClickListener {
            val year = calendar.get(Calendar.YEAR)
            val month = calendar.get(Calendar.MONTH)
            val day = calendar.get(Calendar.DAY_OF_MONTH)

            val datePickerDialog = DatePickerDialog(
                this,
                { _, selectedYear, selectedMonth, selectedDay ->
                    val formattedDate = "${selectedYear}년 ${selectedMonth + 1}월 ${selectedDay}일"
                    elderDate.text = formattedDate

                    if (selectedDay == 24) {
                        val intent = Intent(this, ReadActivity::class.java)
                        startActivity(intent)
                    }
                },
                year, month, day
            )
            datePickerDialog.show()
        }

        val recordMethodButton = findViewById<ImageButton>(R.id.elder_recordMethod)
        recordMethodButton.setOnClickListener {
            val intent = Intent(this, RecordActivity::class.java)
            startActivity(intent)
        }

        val cameraMethodButton = findViewById<ImageButton>(R.id.elder_cameraMethod)
        cameraMethodButton.setOnClickListener {
            callCamera()
        }

        val writeMethodButton = findViewById<ImageButton>(R.id.elder_writeMethod)
        writeMethodButton.setOnClickListener {
            val intent = Intent(this, WriteActivity::class.java)
            startActivity(intent)
        }
    }

    fun callCamera() {
        if (checkPermission(arrayOf(Manifest.permission.CAMERA), CAMERA_CODE)) {
            val cameraIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            startActivityForResult(cameraIntent, CAMERA_CODE)
        }
    }

    fun checkPermission(permissions: Array<String>, requestCode: Int): Boolean {
        for (permission in permissions) {
            if (ContextCompat.checkSelfPermission(this, permission) != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(this, permissions, requestCode)
                return false
            }
        }
        return true
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (resultCode == Activity.RESULT_OK && requestCode == CAMERA_CODE) {
            val bitmap = data?.extras?.get("data") as Bitmap?

            if (bitmap != null) {
                val intent = Intent(this, CameraActivity::class.java)
                intent.putExtra("imageBitmap", bitmap)
                startActivity(intent)
            }
        }
    }
}
