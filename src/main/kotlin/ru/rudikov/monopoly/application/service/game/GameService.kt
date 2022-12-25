package ru.rudikov.monopoly.application.service.game

import ru.rudikov.monopoly.application.domain.model.dto.ChipDto
import ru.rudikov.monopoly.application.domain.model.dto.GameDto

interface GameService {
    fun startGame(chips: List<ChipDto>): GameDto
    fun checkAction(gameId: Long, chipName: String)

    fun getGameById(gameId: Long): GameDto
}