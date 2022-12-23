package ru.rudikov.monopoly.adapter.secondary.persistence.game

import org.springframework.stereotype.Service
import ru.rudikov.monopoly.adapter.secondary.persistence.chip.toEntity
import ru.rudikov.monopoly.application.domain.model.dto.GameDto
import ru.rudikov.monopoly.application.domain.model.entity.Game

@Service
class GameEntityMapper {

    fun toEntity(dto: GameDto) = Game(whoNext = dto.whoNext).apply {
        chips = dto.chips.mapTo(mutableListOf()) { it.toEntity(game = this) }
    }
}