package com.example.probandocomponentes.screens

sealed class Ruta(val ruta:String) {

    object Pantalla1:Ruta("pantalla1")
    object Pantalla2:Ruta("pantalla2")
    object Pantalla3:Ruta("pantalla3")

}