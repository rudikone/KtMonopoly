package ru.rudikov.monopoly.application.service

import org.springframework.stereotype.Service
import ru.rudikov.monopoly.application.domain.model.dto.GameDto
import ru.rudikov.monopoly.application.port.primary.GameInputPort
import ru.rudikov.monopoly.application.service.game.GameService

@Service
class GameUseCase(
    private val service: GameService,
) : GameInputPort {

    override fun startGame(chipNames: List<String>): GameDto = service.startGame(chipNames = chipNames)
}