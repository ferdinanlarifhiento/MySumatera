package com.example.mysumatera

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import java.sql.Connection
import java.sql.DriverManager
import java.sql.SQLException


class MainActivity3 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)

        val buttonNavigate1: Button = findViewById(R.id.btnkembali)
        buttonNavigate1.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
        val buttonNavigate2: Button = findViewById(R.id.btnregister)
        buttonNavigate2.setOnClickListener {
            val intent = Intent(this, MainActivity2::class.java)
            startActivity(intent)
        }
//        val buttonNavigate3: Button = findViewById(R.id.btnlogin)
//        buttonNavigate3.setOnClickListener {
//            val intent = Intent(this, asd::class.java)
//            startActivity(intent)
//        }

        val usernameEditText: EditText = findViewById(R.id.emailedittext)
        val passwordEditText: EditText = findViewById(R.id.passwordedittext)
        val loginButton: Button = findViewById(R.id.btnlogin)

        loginButton.setOnClickListener {
            val email = usernameEditText.text.toString()
            val password = passwordEditText.text.toString()

            if (checkLogin(email, password)) {
                Toast.makeText(this, "Login Successful", Toast.LENGTH_LONG).show()
                // Navigate to next activity or perform desired action
            } else {
                Toast.makeText(this, "Login Failed", Toast.LENGTH_LONG).show()
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

    fun checkLogin(username: String, password: String): Boolean {
        val connection = getConnection()
        connection?.let {
            val query = "SELECT * FROM data_user WHERE username = ? AND password = ?"
            val preparedStatement = it.prepareStatement(query)
            preparedStatement.setString(1, username)
            preparedStatement.setString(2, password)
            val resultSet = preparedStatement.executeQuery()

            val loginSuccessful = resultSet.next()

            resultSet.close()
            preparedStatement.close()
            it.close()

            return loginSuccessful
        }
        return false
    }
}