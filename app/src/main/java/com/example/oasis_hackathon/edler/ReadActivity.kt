package com.example.oasis_hackathon.edler

import android.app.DatePickerDialog
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.ImageButton
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.oasis_hackathon.R
import java.text.SimpleDateFormat
import java.util.*

class ReadActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.elder_diary)

        val elderDateTextView = findViewById<TextView>(R.id.elder_date)

        val currentDate = getCurrentDate()
        elderDateTextView.text = currentDate

        elderDateTextView.setOnClickListener {
            showDatePicker(elderDateTextView)
        }

        val editDiaryButton = findViewById<ImageButton>(R.id.editDiary)
        editDiaryButton.setOnClickListener {
            val intent = Intent(this, EditActivity::class.java)
            startActivity(intent)
        }

        val deleteDiaryButton = findViewById<ImageButton>(R.id.deleteDiary)
        deleteDiaryButton.setOnClickListener {
            showDeleteConfirmationDialog()
        }
    }

    private fun showDeleteConfirmationDialog() {
        val dialogView = LayoutInflater.from(this).inflate(R.layout.elder_popup, null)

        val builder = AlertDialog.Builder(this)
        builder.setView(dialogView)

        val alertDialog = builder.create()

        val cancelButton = dialogView.findViewById<ImageButton>(R.id.alertCancel)
        cancelButton.setOnClickListener {
            alertDialog.dismiss()
        }

        val deleteButton = dialogView.findViewById<ImageButton>(R.id.alertDelete)
        deleteButton.setOnClickListener {
            alertDialog.dismiss()

            val intent = Intent(this, MainActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK
            startActivity(intent)
            finish()
        }

        alertDialog.show()
    }

    private fun getCurrentDate(): String {
        val dateFormat = SimpleDateFormat("yyyy년 MM월 dd일", Locale.getDefault())
        val currentDate = Date()
        return dateFormat.format(currentDate)
    }

    private fun showDatePicker(elderDateTextView: TextView) {
        val calendar = Calendar.getInstance()

        val year = calendar.get(Calendar.YEAR)
        val month = calendar.get(Calendar.MONTH)
        val day = calendar.get(Calendar.DAY_OF_MONTH)

        val datePickerDialog = DatePickerDialog(this, { _, selectedYear, selectedMonth, selectedDay ->
            val selectedDate = "${selectedYear}년 ${selectedMonth + 1}월 ${selectedDay}일"
            elderDateTextView.text = selectedDate
        }, year, month, day)

        datePickerDialog.show() 
    }
}
