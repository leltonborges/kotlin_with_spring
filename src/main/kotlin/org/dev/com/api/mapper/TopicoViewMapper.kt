package org.dev.com.api.mapper

import org.dev.com.api.dtos.TopicoViewDTO
import org.dev.com.api.models.Topico
import org.springframework.stereotype.Component

@Component
class TopicoViewMapper : Mapper<Topico, TopicoViewDTO> {
    override fun map(source: Topico): TopicoViewDTO {
        return TopicoViewDTO(
            id = source.id,
            titulo = source.titulo,
            messagem = source.mensagem,
            status = source.status,
            dataCriacao = source.dataCriacao
        )
    }
}