package ru.rudikov.monopoly.application.domain.exception

class NotFoundException(override val message: String?) : RuntimeException(message)

class ProcessException(override val message: String?) : RuntimeException(message)