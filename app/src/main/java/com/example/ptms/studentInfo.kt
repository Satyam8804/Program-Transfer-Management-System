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
import android.widget.Toast
import androidx.core.view.GravityCompat

class studentInfo : AppCompatActivity() {

    lateinit var drawerLayout: DrawerLayout
    lateinit var navigationView: NavigationView
    lateinit var toolbar: Toolbar

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_student_info)

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

