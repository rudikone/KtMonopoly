package ru.rudikov.monopoly.port.primary

import ru.rudikov.monopoly.application.domain.model.dto.GameDto

interface MonopolyInputPort {
    fun startGame(chipNames: List<String>): GameDto
    fun rollTheDice(gameId: Long, chipName: String): List<Int>
}