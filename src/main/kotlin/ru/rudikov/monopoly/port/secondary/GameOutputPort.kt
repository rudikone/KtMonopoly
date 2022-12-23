package ru.rudikov.monopoly.port.secondary

import ru.rudikov.monopoly.application.domain.model.entity.Game

interface GameOutputPort {
    fun saveGame(game: Game): Game
    fun findGameById(id: Long): Game?
}