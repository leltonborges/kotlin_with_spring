package org.dev.com.api.services

import org.dev.com.api.config.toTopico
import org.dev.com.api.config.toTopicoViewDTO
import org.dev.com.api.dtos.NovoTopicoDTO
import org.dev.com.api.dtos.TopicoViewDTO
import org.dev.com.api.models.Curso
import org.dev.com.api.models.Topico
import org.dev.com.api.models.Usuario
import org.springframework.stereotype.Service

@Service
class TopicoService(
    private val cursoService: CursoService,
    private val usuarioService: UsuarioService
) {

    var topicos: List<Topico> = ArrayList()

    init {
        val topico1 = Topico(
            id = 1,
            titulo = "Duvida Kotlin",
            mensagem = "Variavel não encontrada",
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
            mensagem = "Desabilita o modo Dev",
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
            mensagem = "Variavel não encontrada",
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

    fun listAll(): List<TopicoViewDTO> {
        return this.topicos.map(Topico::toTopicoViewDTO)
    }

    fun findById(id: Long): Topico? {
        return this.topicos.find { t -> id.equals(t.id) }
    }

    fun save(dto: NovoTopicoDTO) {
        this.topicos = this.topicos.plus(dto.toTopico(cursoService, usuarioService));
    }

}