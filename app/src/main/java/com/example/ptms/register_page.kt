package com.example.ptms

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException
import com.google.firebase.auth.FirebaseAuthUserCollisionException
import com.google.firebase.auth.FirebaseAuthWeakPasswordException
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class register_page : AppCompatActivity() {
    private lateinit var firebaseAuth: FirebaseAuth
    private lateinit var registerButton: Button
    private lateinit var loginText:TextView
    private lateinit var email:EditText
    private lateinit var username:EditText
    private lateinit var password:EditText
    private lateinit var contact:EditText
    private lateinit var name:EditText
    private lateinit var db:FirebaseDatabase
    private lateinit var reference: DatabaseReference
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_register_page)
        registerButton = findViewById(R.id.registerButton)
        firebaseAuth = FirebaseAuth.getInstance()
        db = FirebaseDatabase.getInstance()

        loginText = findViewById(R.id.loginText)
        email = findViewById(R.id.emailId)
        username = findViewById(R.id.registerusername)
        password= findViewById(R.id.registerpassword)
        name = findViewById(R.id.Name)
        contact = findViewById(R.id.contactNo)
        registerButton.setOnClickListener{
            val uname = username.text.toString()
            val em = email.text.toString()
            val pass = password.text.toString()
            val nam = name.text.toString()
            val cont = contact.text.toString()
            if(em.isNotEmpty() && pass.isNotEmpty() && uname.isNotEmpty()&& nam.isNotEmpty() && cont.isNotEmpty() ) {
                firebaseAuth.createUserWithEmailAndPassword(em, pass).addOnCompleteListener {
                    if (it.isSuccessful) {
                        Toast.makeText(this, "User created", Toast.LENGTH_SHORT).show()
                        realtimeDatabase(nam ,em,uname,8.5f,"Btech CSE",cont)
                        val i: Intent = Intent(this, LoginPage::class.java)
                        startActivity(i)
                    } else {
                        try {
                            throw it.exception!!
                        } catch( e: FirebaseAuthInvalidCredentialsException) {
                            Toast.makeText(this,"Invalid Credentials Check your email",Toast.LENGTH_SHORT).show()
                        }catch (e: FirebaseAuthWeakPasswordException) {
                            Toast.makeText(this, "Weak Paasword", Toast.LENGTH_SHORT).show()
                        } catch (e: FirebaseAuthUserCollisionException) {
                            Toast.makeText(this, "Some error! Please try again$e", Toast.LENGTH_SHORT).show()
                        } catch (e: Exception) {
                            Toast.makeText(
                                this,
                                it.exception.toString(),
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                    }
                }
            } else {
                Toast.makeText(this,"Empty Fields are not allowed",Toast.LENGTH_SHORT).show()
            }
        }
        loginText.setOnClickListener{
            val intent :Intent = Intent(this,LoginPage::class.java)
            startActivity(intent)
        }
    }
    private fun realtimeDatabase(nam:String, em:String, uname:String, cgpa:Float, program:String, cont:String) {
        val users = User(nam, em, uname, cgpa, program, cont)
        reference = FirebaseDatabase.getInstance().getReference("Users")
        reference.child(uname).setValue(users).addOnCompleteListener{
            if(it.isSuccessful) {
                Toast.makeText(this, "Your data saved ", Toast.LENGTH_SHORT).show()
            }

        }
    }

}