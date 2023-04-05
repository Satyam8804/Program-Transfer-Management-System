package com.example.ptms

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class LoginPage : AppCompatActivity() {
    private lateinit var username: EditText
    private lateinit var password: EditText
    private lateinit var loginButton: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_page)
            username = findViewById(R.id.username)
            password = findViewById(R.id.password)
            loginButton = findViewById(R.id.loginButton)

            loginButton.setOnClickListener {
                if (username.text.toString() == "user" && password.text.toString() == "1234") {
                    Toast.makeText(this, "Login Successful!", Toast.LENGTH_SHORT).show()
                    val i:Intent = Intent(applicationContext,FrontPage::class.java)
                    startActivity(i);
                } else {
                    Toast.makeText(this, "Login Failed!", Toast.LENGTH_SHORT).show()

                }
            }
        }

    }
