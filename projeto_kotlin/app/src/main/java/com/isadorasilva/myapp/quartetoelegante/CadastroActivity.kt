package com.isadorasilva.myapp.quartetoelegante

import android.content.Intent
import android.os.Bundle
import android.util.Patterns
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class CadastroActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastro)

        val fullName = findViewById<EditText>(R.id.etFullName)
        val email = findViewById<EditText>(R.id.etEmail)
        val password = findViewById<EditText>(R.id.etPassword)
        val confirmPassword = findViewById<EditText>(R.id.etConfirmPassword)
        val registerButton = findViewById<Button>(R.id.btnRegister)

        registerButton.setOnClickListener {
            val nameInput = fullName.text.toString().trim()
            val emailInput = email.text.toString().trim()
            val passwordInput = password.text.toString()
            val confirmInput = confirmPassword.text.toString()

            // Validações
            when {
                nameInput.isEmpty() || emailInput.isEmpty() || passwordInput.isEmpty() || confirmInput.isEmpty() -> {
                    showToast("Preencha todos os campos.")
                }
                !Patterns.EMAIL_ADDRESS.matcher(emailInput).matches() -> {
                    showToast("E-mail inválido.")
                }
                passwordInput.length < 6 -> {
                    showToast("A senha deve ter no mínimo 6 caracteres.")
                }
                passwordInput != confirmInput -> {
                    showToast("As senhas não coincidem.")
                }
                else -> {
                    // Tudo certo, vai para a MainActivity
                    val intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)
                    finish()
                }
            }
        }
    }

    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}
