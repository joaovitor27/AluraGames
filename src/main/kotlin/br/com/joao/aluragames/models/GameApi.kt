package br.com.joao.aluragames.models

data class GameApi(
    private val titulo: String,
    private val capa: String,
    private val descricao: String,
    private val preco: Double,
) {
    fun getTitulo(): String {
        return titulo
    }
    fun getCapa(): String {
        return capa
    }
    fun getDescricao(): String {
        return descricao
    }
    fun getPreco(): Double {
        return preco
    }
}
