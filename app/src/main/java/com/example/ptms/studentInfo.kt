package com.example.ptms

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.view.menu.MenuView.ItemView
import androidx.appcompat.widget.Toolbar
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationView
import android.content.Intent
import android.view.Gravity
import android.view.MenuItem
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.core.view.GravityCompat
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import org.w3c.dom.Text

class studentInfo : AppCompatActivity() {

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
    lateinit var databaseReference: DatabaseReference

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_student_info)
        var reg = intent.getStringExtra("Reg No")
        student_name = findViewById(R.id.student_name)
        student_age = findViewById(R.id.student_age)
        student_id= findViewById(R.id.student_id)
        student_email=findViewById(R.id.student_email)
        student_gpa = findViewById(R.id.student_gpa)
        student_contact = findViewById(R.id.student_contact)
        student_program = findViewById(R.id.student_program)

        databaseReference = FirebaseDatabase.getInstance().getReference("Users")
        if (reg != null) {
            databaseReference.child(reg).get().addOnSuccessListener {
                if(it.exists()){
                    val name = it.child("name").value
                    val em= it.child("email").value
                    val regNo = it.child("regNo").value
                    val cgpa = it.child("cgpa").value
                    val contact = it.child("contact").value
                    val program = it.child("program").value
                    student_name.setText(name.toString())
                    student_email.setText("Email : "+em.toString())
                    student_id.setText("ID : "+regNo.toString())
                    student_gpa.setText("CGPA : "+cgpa.toString())
                    student_contact.setText("Contact No : "+contact.toString())
                    student_program.setText("Program Enrolled : "+program.toString())



                }
            }
        }




        drawerLayout = findViewById(R.id.drawerLayout)
        navigationView = findViewById(R.id.menuBar)
        toolbar = findViewById(R.id.toolbar)


        setSupportActionBar(toolbar)

        val toggle = ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.navigation_open,R.string.navigation_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState()

        navigationView.setNavigationItemSelectedListener{  menuItem ->
            when (menuItem.itemId) {
                R.id.home -> {
                    // Handle home click
                    Toast.makeText(this, "Clicked Home", Toast.LENGTH_SHORT).show()
                }
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