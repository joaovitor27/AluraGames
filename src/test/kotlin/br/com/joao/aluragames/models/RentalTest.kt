package br.com.joao.aluragames.models

import java.time.LocalDate
import kotlin.test.Test
import kotlin.test.assertEquals

class RentalTest {
    @Test
    fun `should return a rental`() {
        val gamer = Gamer("João", "joao@gmail.com", "joao", "01/01/2000")
        val game = Game("The Last of Us", "last_of_us.jpg", "Jogo de ação e aventura", 100.0)
        val rental = Rental(gamer, game, LocalDate.now().plusDays(7))
        assertEquals("Aluguel de The Last of Us para João no valor de R$ 700.0", rental.toString())
    }

    @Test
    fun `should return a rental with gamer and game`() {
        val gamer = Gamer("João", "joao@gmail.com", "joao", "01/01/2000")
        val game = Game("The Last of Us", "last_of_us.jpg", "Jogo de ação e aventura", 100.0)
        val rental = Rental(gamer, game, LocalDate.now().plusDays(7))
        assertEquals(gamer, rental.getGamer())
        assertEquals(game, rental.getGame())
    }
}
