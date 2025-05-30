package com.isadorasilva.myapp.quartetoelegante

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class BoletoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout_boleto)

        val tvBoletoCode = findViewById<TextView>(R.id.tvBoletoCode)
        val btnCopyBoleto = findViewById<Button>(R.id.btn_copy_boleto)
        val btnConfirmar = findViewById<Button>(R.id.btn_confirmar_pagamento)

        btnCopyBoleto.setOnClickListener {
            val boletoCode = tvBoletoCode.text.toString()
            val clipboard = getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
            val clip = ClipData.newPlainText("Código do Boleto", boletoCode)
            clipboard.setPrimaryClip(clip)
            Toast.makeText(this, "Código do boleto copiado", Toast.LENGTH_SHORT).show()
        }

        btnConfirmar.setOnClickListener {
            finish() // volta para a tela anterior
        }
    }
}
