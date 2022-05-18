package org.dev.com.api.models

import java.time.LocalDateTime
import javax.persistence.*

@Entity
data class Resposta(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    val messagem: String,
    val dataCriacao: LocalDateTime = LocalDateTime.now(),
    @ManyToOne
    val autor: Usuario,
    @ManyToOne
    val topico: Topico,
    val solucao: Boolean
) {
    constructor() : this(null, "", LocalDateTime.now(), Usuario(), Topico(), false)
}
