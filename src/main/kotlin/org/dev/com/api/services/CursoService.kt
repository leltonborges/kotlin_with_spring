package org.dev.com.api.services

import org.dev.com.api.exceptions.NotFoundException
import org.dev.com.api.models.Curso
import org.dev.com.api.repositories.CursoRepository
import org.springframework.stereotype.Service
import javax.persistence.EntityManager

@Service
class CursoService(
    private val cursoRepository: CursoRepository,
    private val manager: EntityManager
) {
    fun findById(id: Long): Curso {
        return this.cursoRepository
            .findById(id)
            .orElseThrow { NotFoundException("Curso não encontrado: $id") }
    }

    fun findAll(): List<Curso> {
        return this.manager.createQuery("SELECT c FROM tb_curso c", Curso::class.java).resultList
    }
}
