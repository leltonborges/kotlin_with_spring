package org.dev.com.api.repositories

import org.dev.com.api.models.Usuario
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface CursoRepository : JpaRepository<Usuario, Long> {
}