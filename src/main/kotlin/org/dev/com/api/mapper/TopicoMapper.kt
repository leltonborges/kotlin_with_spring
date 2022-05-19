package org.dev.com.api.mapper

import org.dev.com.api.dtos.NovoTopicoDTO
import org.dev.com.api.models.Topico
import org.dev.com.api.services.CursoService
import org.dev.com.api.services.UsuarioService
import org.springframework.stereotype.Component

@Component
class TopicoMapper(
    private val cursoService: CursoService,
    private val usuarioService: UsuarioService
) : Mapper<NovoTopicoDTO, Topico> {
    override fun map(source: NovoTopicoDTO): Topico {
        return Topico(
            titulo = source.titulo,
            mensagem = source.mensagem,
            curso = cursoService.findById(source.idCurso),
            autor = usuarioService.findById(source.idAutor)
        )
    }
}