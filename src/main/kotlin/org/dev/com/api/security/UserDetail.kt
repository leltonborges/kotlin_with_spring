package org.dev.com.api.security

import org.dev.com.api.models.Usuario
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.userdetails.UserDetails

data class UserDetail(
    private val usuario: Usuario
) : UserDetails {
    override fun getAuthorities(): MutableCollection<out GrantedAuthority>? = null

    override fun getPassword(): String = this.usuario.senha;

    override fun getUsername(): String = this.usuario.email

    override fun isAccountNonExpired(): Boolean = true

    override fun isAccountNonLocked(): Boolean = true

    override fun isCredentialsNonExpired(): Boolean = true

    override fun isEnabled(): Boolean = true
}
