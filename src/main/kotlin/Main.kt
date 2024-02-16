package org.example

import com.google.gson.Gson
import java.net.URI
import java.net.http.HttpClient
import java.net.http.HttpRequest
import java.net.http.HttpResponse

fun main() {
    val read = java.util.Scanner(System.`in`)
    val body = HttpClient.newHttpClient().send(
        HttpRequest.newBuilder()
            .uri(URI.create("https://www.cheapshark.com/api/1.0/games?id=15"))
            .build(),
        HttpResponse.BodyHandlers.ofString()
    ).body()

    runCatching {
        Gson().fromJson(body, InfoGame::class.java)
    }.onFailure {
        println("Error: ${it.message}")
        return
    }.onSuccess { infoApiShark ->
        println("Deseja adicionar a descrição do jogo? (s/n)")
        val option = read.nextLine()
        if (option.equals("s", ignoreCase = true)) {
            println("Digite a descrição do jogo:")
            val description = read.nextLine()
            println(Game(infoApiShark.info.title, infoApiShark.info.thumb, description))
        } else {
            println(Game(infoApiShark.info.title, infoApiShark.info.thumb, "Sem descrição"))
        }
    }

}
