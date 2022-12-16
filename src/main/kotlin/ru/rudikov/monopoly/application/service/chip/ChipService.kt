package ru.rudikov.monopoly.application.service.chip

import ru.rudikov.monopoly.application.domain.model.dto.ChipDto

interface ChipService {
    fun createChips(chipNames: List<String>): List<ChipDto>
}