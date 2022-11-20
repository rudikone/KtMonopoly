package ru.rudikov.monopoly.adapter.primary.rest

import org.springframework.http.HttpStatus.UNPROCESSABLE_ENTITY
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice
import ru.rudikov.monopoly.application.domain.exception.ErrorResponse
import ru.rudikov.monopoly.application.domain.exception.toErrorResponse
import javax.validation.ConstraintViolationException

@RestControllerAdvice
class ControllerAdvice {

    @ExceptionHandler(ConstraintViolationException::class)
    fun handleEntityViolation(ex: ConstraintViolationException): ResponseEntity<ErrorResponse> =
        handleException(httpStatus = UNPROCESSABLE_ENTITY.value(), errorResponse = ex.toErrorResponse())

    private fun handleException(
        httpStatus: Int,
        errorResponse: ErrorResponse,
    ): ResponseEntity<ErrorResponse> = ResponseEntity.status(httpStatus).body(errorResponse)
}