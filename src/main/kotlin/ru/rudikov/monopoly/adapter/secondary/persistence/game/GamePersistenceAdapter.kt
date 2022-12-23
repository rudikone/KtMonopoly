package ru.rudikov.monopoly.adapter.secondary.persistence.game

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import ru.rudikov.monopoly.application.domain.model.entity.Game
import ru.rudikov.monopoly.port.secondary.GameOutputPort

@Service
class GamePersistenceAdapter(
    private val repository: GameRepository,
) : GameOutputPort {

    @Transactional
    override fun saveGame(game: Game) = repository.save(game)

    override fun findGameById(id: Long): Game? = repository.findGameById(id)
}