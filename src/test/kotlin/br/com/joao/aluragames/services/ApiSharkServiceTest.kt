package br.com.joao.aluragames.services

import org.junit.jupiter.api.Assertions.*
import kotlin.test.Test

class ApiSharkServiceTest {

    private val idGamer: String = "15"

    @Test
    fun get() {
        assertNotNull(ApiSharkService(idGamer).get())
    }

    @Test
    fun serialize() {
        val apiSharkService = ApiSharkService(idGamer)
        val json = apiSharkService.serialize()
        assertNotNull(json)
    }

    @Test
    fun deserialize() {
        val apiSharkService = ApiSharkService(idGamer)
        val json = apiSharkService.get()
        val sharks = apiSharkService.deserialize(json)
    }
}
