package com.example.firstapplicationwithgit

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val userLogin: EditText = findViewById(R.id.user_login_reg)
        val userEmail: EditText = findViewById(R.id.user_email_reg)
        val userPass: EditText = findViewById(R.id.user_pass_reg)
        val button: Button = findViewById(R.id.button_reg)

        button.setOnClickListener {
            val login = userLogin.text.toString().trim()
            val email = userEmail.text.toString().trim()
            val pass = userPass.text.toString().trim()

            if (login == "" || email == "" || pass == "")
                Toast.makeText(this, "Not all plains are filled", Toast.LENGTH_SHORT).show()
            else {
                val user = User(login, email, pass)

                val db = dbHelper(this, null)
                db.addUser(user)

                Toast.makeText(this, "User $login is registered", Toast.LENGTH_SHORT).show()
                userLogin.text.clear()
                userEmail.text.clear()
                userPass.text.clear()
            }
        }

        val linkToAuth: TextView = findViewById(R.id.link_to_auth)

        linkToAuth.setOnClickListener{
            val intent = Intent(this, AuthActivity::class.java)
            startActivity(intent)
        }
    }
}