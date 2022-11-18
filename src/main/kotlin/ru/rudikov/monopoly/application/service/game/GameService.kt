package ru.rudikov.monopoly.application.service.game

import org.springframework.stereotype.Service
import ru.rudikov.monopoly.application.domain.model.dto.GameDto
import ru.rudikov.monopoly.application.port.secondary.GameOutputPort
import ru.rudikov.monopoly.application.service.chip.ChipService

@Service
class GameService(
    private val chipService: ChipService,
    private val gameEntityMapper: GameEntityMapper,
    private val gamePersistenceAdapter: GameOutputPort,
) {

    fun startGame(chipNames: List<String>): GameDto {
        val chips = chipService.createChips(chipNames = chipNames)

        val gameDto = GameDto(chips = chips, whoNext = chips.random().name)

        val game = gameEntityMapper.toEntity(dto = gameDto)
        gamePersistenceAdapter.saveGame(game = game)

        return gameDto
    }
}