package org.dev.com.api.services

import org.dev.com.api.config.toTopicoViewDTO
import org.dev.com.api.dtos.AtualizarTopicoDTO
import org.dev.com.api.dtos.NovoTopicoDTO
import org.dev.com.api.dtos.ViewTopicoDTO
import org.dev.com.api.mapper.TopicoMapper
import org.dev.com.api.mapper.TopicoViewMapper
import org.dev.com.api.models.Curso
import org.dev.com.api.models.Topico
import org.dev.com.api.models.Usuario
import org.springframework.stereotype.Service

@Service
class TopicoService(
    private val topicoMapper: TopicoMapper,
    private val topicoViewMapper: TopicoViewMapper
){

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

    fun listAll(): List<ViewTopicoDTO> {
        return this.topicos.map(Topico::toTopicoViewDTO)
//        return this.topicos.map(topicoViewMapper::map)
    }

    fun findById(id: Long): ViewTopicoDTO {
        return this.topicos
            .stream()
            .filter { t -> id == t.id }
            .map(topicoViewMapper::map)
            .findFirst()
            .get()
    }

    fun save(dto: NovoTopicoDTO): ViewTopicoDTO {
        val topico = topicoMapper.map(dto)
        this.topicos = this.topicos.plus(topico);
        return topicoViewMapper.map(topico)
    }

    fun atualizar(dto: AtualizarTopicoDTO): ViewTopicoDTO {
        val topico = topicos
            .stream()
            .filter { t -> dto.id == t.id }
            .findFirst()
            .get()

        val topicoAtualizado = Topico(
            id = dto.id,
            titulo = dto.titulo,
            mensagem = dto.mensagem,
            curso = topico.curso,
            autor = topico.autor,
            status = topico.status,
            respostas = topico.respostas,
            dataCriacao = topico.dataCriacao
        )
        topicos = topicos.minus(topico).plus(topicoAtualizado)

        return topicoViewMapper.map(topicoAtualizado)
    }

    fun delete(id: Long) {
        val topico = topicos
            .stream()
            .filter { t -> id == t.id }
            .findFirst()
            .get()

        topicos = topicos.minus(topico)
    }

}