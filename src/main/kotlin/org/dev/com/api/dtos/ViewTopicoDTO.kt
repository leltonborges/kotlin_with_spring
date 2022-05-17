package org.dev.com.api.dtos

import org.dev.com.api.models.StatusTopico
import java.time.LocalDateTime

data class ViewTopicoDTO(
    val id: Long?,
    val titulo: String,
    val messagem: String,
    val status: StatusTopico,
    val dataCriacao: LocalDateTime
)