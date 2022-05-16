package org.dev.com.api.services

import org.dev.com.api.models.Curso
import org.dev.com.api.models.Topico
import org.dev.com.api.models.Usuario
import org.springframework.stereotype.Service

@Service
class TopicoService {
    var topicos: List<Topico> = ArrayList()

    init {
        val topico1 = Topico(
            id = 1,
            titulo = "Duvida Kotlin",
            messagem = "Variavel não encontrada",
            curso = Curso(
                id = 1L,
                nome = "Kotlin",
                categoria = "Programação"
            ),
            autor = Usuario(
                id = 1L,
                nome = "Alex",
                email = "alex@alex.com"
            )
        )

        val topico2 = Topico(
            id = 2,
            titulo = "Desabilitar Dev quarkus",
            messagem = "Desabilita o modo Dev",
            curso = Curso(
                id = 2L,
                nome = "Quarkus",
                categoria = "Programação"
            ),
            autor = Usuario(
                id = 2L,
                nome = "Alex",
                email = "alex@alex.com"
            )
        )
        val topico3 = Topico(
            id = 3,
            titulo = "Duvida Kotlin",
            messagem = "Variavel não encontrada",
            curso = Curso(
                id = 3L,
                nome = "Kotlin",
                categoria = "Programação"
            ),
            autor = Usuario(
                id = 3L,
                nome = "Alex",
                email = "alex@alex.com"
            )
        )

        this.topicos = listOf(topico1, topico2, topico3)
    }

    fun listAll(): List<Topico> {
        return this.topicos
    }

    fun findById(id: Long): Topico? {
        return this.topicos.find { id.equals(it.id) };
    }
}