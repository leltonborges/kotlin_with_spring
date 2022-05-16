package org.dev.com.api.services

import org.dev.com.api.models.Curso
import org.springframework.stereotype.Service

@Service
class CursoService {
    var cursos: List<Curso> = ArrayList()

    init {
        val curso1 = Curso(
            id = 1L,
            nome = "Kotlin",
            categoria = "Programação"
        )

        val curso2 = Curso(
            id = 2L,
            nome = "Quarkus",
            categoria = "Programação"
        )

        this.cursos = listOf(curso1, curso2)
    }

    fun findById(id: Long): Curso {
        return this.cursos.
            stream()
            .filter { c -> id.equals(c.id) }
            .findFirst().get()
    }
}
