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
    private lateinit var regNo:EditText
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
            var regno = regNo.text.toString()
            if (email.isNotEmpty() && pass.isNotEmpty() && regno.isNotEmpty() ) {
                firebaseAuth.signInWithEmailAndPassword(email, pass).addOnCompleteListener {
                    if (it.isSuccessful) {
                        val i: Intent = Intent(applicationContext, studentInfo::class.java)
                        i.putExtra("Reg No",regno)
                        startActivity(i);
                    } else {
                        Toast.makeText(this, it.exception.toString(), Toast.LENGTH_SHORT).show()

                    }

                }
            }
        }
        register.setOnClickListener {
            val intent: Intent = Intent(this, register_page::class.java)
            startActivity(intent)
        }
    }


}
