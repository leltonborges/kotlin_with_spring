package org.dev.com.api.models

import java.io.Serializable
import java.time.LocalDateTime
import javax.persistence.*
import javax.validation.constraints.NotEmpty

@Entity(name = "tb_topico")
data class Topico(
    @field:Id @field:GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    @field:Column(name="TITULO")
    var titulo: String,

    @field:Column(name="MENSAGEM")
    var mensagem: String,

    @field:Column(name="DATA_CRIACAO")
    val dataCriacao: LocalDateTime = LocalDateTime.now(),

    @field:JoinColumn(name="ID_CURSO")
    @field:ManyToOne
    val curso: Curso,

    @field:JoinColumn(name="ID_AUTOR")
    @field:ManyToOne
    val autor: Usuario,

    @field:Column(name="STATUS")
    @field:Enumerated(EnumType.STRING)
    val status: StatusTopico = StatusTopico.NAO_RESPONDIDO,

    @field:OneToMany(mappedBy = "topico")
//    @OneToMany(mappedBy = "topico")
    val respostas: List<Resposta> = ArrayList()
) : Serializable