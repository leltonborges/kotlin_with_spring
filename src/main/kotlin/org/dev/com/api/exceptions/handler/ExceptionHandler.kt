package org.dev.com.api.exceptions.handler

import org.dev.com.api.exceptions.FieldError
import org.dev.com.api.exceptions.NotFoundException
import org.dev.com.api.exceptions.ValidationError
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.MethodArgumentNotValidException
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

    @ExceptionHandler(MethodArgumentNotValidException::class)
    fun handleNotValid(
        ex: MethodArgumentNotValidException,
        request: HttpServletRequest
    ): ResponseEntity<ValidationError> {
        val status = HttpStatus.BAD_REQUEST.value()
        val error = ValidationError("Fields Errors", status, request.requestURI)
        ex.bindingResult.fieldErrors.forEach { er ->
            error.addErrorField(er.field, er.defaultMessage)
        }

        return ResponseEntity.status(status).body(error);
    }

    @ExceptionHandler(Exception::class)
    fun handleException(ex: Exception, request: HttpServletRequest): ResponseEntity<Standard> {
        val status = HttpStatus.INTERNAL_SERVER_ERROR.value()
        val error = Standard(ex.message, status, request.requestURI)
        return ResponseEntity.status(status).body(error);
    }
}