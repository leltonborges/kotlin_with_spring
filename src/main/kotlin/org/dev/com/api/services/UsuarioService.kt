package org.dev.com.api.services

import org.dev.com.api.models.Usuario
import org.springframework.stereotype.Service

@Service
class UsuarioService {
    var usuarios: List<Usuario> = ArrayList()

    init {
        val autor1= Usuario(
            id= 1,
            nome = "Lia",
            email = "lia@gmai.com"
        )

        val autor2= Usuario(
            id= 2,
            nome = "Bia",
            email = "bia@gmai.com"
        )

        this.usuarios = listOf(autor1, autor2)
    }

    fun findById(id: Long): Usuario {
        return this.usuarios.
            stream()
            .filter { c -> id.equals(c.id) }
            .findFirst().get()
    }
}
