package ru.rudikov.monopoly.adapter.primary

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import ru.rudikov.monopoly.application.domain.model.dto.GameDto
import ru.rudikov.monopoly.application.port.primary.GameInputPort

@RestController
class GameController(
    private val gameUseCase: GameInputPort,
) {

    @PostMapping("/game/start")
    fun startGame(@RequestBody chipNames: List<String>): ResponseEntity<GameDto> {
        val response = gameUseCase.startGame(chipNames = chipNames)
        return ResponseEntity.status(HttpStatus.OK).body(response)
    }
}