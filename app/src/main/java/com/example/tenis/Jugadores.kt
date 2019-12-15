package com.example.tenis

class Jugadores {

    var nombre: String? = null
    var pais: String? = null
    var ciudad: String? = null

    fun getNombres(): String {
        return nombre.toString()
    }

    fun setNombres(name: String) {
        this.nombre = name
    }

    fun getPaises(): String {
        return pais.toString()
    }

    fun setPaises(name: String) {
        this.pais = name
    }

    fun getCiudades(): String {
        return ciudad.toString()
    }

    fun setCiudades(name: String) {
        this.ciudad = name
    }

}