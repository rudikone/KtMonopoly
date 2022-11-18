package ru.rudikov.monopoly.application.port.primary

import ru.rudikov.monopoly.application.domain.model.dto.GameDto

interface GameInputPort {
    fun startGame(chipNames: List<String>): GameDto
}