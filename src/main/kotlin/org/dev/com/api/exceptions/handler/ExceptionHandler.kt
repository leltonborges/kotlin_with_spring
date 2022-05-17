package org.dev.com.api.exceptions.handler

import org.dev.com.api.exceptions.NotFoundException
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice
import javax.servlet.http.HttpServletRequest

@RestControllerAdvice
class ExceptionHandler {

    @ExceptionHandler(NotFoundException::class)
    fun handleNotFound(ex: NotFoundException, request: HttpServletRequest): ResponseEntity<Standard> {
        val status = HttpStatus.NOT_FOUND.value()
        val error = Standard(ex.message, status, request.requestURI)
        return ResponseEntity.status(status).body(error);
    }
}