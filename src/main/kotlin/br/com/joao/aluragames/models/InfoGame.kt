package br.com.joao.aluragames.models

data class InfoGame(
    val info: InfoApiShark
) {
    override fun toString(): String {
        return info.toString()
    }
}
