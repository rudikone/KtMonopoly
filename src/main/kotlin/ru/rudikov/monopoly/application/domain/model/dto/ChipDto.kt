package ru.rudikov.monopoly.application.domain.model.dto

data class ChipDto(
    val name: String,
    val position: Int,
    val balance: Long,
    val isArrested: Boolean = false,
)
