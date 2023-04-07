package com.example.ptms

import android.content.Intent
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
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_login_page)
        username = findViewById(R.id.username)
        password = findViewById(R.id.password)
        loginButton = findViewById(R.id.loginButton)
        register = findViewById(R.id.signupText)
        firebaseAuth = FirebaseAuth.getInstance()

        loginButton.setOnClickListener {
            val regno= username.text.toString()
            val pass = password.text.toString()
            if (regno.isNotEmpty() && pass.isNotEmpty()) {
                firebaseAuth.signInWithEmailAndPassword(regno, pass).addOnCompleteListener {
                    if (it.isSuccessful) {
                        val i: Intent = Intent(applicationContext, FrontPage::class.java)
                        startActivity(i);
                    } else {
                        Toast.makeText(this, it.exception.toString(), Toast.LENGTH_SHORT).show()

                    }

                }
            }
        }
        register.setOnClickListener {
            var intent: Intent = Intent(this, register_page::class.java)
            startActivity(intent)
        }
    }


}
