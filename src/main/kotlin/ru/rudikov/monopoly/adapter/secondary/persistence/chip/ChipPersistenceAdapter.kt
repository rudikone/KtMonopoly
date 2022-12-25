package ru.rudikov.monopoly.adapter.secondary.persistence.chip

import org.springframework.stereotype.Service
import ru.rudikov.monopoly.application.domain.model.entity.Chip
import ru.rudikov.monopoly.port.secondary.ChipOutputPort

@Service
class ChipPersistenceAdapter(
    private val repository: ChipRepository,
) : ChipOutputPort {

    override fun saveChips(chips: List<Chip>): List<Chip> = repository.saveAll(chips)

    override fun getChipByName(name: String): Chip? = repository.findChipByName(name)

    override fun saveChip(chip: Chip) : Chip = repository.save(chip)
}