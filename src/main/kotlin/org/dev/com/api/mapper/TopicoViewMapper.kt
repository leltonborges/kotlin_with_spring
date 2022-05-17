package org.dev.com.api.mapper

import org.dev.com.api.dtos.ViewTopicoDTO
import org.dev.com.api.models.Topico
import org.springframework.stereotype.Component

@Component
class TopicoViewMapper : Mapper<Topico, ViewTopicoDTO> {
    override fun map(source: Topico): ViewTopicoDTO {
        return ViewTopicoDTO(
            id = source.id,
            titulo = source.titulo,
            messagem = source.mensagem,
            status = source.status,
            dataCriacao = source.dataCriacao
        )
    }
}