package ru.rudikov.monopoly.adapter.secondary

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import ru.rudikov.monopoly.application.domain.model.entity.Game

@Repository
interface GameRepository : JpaRepository<Game, Long> {
}