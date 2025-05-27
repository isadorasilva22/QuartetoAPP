package com.isadorasilva.quartetoelegante

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.seu_layout_xml) // Substitua pelo nome real do seu XML

        // Botão "Ver Mais"
        val verMaisButton = findViewById<Button>(R.id.tickets_button)
        verMaisButton.setOnClickListener {
            val intent = Intent(this, ActivityDatas::class.java)
            startActivity(intent)
        }

        // Botões de animais (todos levam à tela de pagamento)
        val lionButton = findViewById<ImageButton>(R.id.lionButton)
        val elefanteButton = findViewById<ImageButton>(R.id.elefanteButton)
        val focaButton = findViewById<ImageButton>(R.id.focaButton)

        val irParaPagamento = Intent(this, ActivityPagamento::class.java)

        lionButton.setOnClickListener { startActivity(irParaPagamento) }
        elefanteButton.setOnClickListener { startActivity(irParaPagamento) }
        focaButton.setOnClickListener { startActivity(irParaPagamento) }
    }
}
