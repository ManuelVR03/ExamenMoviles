package com.example.probandocomponentes.screens
//una clase sellada (sealed class) llamada Ruta, que se utiliza para representar las rutas de navegación.
//Es una clase que restringe la herencia: solo se puede extender dentro del mismo archivo donde está definida.
//Sirve para crear un grupo de tipos relacionados que tienen un conjunto fijo de subclases.
//Es ideal para representar opciones limitadas o estados predefinidos, como las rutas en este caso.
sealed class Ruta(val ruta:String) {
    //Es la clase base que define un atributo común llamado ruta (un String).
    //Este atributo representa la cadena que identifica cada ruta en el sistema de navegación.
    object Pantalla1:Ruta("pantalla1")
    object Pantalla2:Ruta("pantalla2")
    object Pantalla3:Ruta("pantalla3")
    //Son objetos (object) que heredan de la clase Ruta.
    //Cada objeto define una ruta específica mediante el atributo ruta.
    //Es simplemente un String ("pantallaX") que identifica de forma única la pantalla asociada.
    //Es simplemente un String ("pantallaX") que identifica de forma única la pantalla asociada.

}