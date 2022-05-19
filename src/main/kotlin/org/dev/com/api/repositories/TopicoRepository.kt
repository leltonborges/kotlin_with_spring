package org.dev.com.api.repositories

import org.dev.com.api.models.Topico
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface TopicoRepository : JpaRepository<Topico, Long> {
    fun findAllByCurso_Nome(nomeCurso: String): List<Topico>
}