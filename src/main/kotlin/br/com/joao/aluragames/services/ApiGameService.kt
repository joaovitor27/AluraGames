package br.com.joao.aluragames.services

import br.com.joao.aluragames.models.Game
import br.com.joao.aluragames.models.GameApi
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

data class ApiGameService(
    val url: String = "https://raw.githubusercontent.com/jeniblodev/arquivosJson/main/jogos.json",
    val httpService: HttpService = HttpService(url)
) {
    private var games: List<Game> = listOf()
    private var json: String = ""

    init {
        getGames()
        deserialize()
    }

    private fun getGames(): ApiGameService {
        json = httpService.get()
        return this
    }

    fun serialize(): String {
        return Gson().toJson(games.map { it: Game ->
            GameApi(
                it.getTitle(),
                it.getThumb(),
                it.getDescription(),
                it.getPrice()
            )
        })
    }

    private fun deserialize(): ApiGameService {
        val gamer = Gson().fromJson<List<GameApi>>(json, object : TypeToken<List<GameApi>>() {}.type)
        games = gamer.map { Game(it.getTitulo(), it.getCapa(), it.getDescricao(), it.getPreco()) }
        return this
    }

    fun getJson(): String {
        return json
    }

    fun getGame(index: Int): Game {
        return games[index]
    }

}
