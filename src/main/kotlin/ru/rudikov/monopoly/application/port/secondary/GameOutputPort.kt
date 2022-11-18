package ru.rudikov.monopoly.application.port.secondary

import ru.rudikov.monopoly.application.domain.model.entity.Game

interface GameOutputPort {
    fun saveGame(game: Game)
}