package com.seupacote.app

import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class PagamentoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pagamento)

        val radioGroup = findViewById<RadioGroup>(R.id.rg_forma_pagamento)

        val layoutCartao = findViewById<LinearLayout>(R.id.layout_cartao)
        val layoutPix = findViewById<LinearLayout>(R.id.layout_pix)
        val layoutBoleto = findViewById<LinearLayout>(R.id.layout_boleto)

        val btnConfirmar = findViewById<Button>(R.id.btn_confirmar_pagamento)
        val btnCopiarPix = findViewById<Button>(R.id.btn_copiar_pix)

        // Atualiza a visibilidade dos campos conforme a opção selecionada
        radioGroup.setOnCheckedChangeListener { _, checkedId ->
            layoutCartao.visibility = View.GONE
            layoutPix.visibility = View.GONE
            layoutBoleto.visibility = View.GONE

            when (checkedId) {
                R.id.rb_cartao -> layoutCartao.visibility = View.VISIBLE
                R.id.rb_pix -> layoutPix.visibility = View.VISIBLE
                R.id.rb_boleto -> layoutBoleto.visibility = View.VISIBLE
            }
        }

        // Ação do botão Pix (simula cópia da chave)
        btnCopiarPix.setOnClickListener {
            val chavePix = "pagamentos@exemplo.com"
            val clipboard = getSystemService(CLIPBOARD_SERVICE) as android.content.ClipboardManager
            val clip = android.content.ClipData.newPlainText("Chave Pix", chavePix)
            clipboard.setPrimaryClip(clip)
            Toast.makeText(this, "Chave Pix copiada", Toast.LENGTH_SHORT).show()
        }

        // Botão confirmar pagamento
        btnConfirmar.setOnClickListener {
            when (radioGroup.checkedRadioButtonId) {
                R.id.rb_cartao -> {
                    val nome = findViewById<EditText>(R.id.et_nome).text.toString()
                    val numero = findViewById<EditText>(R.id.et_numero_cartao).text.toString()
                    val validade = findViewById<EditText>(R.id.et_validade).text.toString()
                    val cvv = findViewById<EditText>(R.id.et_cvv).text.toString()
                    Toast.makeText(this, "Processando cartão de $nome", Toast.LENGTH_SHORT).show()
                }

                R.id.rb_pix -> {
                    Toast.makeText(this, "Aguardando pagamento via Pix", Toast.LENGTH_SHORT).show()
                }

                R.id.rb_boleto -> {
                    Toast.makeText(this, "Boleto gerado com sucesso", Toast.LENGTH_SHORT).show()
                }

                else -> {
                    Toast.makeText(this, "Selecione uma forma de pagamento", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}
