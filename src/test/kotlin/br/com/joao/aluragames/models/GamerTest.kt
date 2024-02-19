package br.com.joao.aluragames.models

import kotlin.test.*

class GamerTest {
    @Test
    fun testToString() {
        val gamer = Gamer("João", "joao@gmail.com", "joao", "01/01/2000")
        assertEquals(
            "Gamer(name=João, email=joao@gmail.com, user=joao, birthData=01/01/2000, phone=null, address=null, city=null, state=null, country=null, zipCode=null)",
            gamer.toString()
        )
    }

    @Test
    fun testToString1() {
        val gamer = Gamer(
            "João",
            "joao@gmail.com",
            "joao",
            "01/01/2000",
            "(11) 99999-9999",
            "Rua 1",
            "São Paulo",
            "SP",
            "Brasil",
            "00000-000"
        )
        assertEquals(
            "Gamer(name=João, email=joao@gmail.com, user=joao, birthData=01/01/2000, phone=(11) 99999-9999, address=Rua 1, city=São Paulo, state=SP, country=Brasil, zipCode=00000-000)",
            gamer.toString()
        )
    }

    @Test
    fun testCreateIdInternal() {
        val gamer = Gamer("João", "joao@gmail.com", "joao", "01/01/2000")
        gamer.getIdInternal()?.let {
            assertTrue(it.contains("#joao"))
        }
        assertNotNull(gamer.getIdInternal())
    }

    @Test
    fun testRentGame(){
        val gamer = Gamer("João", "joao@gmail.com", "joao", "01/01/2000")
        val game = Game("The Last of Us", "last_of_us.jpg", "Jogo de ação e aventura", 100.0)
        val rental = gamer.rentGame(game)
        assertEquals("Aluguel de The Last of Us para João", rental.toString())
    }

    @Test
    fun testRentGameWithGamerAndGame() {
        val gamer = Gamer("João", "joao@gmail.com", "joao", "01/01/2000")
        val game = Game("The Last of Us", "last_of_us.jpg", "Jogo de ação e aventura", 100.0)
        val rental = gamer.rentGame(game)
        assertEquals(gamer, rental.getGamer())
        assertEquals(game, rental.getGame())
    }
}
