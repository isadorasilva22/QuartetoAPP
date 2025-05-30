package com.isadorasilva.myapp.quartetoelegante

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class PagamentoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pagamento) // layout com os 3 botões

        val btnCartao = findViewById<Button>(R.id.btn_cartao)
        val btnPix = findViewById<Button>(R.id.btn_pix)
        val btnBoleto = findViewById<Button>(R.id.btn_boleto)

        btnCartao.setOnClickListener {
            val intent = Intent(this, CartaoActivity::class.java)
            startActivity(intent)
        }

        btnPix.setOnClickListener {
            val intent = Intent(this, PixActivity::class.java)
            startActivity(intent)
        }

        btnBoleto.setOnClickListener {
            val intent = Intent(this, BoletoActivity::class.java)
            startActivity(intent)
        }
    }
}
