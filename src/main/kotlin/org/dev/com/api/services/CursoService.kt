package org.dev.com.api.services

import org.dev.com.api.exceptions.NotFoundException
import org.dev.com.api.models.Curso
import org.dev.com.api.repositories.CursoRepository
import org.springframework.stereotype.Service

@Service
class CursoService(
    private val cursoRepository: CursoRepository
) {
    fun findById(id: Long): Curso {
        return this.cursoRepository
            .findById(id)
            .orElseThrow { NotFoundException("Curso não encontrado: $id") }
    }
}
