package ru.rudikov.monopoly.application.domain.model.dto

data class ThrowDto(
    val chip: String,
    val firstDice: Int,
    val secondDice: Int,
    val throwCount: Int,
    val needSecondThrow: Boolean = false,
)
