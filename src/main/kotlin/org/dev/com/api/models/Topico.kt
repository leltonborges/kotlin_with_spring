package org.dev.com.api.models

import java.io.Serializable
import java.time.LocalDateTime
import javax.persistence.*
import javax.validation.constraints.NotEmpty

@Entity(name = "tb_topico")
data class Topico(
    @field:Id @field:GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    var titulo: String,
    var mensagem: String,
    val dataCriacao: LocalDateTime = LocalDateTime.now(),
    @field:ManyToOne
    val curso: Curso,
    @field:ManyToOne
    val autor: Usuario,
    @field:Enumerated(EnumType.STRING)
    val status: StatusTopico = StatusTopico.NAO_RESPONDIDO,
    @field:OneToMany(mappedBy = "topico")
//    @OneToMany(mappedBy = "topico")
    val respostas: List<Resposta> = ArrayList()
) : Serializable