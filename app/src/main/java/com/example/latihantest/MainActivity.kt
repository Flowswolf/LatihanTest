package com.example.latihantest

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.LinearLayout
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val _layoutEmail = findViewById<LinearLayout>(R.id.layoutEmail)
        val _tvEmail = findViewById<TextView>(R.id.tvEmail)
        _layoutEmail.setOnClickListener {
            val emailAddress = _tvEmail.text.toString()
            val intent = Intent(Intent.ACTION_SENDTO).apply {
                data = Uri.parse("mailto:$emailAddress")
            }
            startActivity(intent)
        }

        val _layoutPhone = findViewById<LinearLayout>(R.id.layoutPhone)
        val _tvPhone = findViewById<TextView>(R.id.tvPhone)
        _layoutPhone.setOnClickListener {
            val phonenumber = _tvPhone.text.toString()
            val intent = Intent(Intent.ACTION_DIAL).apply {
                data = Uri.parse("tel:$phonenumber")
            }
            startActivity(intent)
        }


        val _bottomNav = findViewById<BottomNavigationView>(R.id.bottomNavigation)
        _bottomNav.selectedItemId = R.id.nav_profile
    }
}