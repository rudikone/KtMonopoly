package ru.rudikov.monopoly.adapter.secondary.persistence.chip

import ru.rudikov.monopoly.application.domain.model.dto.ChipDto
import ru.rudikov.monopoly.application.domain.model.entity.Chip
import ru.rudikov.monopoly.application.domain.model.entity.Game

fun ChipDto.toEntity(game: Game): Chip = Chip(
    name = this.name,
    position = this.position,
    balance = this.balance,
    game = game
)
