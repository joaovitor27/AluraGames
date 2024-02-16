package org.example

data class Game(
    private val title: String,
    private val thumb: String,
    private val description: String,
) {

    override fun toString(): String {
        return "Game(title=$title, thumb=$thumb, description=$description)"
    }

}
