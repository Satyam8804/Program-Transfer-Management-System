package com.example.ptms

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class LastPage : AppCompatActivity() {
    private lateinit var textView: TextView
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_last_page)

        textView= findViewById(R.id.tv)
        val prog_selected = intent.getStringExtra("program_enroll")
        textView.text = "You have Successfully transfered your program to $prog_selected"

        val btn = findViewById<Button>(R.id.btnBack)
        btn.setOnClickListener{
            val i = Intent(this, StudentInfo::class.java)
            startActivity(i)
        }
    }
}