package com.example.ptms

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.*


class register_page : AppCompatActivity() {
    private lateinit var firebaseAuth: FirebaseAuth
    private lateinit var registerButton: Button
    private lateinit var loginText:TextView
    private lateinit var email:EditText
    private lateinit var username:EditText
    private lateinit var password:EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        setContentView(R.layout.activity_register_page)
        registerButton = findViewById(R.id.registerButton)
        firebaseAuth = FirebaseAuth.getInstance()


        loginText = findViewById(R.id.loginText)

        email = findViewById(R.id.emailId)
        username = findViewById(R.id.registerusername)
        password= findViewById(R.id.registerpassword)
        registerButton?.setOnClickListener{
            val em = email.text.toString()
            val pass = password.text.toString()
            if(em.isNotEmpty() && pass.isNotEmpty() ) {
                firebaseAuth.createUserWithEmailAndPassword(em, pass).addOnCompleteListener {
                    Toast.makeText(this, "User created", Toast.LENGTH_SHORT).show()
                    if (it.isSuccessful) {
                        Toast.makeText(this, "Succesful", Toast.LENGTH_SHORT).show()
                        var i: Intent = Intent(this, LoginPage::class.java)
                        startActivity(i)
                    } else {
                        try {
                            throw it.getException()!!
                        }
                        catch( e:FirebaseAuthInvalidCredentialsException) {
                           Toast.makeText(this,"Invalid Credentials Check your email",Toast.LENGTH_SHORT).show()
                        }catch (e: FirebaseAuthWeakPasswordException) {
                            Toast.makeText(this, "Weak Paasword", Toast.LENGTH_SHORT).show()
                        } catch (e: FirebaseAuthUserCollisionException) {
                            Toast.makeText(this, "Some error! Please try again"+e.toString(), Toast.LENGTH_SHORT).show()
                        } catch (e: Exception) {


                            Toast.makeText(
                                this,
                                it.exception.toString(),
                                Toast.LENGTH_SHORT
                            ).show()
                        }

                    }
                }
            }
            else {
                Toast.makeText(this,"Empty Fields are not allowed",Toast.LENGTH_SHORT).show()
            }


        }
        loginText.setOnClickListener{
            val intent :Intent = Intent(this,LoginPage::class.java)
            startActivity(intent)
        }




    }
}