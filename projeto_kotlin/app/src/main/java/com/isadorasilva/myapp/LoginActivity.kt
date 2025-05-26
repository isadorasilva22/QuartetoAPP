package com.isadorasilva.quartetoelegante

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val loginButton = findViewById<Button>(R.id.login_button)
        loginButton.setOnClickListener {
            // Aqui você pode verificar login antes, se quiser
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish() // opcional: fecha a tela de login
        }
    }
}

