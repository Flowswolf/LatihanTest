package com.example.latihantest

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.LinearLayout
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
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
        //Implisit Phone
        val _layoutEmail = findViewById<LinearLayout>(R.id.layoutEmail)
        val _tvEmail = findViewById<TextView>(R.id.tvEmail)
        _layoutEmail.setOnClickListener {
            val emailAddress = _tvEmail.text.toString()
            val intent = Intent(Intent.ACTION_SENDTO).apply {
                data = Uri.parse("mailto:$emailAddress")
            }
            startActivity(intent)
        }
        //Implisit Phone
        val _layoutPhone = findViewById<LinearLayout>(R.id.layoutPhone)
        val _tvPhone = findViewById<TextView>(R.id.tvPhone)
        _layoutPhone.setOnClickListener {
            val phonenumber = _tvPhone.text.toString()
            val intent = Intent(Intent.ACTION_DIAL).apply {
                data = Uri.parse("tel:$phonenumber")
            }
            startActivity(intent)
        }

        //Explisit Ambil data dari RoleActivity
        val _layoutRole = findViewById<LinearLayout>(R.id.layoutRole)

        _layoutRole.setOnClickListener {
            val intent = Intent(this, RoleActivity::class.java)
            resultLauncher.launch(intent) // Membuka RoleActivity dan menunggu balasan
        }

        //Untuk Navbar
        val _bottomNav = findViewById<BottomNavigationView>(R.id.bottomNavigation)
        _bottomNav.selectedItemId = R.id.nav_profile
    }
    private val resultLauncher = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) { result ->
        if (result.resultCode == RESULT_OK) {
            // Mengambil string yang dikirim dari RoleActivity
            val selectedRole = result.data?.getStringExtra(RoleActivity.EXTRA_ROLE)

            // Memasang teks role ke TextView
            val _tvRole = findViewById<TextView>(R.id.tvRole)
            _tvRole.text = selectedRole
        }
    }
}