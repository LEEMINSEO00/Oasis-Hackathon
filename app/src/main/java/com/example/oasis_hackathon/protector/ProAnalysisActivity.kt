package com.example.oasis_hackathon.protector

import android.app.DatePickerDialog
import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.oasis_hackathon.R
import com.example.oasis_hackathon.edler.ReadActivity
import com.example.oasis_hackathon.edler.RecordActivity
import com.example.oasis_hackathon.edler.WriteActivity
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale

class ProAnalysisActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.protector_analysis_result)

    }
}
