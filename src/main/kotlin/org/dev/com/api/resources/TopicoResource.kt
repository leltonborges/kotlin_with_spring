package org.dev.com.api.resources

import org.dev.com.api.models.Topico
import org.dev.com.api.services.TopicoService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/topico")
class TopicoResource
@Autowired constructor(
    private val topicoService: TopicoService
) {

    @GetMapping
    fun listAll(): List<Topico> {
        return this.topicoService.listAll();
    }

    @GetMapping("/{id}")
    fun findById(@PathVariable("id") id: Long): ResponseEntity<Topico>? {
        val topico = this.topicoService.findById(id)
        return ResponseEntity.ok(topico);
    }

    @PostMapping
    fun insert(@RequestBody topico: Topico): ResponseEntity<Void> {
        this.topicoService.save(topico)
        return ResponseEntity.status(HttpStatus.CREATED).build()
    }

}