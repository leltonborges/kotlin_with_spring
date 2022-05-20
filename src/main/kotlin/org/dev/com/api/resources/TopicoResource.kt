package org.dev.com.api.resources

import org.dev.com.api.dtos.AtualizarTopicoDTO
import org.dev.com.api.dtos.NovoTopicoDTO
import org.dev.com.api.dtos.ViewTopicoDTO
import org.dev.com.api.services.TopicoService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Pageable
import org.springframework.data.domain.Sort
import org.springframework.data.web.PageableDefault
import org.springframework.data.web.SortDefault
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.transaction.annotation.Transactional
import org.springframework.web.bind.annotation.*
import org.springframework.web.util.UriComponentsBuilder
import javax.validation.Valid

@RestController
@RequestMapping("/topico")
class TopicoResource
@Autowired constructor(
    private val topicoService: TopicoService
) {

    @GetMapping
    fun listAll(
        @RequestParam(required = false) nomeCurso: String?,
        @PageableDefault(size = 2, sort = ["titulo", "dataCriacao"]) paginacao: Pageable
    ): Page<ViewTopicoDTO> {
        return this.topicoService.listAll(nomeCurso, paginacao);
    }

    @GetMapping("/{id}")
    fun findById(@PathVariable("id") id: Long): ViewTopicoDTO {
        return topicoService.findById(id);
    }

    @PostMapping
    @Transactional
    fun insert(
        @Valid @RequestBody dto: NovoTopicoDTO,
        uriBuilder: UriComponentsBuilder
    ): ResponseEntity<ViewTopicoDTO> {
        val viewTopicoDTO = this.topicoService.save(dto)
        val uri = uriBuilder.path("/topico/${viewTopicoDTO.id}").build().toUri()
        return ResponseEntity.created(uri).body(viewTopicoDTO);
    }

    @PutMapping
    @Transactional
    fun update(@Valid @RequestBody dto: AtualizarTopicoDTO): ResponseEntity<ViewTopicoDTO> {
        return ResponseEntity.ok(this.topicoService.atualizar(dto))
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    @Transactional
    fun delete(@PathVariable("id") id: Long) {
        this.topicoService.delete(id);
    }

}