package ru.rudikov.monopoly.application.service.chip

import org.springframework.stereotype.Service
import ru.rudikov.monopoly.application.domain.model.dto.ChipDto

@Service
class ChipUseCase : ChipService {

    override fun createChips(chipNames: List<String>): List<ChipDto> = chipNames.map {
        ChipDto(name = it, position = 0, balance = 1_500_000_000)
    }

}