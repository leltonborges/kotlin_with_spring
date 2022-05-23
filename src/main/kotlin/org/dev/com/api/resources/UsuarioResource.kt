package org.dev.com.api.resources

import org.dev.com.api.models.Usuario
import org.dev.com.api.services.UsuarioService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/usuario")
class UsuarioResource(
    private val usuarioService: UsuarioService
) {

    @GetMapping
    fun findAll(): List<Usuario> {
       return this.usuarioService.findAll();
    }

}