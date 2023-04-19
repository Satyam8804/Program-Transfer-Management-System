package com.example.ptms

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class LastPage : AppCompatActivity() {
    lateinit var textView: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_last_page)
        textView= findViewById(R.id.tv)

        val prog_selected = intent.getStringExtra("program_enroll")

        textView.setText("You have Successfully transfered your program to "+ prog_selected)

    }
}