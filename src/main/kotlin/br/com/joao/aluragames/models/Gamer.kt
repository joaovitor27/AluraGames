package br.com.joao.aluragames.models

import br.com.joao.aluragames.utils.removeAccents
import java.util.*
import kotlin.random.Random

data class Gamer(
    private var name: String,
    private var email: String,
    private var user: String,
    private var birthData: String,
) {
    private var phone: String? = null
    private var address: String? = null
    private var city: String? = null
    private var state: String? = null
    private var country: String? = null
    private var zipCode: String? = null
    private var idInternal: String? = null
    private var games: MutableList<Game> = mutableListOf()

    constructor(
        name: String,
        email: String,
        user: String,
        birthData: String,
        phone: String,
        address: String,
        city: String,
        state: String,
        country: String,
        zipCode: String
    ) : this(name, email, user, birthData) {
        this.phone = phone
        this.address = address
        this.city = city
        this.state = state
        this.country = country
        this.zipCode = zipCode
        this.createIdInternal()

    }

    override fun toString(): String {
        return "Gamer(name=$name, email=$email, user=$user, birthData=$birthData, phone=$phone, address=$address, city=$city, state=$state, country=$country, zipCode=$zipCode)"
    }

    private fun createIdInternal() {
        val number = Random.nextInt(10000)
        val tag = String.format("%04d", number)
        val nameFormat = name.removeAccents().lowercase(Locale.getDefault()).trim()
        this.idInternal = "$tag#$nameFormat"
    }

    init {
        this.createIdInternal()
    }

    fun getIdInternal(): String? {
        return idInternal
    }

    fun addGame(game: Game) {
        games.add(game)
    }

    fun getGames(): List<Game> {
        return games
    }

    fun getName(): String {
        return name
    }

    companion object {
        fun createGamer(read: Scanner): Gamer {
            println("Bem vindo ao Alura Games!\n")
            println("Digite suas informações para criar uma conta:")
            print("Name: ")
            val name = read.nextLine()
            print("Email: ")
            val email = read.nextLine()
            print("Usuário: ")
            val user = read.nextLine()
            print("Birth Data: ")
            val birthData = read.nextLine()
            print("Deseja adicionar mais informações? (s/n)")
            val option = read.nextLine()

            if (option.equals("n", ignoreCase = true)) {
                return Gamer(name, email, user, birthData)
            } else {
                print("Phone: ")
                val phone = read.nextLine()
                print("Address: ")
                val address = read.nextLine()
                print("City: ")
                val city = read.nextLine()
                print("State: ")
                val state = read.nextLine()
                print("Country: ")
                val country = read.nextLine()
                print("Zip Code: ")
                val zipCode = read.nextLine()
                return Gamer(name, email, user, birthData, phone, address, city, state, country, zipCode)
            }
        }
    }

    fun rentGame(game: Game): Rental {
        return Rental(this, game)
    }
}
