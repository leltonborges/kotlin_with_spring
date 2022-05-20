package org.dev.com.api.services

import org.dev.com.api.config.toTopicoViewDTO
import org.dev.com.api.dtos.AtualizarTopicoDTO
import org.dev.com.api.dtos.NovoTopicoDTO
import org.dev.com.api.dtos.TopicoPorCategoriaDTO
import org.dev.com.api.dtos.ViewTopicoDTO
import org.dev.com.api.exceptions.NotFoundException
import org.dev.com.api.mapper.TopicoMapper
import org.dev.com.api.mapper.TopicoViewMapper
import org.dev.com.api.models.Topico
import org.dev.com.api.repositories.TopicoRepository
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service

@Service
class TopicoService(
    private val topicoMapper: TopicoMapper,
    private val topicoViewMapper: TopicoViewMapper,
    private val topicoRepository: TopicoRepository
) {

    fun listAll(
        nomeCurso: String?,
        paginacao: Pageable
    ): Page<ViewTopicoDTO> {
        val all =
            if (nomeCurso == null) this.topicoRepository.findAll(paginacao)
            else this.topicoRepository.findAllByCurso_Nome(nomeCurso, paginacao)

        return all.map(Topico::toTopicoViewDTO)
//        return this.topicos.map(topicoViewMapper::map)
    }

    fun findById(id: Long): ViewTopicoDTO {
        val topico = this.topicoRepository
            .findById(id)
            .map(this.topicoViewMapper::map)
            .orElseThrow { NotFoundException("Não encontrado: ${id}") }
        return topico
    }

    fun save(dto: NovoTopicoDTO): ViewTopicoDTO {
        val topico = topicoMapper.map(dto)
        return this.topicoRepository.save(topico).let { this.topicoViewMapper.map(it) }
    }

    fun atualizar(dto: AtualizarTopicoDTO): ViewTopicoDTO {

        val topico = this.topicoRepository
            .findById(dto.id)
            .orElseThrow { NotFoundException("Não encontrado: ${dto.id}") }

        topico.apply {
            titulo = dto.titulo
            mensagem = dto.mensagem
        }

        return this.topicoRepository.save(topico).let(this.topicoViewMapper::map)
    }


    fun delete(id: Long) {
        val topico = this.topicoRepository
            .findById(id)
            .orElseThrow { NotFoundException("Não encontrado: ${id}") }
        this.topicoRepository.delete(topico)
    }

    fun relatorio(): List<TopicoPorCategoriaDTO> {
        return this.topicoRepository.relatorio()
    }

}