package ru.rudikov.monopoly.port.secondary

import ru.rudikov.monopoly.application.domain.model.entity.Chip

interface ChipOutputPort {
    fun saveChips(chips: List<Chip>): List<Chip>

    fun getChipByName(name: String): Chip?

    fun saveChip(chip: Chip): Chip
}