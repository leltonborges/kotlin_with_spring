package org.dev.com.api.services

import org.dev.com.api.exceptions.NotFoundException
import org.dev.com.api.models.Usuario
import org.dev.com.api.repositories.UsuarioRepository
import org.springframework.stereotype.Service

@Service
class UsuarioService(
    private val repository: UsuarioRepository
) {

    fun findById(id: Long): Usuario {
        return this.repository
            .findById(id)
            .orElseThrow { NotFoundException("Usuario não encontrado: $id") }
    }
}
