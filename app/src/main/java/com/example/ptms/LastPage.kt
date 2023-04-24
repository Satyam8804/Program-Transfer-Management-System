package com.example.ptms

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

lateinit var databaseReference: DatabaseReference

class LastPage : AppCompatActivity() {
    private lateinit var textView: TextView
    private lateinit var sharedPreferences: SharedPreferences
    lateinit var reg:String
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_last_page)

        textView= findViewById(R.id.tv)
        val prog_selected = intent.getStringExtra("selected_program")
        textView.text = "You have Successfully transfered your program to $prog_selected"
        sharedPreferences = getSharedPreferences("userData", Context.MODE_PRIVATE)

        reg = sharedPreferences.getString("regNo", "").toString();
        val btn = findViewById<Button>(R.id.btnBack)
        btn.setOnClickListener{
            databaseReference = FirebaseDatabase.getInstance().getReference("Users")
            FirebaseDatabase.getInstance().getReference("Users").child(reg)
                .child("program").setValue(prog_selected.toString())
            val i = Intent(this, StudentInfo::class.java)
            startActivity(i)
        }
    }
}