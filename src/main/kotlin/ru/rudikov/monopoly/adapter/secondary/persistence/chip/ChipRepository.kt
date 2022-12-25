package ru.rudikov.monopoly.adapter.secondary.persistence.chip

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Modifying
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository
import ru.rudikov.monopoly.application.domain.model.entity.Chip

@Repository
interface ChipRepository : JpaRepository<Chip, Long> {

    fun findChipByName(name: String): Chip?
}