package org.dev.com.api.models

import java.time.LocalDateTime

data class Resposta(
    val id: Long? = null,
    val messagem: String,
    val dataCriacao: LocalDateTime = LocalDateTime.now(),
    val autor: Usuario,
    val topico: Topico,
    val solucao: Boolean
)
