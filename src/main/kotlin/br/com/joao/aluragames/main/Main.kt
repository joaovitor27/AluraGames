package br.com.joao.aluragames.main

import br.com.joao.aluragames.models.Game
import br.com.joao.aluragames.models.Gamer
import br.com.joao.aluragames.services.ApiGameService

fun main() {
    val read = java.util.Scanner(System.`in`)
    val gamer = Gamer.createGamer(read)
    do {
        println("Digite o id do jogo:")
        val id = read.nextInt()
        val gamesApi = ApiGameService()
        runCatching {
            gamesApi.getGame(id)
        }.onFailure {
            println("Jogo não encontrado!")
        }.onSuccess { infoApi ->
            println("Deseja adicionar a descrição do jogo? (s/n)")
            val option = read.nextLine()
            val game: Game?
            if (option.equals("s", ignoreCase = true)) {
                println("Digite a descrição do jogo:")
                val description = read.nextLine()
                game = Game(infoApi.getTitle(), infoApi.getThumb(), description, infoApi.getPrice())
            } else {
                game = Game(infoApi.getTitle(), infoApi.getThumb(), infoApi.getDescription(), infoApi.getPrice())
            }
            gamer.addGame(game)
        }
        println("Deseja buscar outro jogo? (s/n)")
        val res = read.nextLine()
    } while (res.equals("s", ignoreCase = true))

    println("Seus jogos:")
    gamer.getGames().forEach { game ->
        println(game)
    }
    println("Até mais!")
}
