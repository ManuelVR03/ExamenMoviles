package com.example.probandocomponentes.screens

sealed class Ruta(val ruta:String) {

    object Pantalla1:Ruta("pantalla1")
    object Pantalla2:Ruta("pantalla2")
    object Pantalla2_1:Ruta("pantalla2_1")
    object Pantalla2_2:Ruta("pantalla2_2")
    object Pantalla3:Ruta("pantalla3")
    object Pantalla3_1:Ruta("pantalla3_1")
    object Pantalla3_2:Ruta("pantalla3_2")

}

