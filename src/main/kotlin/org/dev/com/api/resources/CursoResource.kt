package org.dev.com.api.resources

import org.dev.com.api.models.Curso
import org.dev.com.api.services.CursoService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/curso")
class CursoResource(
    private val cursoService: CursoService
) {

    @GetMapping
    fun findAll(): List<Curso> {
       return this.cursoService.findAll();
    }

}