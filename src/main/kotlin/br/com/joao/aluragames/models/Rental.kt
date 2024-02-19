package br.com.joao.aluragames.models

import java.time.LocalDate
import java.time.Period

data class Rental(
    private val gamer: Gamer,
    private val game: Game,
    private val endDate: LocalDate,
    private val initDate: LocalDate = LocalDate.now(),
) {
    private var value: Double = 0.0
    init {
        if (endDate.isBefore(initDate)) {
            throw IllegalArgumentException("A data de devolução não pode ser antes da data de locação")
        }
        value = game.getPrice() * Period.between(initDate, endDate).days
    }

    override fun toString(): String {
        return "Aluguel de ${game.getTitle()} para ${gamer.getName()} no valor de R$ $value"
    }

    fun getGamer(): Gamer {
        return gamer
    }

    fun getGame(): Game {
        return game
    }
}
