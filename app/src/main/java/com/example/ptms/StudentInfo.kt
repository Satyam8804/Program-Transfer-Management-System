

package com.example.ptms

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.net.Uri
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.bumptech.glide.Glide
import com.google.android.material.navigation.NavigationView
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ktx.childEvents
import de.hdodenhof.circleimageview.CircleImageView


class StudentInfo : AppCompatActivity() {

    lateinit var drawerLayout: DrawerLayout
    lateinit var navigationView: NavigationView
    lateinit var toolbar: Toolbar
    lateinit var student_age:TextView
    lateinit var student_id:TextView
    lateinit var student_email:TextView
    lateinit var student_gpa:TextView
    lateinit var student_contact:TextView
    lateinit var student_program:TextView
    lateinit var student_name:TextView
    lateinit var image:CircleImageView
    lateinit var databaseReference: DatabaseReference
    lateinit var databaseReference2: DatabaseReference

    private lateinit var sharedPreferences: SharedPreferences
    lateinit var reg:String
    @SuppressLint("MissingInflatedId", "SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_student_info)
        databaseReference = FirebaseDatabase.getInstance().getReference("Users")

        sharedPreferences = getSharedPreferences("userData", Context.MODE_PRIVATE)

        reg = sharedPreferences.getString("regNo", "").toString();
        student_name = findViewById(R.id.student_name)
        student_age = findViewById(R.id.student_age)
        student_id= findViewById(R.id.student_id)
        student_email=findViewById(R.id.student_email)
        student_gpa = findViewById(R.id.student_gpa)
        student_contact = findViewById(R.id.student_contact)
        student_program = findViewById(R.id.student_program)
        image = findViewById(R.id.imageView3)


        databaseReference.child(reg).get().addOnSuccessListener {
            if(it.exists()){
                val name = it.child("name").value
                val em= it.child("email").value
                val regNo = it.child("regNo").value
                val cgpa = it.child("cgpa").value
                val contact = it.child("contactNo").value
                val program = it.child("program").value
                student_name.text = name.toString()
                student_email.text = "Email : "+em.toString()
                student_id.text = "ID : "+regNo.toString()
                student_gpa.text = "CGPA : "+cgpa.toString()
                student_contact.text = "Contact No : "+contact.toString()
                student_program.text = "Program : "+program.toString()

            }
        }
//        }

        databaseReference2 = FirebaseDatabase.getInstance().getReference("Images")
         databaseReference2.child(FirebaseAuth.getInstance().currentUser!!.uid).get().addOnSuccessListener {
            if(it.exists()){
                val uri = it.child("uri").value.toString()
                image.setImageURI(Uri.parse(uri))
                Glide.with(this).load(uri).into(image)
            }
        }
        val border = image.getBackground()
        drawerLayout = findViewById(R.id.drawerLayout)
        navigationView = findViewById(R.id.menuBar)
        toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        val toggle = ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.navigation_open,R.string.navigation_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState()

        navigationView.setNavigationItemSelectedListener{  menuItem ->
            when (menuItem.itemId) {
                R.id.transfer_button_menu ->{
                    val i = Intent(this,FrontPage::class.java)
                    startActivity(i)
                }
                R.id.log_out->{
                    val i = Intent(this,LoginPage::class.java)
                    startActivity(i)
                }
            }
            drawerLayout.closeDrawer(GravityCompat.START)
            true
        };
    }
}

