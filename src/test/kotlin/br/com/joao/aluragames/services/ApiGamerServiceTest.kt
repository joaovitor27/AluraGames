package br.com.joao.aluragames.services

import kotlin.test.Test
import kotlin.test.assertNotNull
import kotlin.test.assertTrue

class ApiGamerServiceTest {
    @Test
    fun get() {
        assertNotNull(ApiGamerService().get())
    }

    @Test
    fun serialize() {
        val apiGamerService = ApiGamerService()
        val json = apiGamerService.serialize()
        assertNotNull(json)
    }

    @Test
    fun deserialize() {
        val apiGamerService = ApiGamerService()
        val json = apiGamerService.get()
        val gamers = apiGamerService.deserialize(json)
        assertTrue(gamers.isNotEmpty())
    }
}
