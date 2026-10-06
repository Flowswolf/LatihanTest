package com.example.latihantest

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class RoleActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_role)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val _btnAdmin = findViewById<Button>(R.id.btnAdmin)
        _btnAdmin.setOnClickListener {
            kirimDataKembali("Admin")
        }

        val _btnUser = findViewById<Button>(R.id.btnUser)
        _btnUser.setOnClickListener {
            kirimDataKembali("User")
        }

        val _btnGuest = findViewById<Button>(R.id.btnGuest)
        _btnGuest.setOnClickListener {
            kirimDataKembali("Guest")
        }

    }
    private fun kirimDataKembali(role: String) {
        val intent = Intent()
        intent.putExtra(EXTRA_ROLE, role)
        setResult(RESULT_OK, intent)
        finish() // Menutup RoleActivity dan kembali ke MainActivity
    }

    companion object {
        const val EXTRA_ROLE = "extra_role"
    }


}