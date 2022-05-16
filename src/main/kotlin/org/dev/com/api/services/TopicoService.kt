package org.dev.com.api.services

import org.dev.com.api.models.Curso
import org.dev.com.api.models.Topico
import org.dev.com.api.models.Usuario
import org.springframework.stereotype.Service

@Service
class TopicoService {

    fun listAll(): List<Topico> {
        val topico = Topico(
            id = 12,
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
        return listOf(topico, topico, topico, topico)
    }
}