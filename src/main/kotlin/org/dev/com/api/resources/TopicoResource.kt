package org.dev.com.api.resources

import org.dev.com.api.models.Topico
import org.dev.com.api.services.TopicoService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/topico")
class TopicoResource(
    private val topicoService: TopicoService
) {

    @GetMapping
    fun listAll(): List<Topico> {
        return this.topicoService.listAll();
    }
}