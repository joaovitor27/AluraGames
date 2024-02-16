package br.com.joao.aluragames.services

import br.com.joao.aluragames.models.InfoGame
import com.google.gson.Gson

class ApiSharkService (id : String) {
    private val url = "https://www.cheapshark.com/api/1.0/games?id=$id"
    private val httpService = HttpService(url)

    fun get(): String {
        return httpService.get()
    }

    fun serialize(): String {
        return Gson().toJson(this)
    }

    fun deserialize(json: String): InfoGame {
        return Gson().fromJson(json, InfoGame::class.java)
    }

}
