package com.isadorasilva.myapp.quartetoelegante

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import android.content.Intent

class CartaoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout_cartao) // ajuste o nome do XML se necessário

        val etNumeroCartao = findViewById<EditText>(R.id.etFullName)      // Número do cartão
        val etValidade = findViewById<EditText>(R.id.etEmail)             // Validade
        val etCVV = findViewById<EditText>(R.id.etPassword)               // CVV
        val etNomeCartao = findViewById<EditText>(R.id.etConfirmPassword) // Nome no cartão

        val btnConfirmar = findViewById<Button>(R.id.btn_confirmar_pagamento)

        btnConfirmar.setOnClickListener {
            val numeroCartao = etNumeroCartao.text.toString().trim()
            val validade = etValidade.text.toString().trim()
            val cvv = etCVV.text.toString().trim()
            val nomeCartao = etNomeCartao.text.toString().trim()

            if (numeroCartao.isEmpty() || validade.isEmpty() || cvv.isEmpty() || nomeCartao.isEmpty()) {
                Toast.makeText(this, "Por favor, preencha todos os campos", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Pagamento confirmado para o cartão: $numeroCartao", Toast.LENGTH_LONG).show()

                // Redirecionar para LoginActivity
                val intent = Intent(this, LoginActivity::class.java)
                startActivity(intent)

                // Finaliza a activity atual para não permitir retorno com botão "voltar"
                finish()
            }
        }
    }
}
