package com.example.probandocomponentes.modelo

data class Persona(val nombre: String, val edad:Int)


fun getPersonas():List<Persona> {
    return listOf(
        Persona("pepe", 20),
        Persona("María", 30),
        Persona("Teresa", 199),
        Persona("Manolo", 40),
    )
}