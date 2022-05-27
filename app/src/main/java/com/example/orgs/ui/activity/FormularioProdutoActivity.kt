package com.example.orgs.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import com.dao.ProdutosDao
import com.example.orgs.R
import com.example.orgs.model.Produto
import java.math.BigDecimal

class FormularioProdutoActivity : AppCompatActivity(R.layout.activity_formulario_produto) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val botaSalvar = findViewById<Button>(R.id.botao_salvar)
        botaSalvar.setOnClickListener {
            val campoNome = findViewById<EditText>(R.id.nome)
            val nome = campoNome.text.toString()
            val campoDescricao = findViewById<EditText>(R.id.descricao)
            val descricao = campoDescricao.text.toString()
            val campoValor = findViewById<EditText>( R.id.valor)
            val valorEmTexto = campoValor.text.toString()
            val valor =if(valorEmTexto.isBlank()){
                BigDecimal.ZERO
            }else{
                BigDecimal(valorEmTexto)
            }

            val produtoNovo =  Produto(
                    nome = nome,
                    descricao = descricao,
                    valor = valor
                )
            val produtosDao = ProdutosDao()
            produtosDao.adiciona(produtoNovo)
            finish()
        }
    }
}