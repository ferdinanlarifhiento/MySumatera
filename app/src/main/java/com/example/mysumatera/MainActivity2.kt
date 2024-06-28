package com.example.mysumatera

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import java.sql.Connection
import java.sql.DriverManager
import java.sql.SQLException

class MainActivity2 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        val buttonNavigate1: Button = findViewById(R.id.btnkembali)
        buttonNavigate1.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
//        val buttonregistrasi: Button = findViewById(R.id.daftar)
//        buttonregistrasi.setOnClickListener {
//            val intent = Intent(this, asd::class.java)
//            startActivity(intent)
//        }
        val namadepan: EditText = findViewById(R.id.namadepan)
        val namabelakang: EditText = findViewById(R.id.namabelakang)
        val email: EditText = findViewById(R.id.email)
        val password: EditText = findViewById(R.id.password1)
        val registerButton: Button = findViewById(R.id.daftar)

        registerButton.setOnClickListener {
            val depan = namadepan.text.toString()
            val belakang = namabelakang.text.toString()
            val mail = email.text.toString()
            val pwd = password.text.toString()
            val role = 2

            if (depan.isNotEmpty() && belakang.isNotEmpty() && mail.isNotEmpty() && pwd.isNotEmpty()) {
                if (insertUser(depan, belakang, mail, pwd, role)) {
                    Toast.makeText(this, "User Registered Successfully", Toast.LENGTH_LONG).show()
                    // Navigate to next activity or perform desired action
                    val intent = Intent(this, asd::class.java)
                    startActivity(intent)
                } else {
                    Toast.makeText(this, "Registration Failed", Toast.LENGTH_LONG).show()
                }
            } else {
                Toast.makeText(this, "Please enter username and password", Toast.LENGTH_LONG).show()
            }
        }
    }
    private fun getConnection(): Connection? {
        val url = "jdbc:mysql://localhost:3306/mydb"
        val user = "user"
        val password = "password"

        return try {
            DriverManager.getConnection(url, user, password)
        } catch (e: SQLException) {
            e.printStackTrace()
            null
        }
    }

    private fun insertUser(namadepan: String, namabelakang: String, email: String, password: String, role: Int): Boolean {
        val connection = getConnection()
        connection?.let {
            val pp= getString(R.string.pp)

            val query = "INSERT INTO users (namadepan, namabelakang, email, password, pp, role) VALUES (?, ?, ?, ?, ?, ?)"
            val preparedStatement = it.prepareStatement(query)
            preparedStatement.setString(1, namadepan)
            preparedStatement.setString(2, namabelakang)
            preparedStatement.setString(3, email)
            preparedStatement.setString(4, password)
            preparedStatement.setString(5, pp)
            preparedStatement.setInt(6, role)

            return try {
                preparedStatement.executeUpdate() > 0
            } catch (e: SQLException) {
                e.printStackTrace()
                false
            } finally {
                preparedStatement.close()
                it.close()
            }
        }
        return false
    }
}