package org.dev.com.api.models

import org.springframework.security.core.GrantedAuthority
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity(name = "TB_ROLE")
data class Role(
    @field:Id
    @field:GeneratedValue(strategy = GenerationType.IDENTITY)
    private val id: Long,
    private val nome: String
) : GrantedAuthority {

    override fun getAuthority(): String = this.nome
}