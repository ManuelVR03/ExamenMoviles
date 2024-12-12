package com.example.examenjpc_1.screens

sealed class Ruta(val ruta:String) {

    object Inicio:Ruta("inicio")
    object Formulario:Ruta("formulario")
    object ListadoDetalle:Ruta("listas")

}

