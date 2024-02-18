package br.com.joao.aluragames.services

import br.com.joao.aluragames.models.Gamer
import br.com.joao.aluragames.models.GamerApi
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

data class ApiGamerService(
    private val url: String = "https://raw.githubusercontent.com/jeniblodev/arquivosJson/main/gamers.json",
    private val httpService: HttpService = HttpService(url)
) {
    fun get(): String {
        return httpService.get()
    }

    fun serialize(): String {
        return Gson().toJson(this)
    }

    fun deserialize(json: String): List<Gamer> {
        val gamer = Gson().fromJson<List<GamerApi>>(json, object : TypeToken<List<GamerApi>>() {}.type)
        return gamer.map { Gamer(it.nome, it.email, it.usuario, it.dataNascimento) }
    }
}
