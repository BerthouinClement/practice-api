package fr.cb.practiceapi.config

import fr.cb.practiceapi.exception.BadRequestException
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.context.request.WebRequest
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler

@ControllerAdvice
class RestResponseEntityExceptionHandler : ResponseEntityExceptionHandler() {

    @ExceptionHandler(value = [BadRequestException::class])
    fun handleBadRequest(ex: BadRequestException, request: WebRequest) : ResponseEntity<Any> {
        return handleExceptionInternal(
            ex,
            CustomError(ex.message, HttpStatus.BAD_REQUEST.name),
            HttpHeaders(),
            HttpStatus.BAD_REQUEST,
            request
        )
    }
}

data class CustomError(
    val message: String?,
    val status: String
)