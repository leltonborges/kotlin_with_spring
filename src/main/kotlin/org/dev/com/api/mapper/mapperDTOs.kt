package org.dev.com.api.config

import org.dev.com.api.dtos.NovoTopicoDTO
import org.dev.com.api.dtos.TopicoViewDTO
import org.dev.com.api.models.Topico
import org.dev.com.api.services.CursoService
import org.dev.com.api.services.UsuarioService

fun NovoTopicoDTO.toTopico(cursoService: CursoService, usuarioService: UsuarioService): Topico {
    return Topico(
        id = IntRange(1, 100).random().toLong(),
        titulo = this.titulo,
        mensagem = this.mensagem,
        curso = cursoService.findById(this.idCurso),
        autor = usuarioService.findById(this.idAutor)
    )
}

fun Topico.toTopicoViewDTO(): TopicoViewDTO {
    return TopicoViewDTO(
        id = this.id,
        titulo = this.titulo,
        messagem = this.mensagem,
        status = this.status,
        dataCriacao = this.dataCriacao
    )
}