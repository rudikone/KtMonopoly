package ru.rudikov.monopoly.application.domain.exception

import java.time.Instant

data class ErrorResponse(
    val message: String,
    val timeStamp: Instant,
) {
    var innerErrors: List<InnerError>? = null
}

data class InnerError(
    val message: String? = null,
    val cause: String? = null,
)
