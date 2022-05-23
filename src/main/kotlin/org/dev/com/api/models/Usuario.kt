package org.dev.com.api.models

import java.io.Serializable
import javax.persistence.*

@Entity(name = "tb_usuario")
data class Usuario(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    val nome: String,
    val email: String,
    val senha: String,

    @field:OneToMany(fetch = FetchType.EAGER)
    @field:JoinTable(
        name = "TB_USUARIO_ROLE",
        joinColumns = [JoinColumn(name = "ID_USUARIO", referencedColumnName = "ID")],
        inverseJoinColumns = [JoinColumn(name = "ID_ROLE", referencedColumnName = "ID")]
    )
    val roles: List<Role> = mutableListOf()
) : Serializable
