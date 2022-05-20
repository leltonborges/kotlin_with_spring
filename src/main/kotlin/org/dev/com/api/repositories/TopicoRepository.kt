package org.dev.com.api.repositories

import org.dev.com.api.dtos.TopicoPorCategoriaDTO
import org.dev.com.api.models.Topico
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository

@Repository
interface TopicoRepository : JpaRepository<Topico, Long> {
    fun findAllByCurso_Nome(nomeCurso: String, paginacao: Pageable): Page<Topico>

    @Query("SELECT new org.dev.com.api.dtos.TopicoPorCategoriaDTO(c.categoria, count(t)) from tb_topico t join t.curso c group by c.categoria")
    fun relatorio(): List<TopicoPorCategoriaDTO>

}