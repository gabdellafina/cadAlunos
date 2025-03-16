package br.edu.fatecpg.cadastroalunos

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import br.edu.fatecpg.alunos.dao.AlunoDao
import com.google.android.material.floatingactionbutton.FloatingActionButton
import kotlin.random.Random

class InfoAluno : AppCompatActivity(R.layout.activity_info_aluno) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val dao = AlunoDao.getInstance()
        val aluno = dao.getUltimo()

        val txtNome = findViewById<TextView>(R.id.txtNome)
        val txtMatricula = findViewById<TextView>(R.id.txtMatricula)
        val fabVoltar = findViewById<FloatingActionButton>(R.id.fabVoltar)
        val btnMatricula = findViewById<Button>(R.id.btnMatricula)

        aluno?.let {
            txtNome.text = "Nome: ${it.nome}"

            btnMatricula.setOnClickListener {
                // Gerando número de matrícula aleatório
                val matricula = Random.nextInt(1000, 9999)
                txtMatricula.text = "Matrícula: $matricula"
            }

            fabVoltar.setOnClickListener {
                finish()
            }
        }
    }
}
