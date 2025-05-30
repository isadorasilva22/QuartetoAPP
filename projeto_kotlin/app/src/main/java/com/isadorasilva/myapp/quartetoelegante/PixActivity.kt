package com.isadorasilva.myapp.quartetoelegante

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Intent // <-- Import necessário
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class PixActivity : AppCompatActivity() {

    private val codigoPix = "00020126580014BR.GOV.BCB.PIX0114+55119999999990214Compra XYZ520400005303986540510005802BR5913Nome do Recebedor6009Sao Paulo62070503***63041D3D"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout_pix)

        val tvPixCode = findViewById<TextView>(R.id.tvPixCode)
        val btnCopiarPix = findViewById<Button>(R.id.btn_copy_pix)
        val btnConfirmarPagamento = findViewById<Button>(R.id.btn_confirmar_pagamento)

        // Setar o código Pix na TextView
        tvPixCode.text = codigoPix

        // Botão para copiar o código Pix para a área de transferência
        btnCopiarPix.setOnClickListener {
            val clipboard = getSystemService(CLIPBOARD_SERVICE) as ClipboardManager
            val clip = ClipData.newPlainText("Código Pix", codigoPix)
            clipboard.setPrimaryClip(clip)
            Toast.makeText(this, "Código Pix copiado", Toast.LENGTH_SHORT).show()
        }

        // Botão "Confirmar Pagamento" leva para a LoginActivity
        btnConfirmarPagamento.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
            finish() // Opcional: encerra a tela atual
        }
    }
}
