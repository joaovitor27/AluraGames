package br.com.joao.aluragames.main

import br.com.joao.aluragames.models.Game
import br.com.joao.aluragames.services.ApiSharkService

fun main() {
    val read = java.util.Scanner(System.`in`)
    println("Digite o id do jogo:")
    val id = read.nextLine()
    val apiShark = ApiSharkService(id)
    runCatching {
        apiShark.deserialize(apiShark.get())
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
