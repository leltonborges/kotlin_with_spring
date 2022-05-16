package org.dev.com.api.dtos

data class NovoTopicoDTO(
    val titulo: String,
    val mensagem: String,
    val idCurso: Long,
    val idAutor: Long
)