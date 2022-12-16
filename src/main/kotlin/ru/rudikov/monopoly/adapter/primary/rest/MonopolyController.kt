package ru.rudikov.monopoly.adapter.primary.rest

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import ru.rudikov.monopoly.application.domain.model.dto.GameDto
import ru.rudikov.monopoly.application.port.primary.MonopolyInputPort
import javax.validation.constraints.Size

@Validated
@RestController
class MonopolyController(
    private val port: MonopolyInputPort,
) {

    @PostMapping("/game/start")
    fun startGame(@RequestBody @Size(min = 2, max = 6) chipNames: List<String>): ResponseEntity<GameDto> {
        val response = port.startGame(chipNames = chipNames)
        return ResponseEntity.status(HttpStatus.OK).body(response)
    }

    @GetMapping("/game/{id}/chip/{name}/roll_the_dice")
    fun rollTheDice(@PathVariable id: Long, @PathVariable name: String): ResponseEntity<GameDto> {
        val response = port.rollTheDice(gameId = id, chipName = name)
        return ResponseEntity.status(HttpStatus.OK).body(response)
    }
}