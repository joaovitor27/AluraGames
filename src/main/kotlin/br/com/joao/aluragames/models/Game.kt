package br.com.joao.aluragames.models

data class Game(
    private val title: String,
    private val thumb: String,
    private val description: String,
    private val price: Double
) {

    override fun toString(): String {
        return "Game(title=$title, thumb=$thumb, description=$description), price=$price)"
    }

    fun getTitle(): String {
        return title
    }

    fun getThumb(): String {
        return thumb
    }

    fun getDescription(): String {
        return description
    }

    fun getPrice(): Double {
        return price
    }
}
