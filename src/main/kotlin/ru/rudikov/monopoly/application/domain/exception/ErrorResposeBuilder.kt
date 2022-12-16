package ru.rudikov.monopoly.application.domain.exception

import org.springframework.http.HttpStatus.UNPROCESSABLE_ENTITY
import java.time.Instant
import javax.validation.ConstraintViolationException

fun ConstraintViolationException.toErrorResponse(): ErrorResponse {
    val innerErrorMessage = this.javaClass.simpleName
    val innerErrorCause = this.constraintViolations.joinToString {
        it.propertyPath.reduce { _, second -> second }.toString() + it.message
    }

    return ErrorResponse(
        message = UNPROCESSABLE_ENTITY.reasonPhrase,
        timeStamp = Instant.now(),
    ).apply {
        innerErrors = listOf(InnerError(message = innerErrorMessage, cause = innerErrorCause))
    }
}