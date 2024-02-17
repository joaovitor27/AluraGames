package br.com.joao.aluragames.models

import br.com.joao.aluragames.utils.Utils
import java.util.*
import kotlin.random.Random

data class Gamer(
    var name: String,
    var email: String,
    var password: String,
) {
    private var birthData: String? = null
    private var phone: String? = null
    private var address: String? = null
    private var city: String? = null
    private var state: String? = null
    private var country: String? = null
    private var zipCode: String? = null
    private var idInternal: String? = null

    constructor(
        name: String,
        email: String,
        password: String,
        birthData: String,
        phone: String,
        address: String,
        city: String,
        state: String,
        country: String,
        zipCode: String
    ) : this(name, email, password) {
        this.birthData = birthData
        this.phone = phone
        this.address = address
        this.city = city
        this.state = state
        this.country = country
        this.zipCode = zipCode
        this.createIdInternal()

    }

    override fun toString(): String {
        return "Gamer(name=$name, email=$email, password=$password, birthData=$birthData, phone=$phone, address=$address, city=$city, state=$state, country=$country, zipCode=$zipCode)"
    }

    private fun createIdInternal() {
        val number = Random.nextInt(10000)
        val tag = String.format("%04d", number)
        val nameFormat = Utils().removeAccents(name).lowercase(Locale.getDefault()).trim()
        this.idInternal = "$tag#$nameFormat"
    }

    init {
        this.createIdInternal()
    }

    fun getIdInternal(): String? {
        return idInternal
    }
}
