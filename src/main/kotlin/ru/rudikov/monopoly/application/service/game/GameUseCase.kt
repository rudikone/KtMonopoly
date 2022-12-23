package ru.rudikov.monopoly.application.service.game

import org.springframework.stereotype.Service
import ru.rudikov.monopoly.adapter.secondary.persistence.game.GameEntityMapper
import ru.rudikov.monopoly.application.domain.exception.NotFoundException
import ru.rudikov.monopoly.application.domain.exception.ProcessException
import ru.rudikov.monopoly.application.domain.model.dto.ChipDto
import ru.rudikov.monopoly.application.domain.model.dto.GameDto
import ru.rudikov.monopoly.port.secondary.GameOutputPort

@Service
class GameUseCase(
    private val gameEntityMapper: GameEntityMapper,
    private val gameOutputPort: GameOutputPort,
) : GameService {

    override fun startGame(chips: List<ChipDto>): GameDto {
        val gameDto = GameDto(chips = chips, whoNext = chips.random().name)

        val game = gameEntityMapper.toEntity(dto = gameDto)
        gameOutputPort.saveGame(game = game)

        return gameDto
    }

    override fun checkAction(gameId: Long, chipName: String) {
        val game = gameOutputPort.findGameById(id = gameId)
            ?: throw NotFoundException(message = "Игра с id = $gameId не найдена!")

        if (game.whoNext != chipName) {
            throw ProcessException(message = "Сейчас ход игрока с фишкой ${game.whoNext}!")
        }
    }
}