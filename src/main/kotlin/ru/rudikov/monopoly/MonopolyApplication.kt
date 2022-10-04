package ru.rudikov.monopoly

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class MonopolyApplication

fun main(args: Array<String>) {
	runApplication<MonopolyApplication>(*args)
}
