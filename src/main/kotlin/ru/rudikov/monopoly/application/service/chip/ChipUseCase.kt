package ru.rudikov.monopoly.application.service.chip

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import ru.rudikov.monopoly.application.domain.exception.NotFoundException
import ru.rudikov.monopoly.application.domain.model.dto.ChipDto
import ru.rudikov.monopoly.port.secondary.ChipOutputPort

@Service
class ChipUseCase(
    private val chipOutputPort: ChipOutputPort
) : ChipService {

    override fun createChips(chipNames: List<String>): List<ChipDto> = chipNames.map {
        ChipDto(name = it, position = 0, balance = 1_500_000_000)
    }

    @Transactional
    override fun saveRollResult(chipName: String, rollResult: List<Int>) {
        val chipForUpdate = chipOutputPort.getChipByName(name = chipName)
            ?: throw NotFoundException(message = "Фишки с именем = $chipName не существует!")
        chipForUpdate.rollResult = rollResult

        chipOutputPort.saveChip(chipForUpdate)
    }
}