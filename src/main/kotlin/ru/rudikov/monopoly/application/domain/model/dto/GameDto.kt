package ru.rudikov.monopoly.application.domain.model.dto

data class GameDto(
    val whoNext: String,
    val chips: List<ChipDto>,
)
