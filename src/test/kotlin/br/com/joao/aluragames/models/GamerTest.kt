package br.com.joao.aluragames.models

import kotlin.test.*

class GamerTest {
    @Test
    fun testToString() {
        val gamer = Gamer("João", "joao@gmail.com", "123456")
        assertEquals(
            "Gamer(name=João, email=joao@gmail.com, password=123456, birthData=null, phone=null, address=null, city=null, state=null, country=null, zipCode=null)",
            gamer.toString()
        )
    }

    @Test
    fun testToString1() {
        val gamer = Gamer(
            "João",
            "joao@gmail.com",
            "123456",
            "01/01/2000",
            "(11) 99999-9999",
            "Rua 1",
            "São Paulo",
            "SP",
            "Brasil",
            "00000-000"
        )
        assertEquals(
            "Gamer(name=João, email=joao@gmail.com, password=123456, birthData=01/01/2000, phone=(11) 99999-9999, address=Rua 1, city=São Paulo, state=SP, country=Brasil, zipCode=00000-000)",
            gamer.toString()
        )
    }

    @Test
    fun testCreateIdInternal() {
        val gamer = Gamer("João", "joao@gmail.com", "123456")
        gamer.getIdInternal()?.let {
            assertTrue(it.contains("#joao"))
        }
        assertNotNull(gamer.getIdInternal())
    }
}
