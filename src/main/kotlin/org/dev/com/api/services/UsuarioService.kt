package org.dev.com.api.services

import org.dev.com.api.exceptions.NotFoundException
import org.dev.com.api.models.Usuario
import org.dev.com.api.repositories.UsuarioRepository
import org.dev.com.api.security.UserDetail
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.stereotype.Service

@Service
class UsuarioService(
    private val repository: UsuarioRepository
) : UserDetailsService {

    fun findAll(): List<Usuario> {
        return this.repository.findAll();
    }

    fun findById(id: Long): Usuario {
        return this.repository
            .findById(id)
            .orElseThrow { NotFoundException("Usuario não encontrado: $id") }
    }

    override fun loadUserByUsername(username: String?): UserDetail {
        val usuario =
            this.repository.findByEmail(username)
                ?: throw NotFoundException("dados invalidos para: $username");

        return UserDetail(usuario)
    }
}
