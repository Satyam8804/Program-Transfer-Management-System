package com.example.ptms

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

class LoginPage : AppCompatActivity() {

    private lateinit var firebaseAuth: FirebaseAuth
    private lateinit var username: EditText
    private lateinit var password: EditText
    private lateinit var register:TextView
    private lateinit var loginButton: Button
    private lateinit var regNo:EditText
    private lateinit var sharedPreferences: SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_login_page)
        username = findViewById(R.id.username)
        password = findViewById(R.id.password)
        regNo = findViewById(R.id.regNo)
        loginButton = findViewById(R.id.loginButton)
        register = findViewById(R.id.signupText)
        firebaseAuth = FirebaseAuth.getInstance()

        loginButton.setOnClickListener {
            val email= username.text.toString()
            val pass = password.text.toString()
            val regno = regNo.text.toString()
            if (email.isNotEmpty() && pass.isNotEmpty() && regno.isNotEmpty() ) {
                firebaseAuth.signInWithEmailAndPassword(email, pass).addOnCompleteListener {
                    if (it.isSuccessful) {
                        val i: Intent = Intent(applicationContext, StudentInfo::class.java)
                        i.putExtra("Reg No",regno)
                        startActivity(i);
                    } else {
                        Toast.makeText(this, it.exception.toString(), Toast.LENGTH_SHORT).show()
                    }
                }
            }
            val editor = sharedPreferences.edit()
            editor.putString("username", email)
            editor.putString("regNo", regno)
            editor.putString("password", pass)
            editor.apply()
        }
        register.setOnClickListener {
            val intent: Intent = Intent(this, register_page::class.java)
            startActivity(intent)
        }
        sharedPreferences = getSharedPreferences("userData", Context.MODE_PRIVATE)
        username.setText(sharedPreferences.getString("username", ""))
        regNo.setText(sharedPreferences.getString("regNo", ""))
        password.setText(sharedPreferences.getString("password", ""))
    }
    override fun onBackPressed() {
        finishAffinity()
    }
}