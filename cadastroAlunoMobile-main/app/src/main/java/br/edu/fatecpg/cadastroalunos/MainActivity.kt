package br.edu.fatecpg.cadastroalunos

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import br.edu.fatecpg.alunos.dao.AlunoDao
import br.edu.fatecpg.cadastroalunos.model.Aluno

class MainActivity : AppCompatActivity(R.layout.activity_main) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val edtNome = findViewById<EditText>(R.id.edtAluno)
        val btnCadastrar = findViewById<Button>(R.id.btnCadastrar)
        val dao = AlunoDao.getInstance()

        btnCadastrar.setOnClickListener {
            val nome = edtNome.text.toString()
            val aluno = Aluno(nome)
            dao.inserir(aluno)

            // Passa para a próxima tela para exibir a matrícula
            val intent = Intent(this, InfoAluno::class.java)
            startActivity(intent)
        }
    }
}
