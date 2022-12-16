package ru.rudikov.monopoly.application.service.game

import org.springframework.stereotype.Service
import ru.rudikov.monopoly.application.domain.model.dto.GameDto
import ru.rudikov.monopoly.application.domain.model.entity.Game
import ru.rudikov.monopoly.application.service.chip.toEntity

@Service
class GameEntityMapper {

    fun toEntity(dto: GameDto) = Game(whoNext = dto.whoNext).apply {
        chips = dto.chips.mapTo(mutableListOf()) { it.toEntity(game = this) }
    }
}