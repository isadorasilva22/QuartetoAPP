package com.isadorasilva.myapp.quartetoelegante

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val lionButton = findViewById<ImageButton>(R.id.lionButton)
        val elefanteButton = findViewById<ImageButton>(R.id.elefanteButton)
        val focaButton = findViewById<ImageButton>(R.id.focaButton)

        val irParaCadastro = Intent(this, CadastroActivity::class.java)

        lionButton.setOnClickListener { startActivity(irParaCadastro) }
        elefanteButton.setOnClickListener { startActivity(irParaCadastro) }
        focaButton.setOnClickListener { startActivity(irParaCadastro) }
    }
}
