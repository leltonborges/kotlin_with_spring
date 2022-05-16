package org.dev.com.api.dtos

import javax.validation.constraints.NotEmpty
import javax.validation.constraints.NotNull
import javax.validation.constraints.Size

data class NovoTopicoDTO(
    @field:NotEmpty @field:Size(min = 5, max = 50) val titulo: String,
    @field:NotEmpty @field:Size(min = 5, max = 50) val mensagem: String,
    @field:NotNull val idCurso: Long,
    @field:NotNull val idAutor: Long
)