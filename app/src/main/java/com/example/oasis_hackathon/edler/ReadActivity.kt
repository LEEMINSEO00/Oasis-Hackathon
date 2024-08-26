package com.example.oasis_hackathon.edler

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.ImageButton
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.oasis_hackathon.R

class ReadActivity  : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.elder_diary)

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
}