package br.com.joao.aluragames.services

import kotlin.test.Test

class ApiGameServiceTest {
    @Test
    fun `should return a list of games`() {
        val apiGameService = ApiGameService()
        assert(apiGameService.getJson().isNotEmpty())
    }

    @Test
    fun `should return a list of games with deserialize`() {
        val apiGameService = ApiGameService()
        assert(apiGameService.getJson().isNotEmpty())
    }

    @Test
    fun `should return a list of games with serialize`() {
        val apiGameService = ApiGameService()
        val gamesSerializer = apiGameService.serialize()
        assert(gamesSerializer.isNotEmpty())
    }
}
