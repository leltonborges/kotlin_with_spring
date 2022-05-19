package org.dev.com.api.repositories

import org.dev.com.api.models.Resposta
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface RespostaRepository : JpaRepository<Resposta, Long>