package com.example.mysumatera

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button


class MainActivity : AppCompatActivity() {

override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    val buttonNavigate: Button = findViewById(R.id.login)
    buttonNavigate.setOnClickListener {
        val intent = Intent(this, MainActivity3::class.java)
        startActivity(intent)
    }
        val buttonNavigate2: Button = findViewById(R.id.register)
        buttonNavigate2.setOnClickListener {
            val intent = Intent(this, MainActivity2::class.java)
            startActivity(intent)
        }
    }
}