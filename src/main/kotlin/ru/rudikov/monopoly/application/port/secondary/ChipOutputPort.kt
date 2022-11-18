package ru.rudikov.monopoly.application.port.secondary

import ru.rudikov.monopoly.application.domain.model.entity.Chip

interface ChipOutputPort {
    fun saveChips(chips: List<Chip>): List<Chip>
}