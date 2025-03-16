package br.edu.fatecpg.alunos.dao


import br.edu.fatecpg.cadastroalunos.model.Aluno
import java.util.*

class AlunoDao private constructor() {

    private val alunos = mutableListOf<Aluno>()

    // Função para inserir aluno
    fun inserir(aluno: Aluno) {
        alunos.add(aluno)
    }

    // Função para obter o último aluno inserido
    fun getUltimo(): Aluno? {
        return alunos.lastOrNull()
    }

    // Função para acessar a instância do DAO
    companion object {
        @Volatile
        private var INSTANCE: AlunoDao? = null

        fun getInstance(): AlunoDao {
            return INSTANCE ?: synchronized(this) {
                val instance = AlunoDao()
                INSTANCE = instance
                instance
            }
        }
    }
}
