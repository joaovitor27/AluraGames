package br.com.joao.aluragames.models

data class Rental(
    private val gamer: Gamer,
    private val game: Game,
) {
    override fun toString(): String {
        return "Aluguel de ${game.getTitle()} para ${gamer.getName()}"
    }


    fun getGamer(): Gamer {
        return gamer
    }

    fun getGame(): Game {
        return game
    }
}
