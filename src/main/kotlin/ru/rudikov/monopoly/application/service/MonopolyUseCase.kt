package ru.rudikov.monopoly.application.service

import org.springframework.stereotype.Service
import ru.rudikov.monopoly.application.domain.model.dto.GameDto
import ru.rudikov.monopoly.application.port.primary.MonopolyInputPort
import ru.rudikov.monopoly.application.service.chip.ChipService
import ru.rudikov.monopoly.application.service.game.GameService
import kotlin.random.Random

@Service
class MonopolyUseCase(
    private val chipService: ChipService,
    private val gameService: GameService
) : MonopolyInputPort {

    override fun startGame(chipNames: List<String>): GameDto {
        val chips = chipService.createChips(chipNames = chipNames)
        return gameService.startGame(chips = chips)
    }


    override fun rollTheDice(gameId: Long, chipName: String): List<Int> {
        gameService.checkAction(gameId = gameId, chipName = chipName)

        return listOf(Random.nextInt(1, 6), Random.nextInt(1, 6))
    }
}