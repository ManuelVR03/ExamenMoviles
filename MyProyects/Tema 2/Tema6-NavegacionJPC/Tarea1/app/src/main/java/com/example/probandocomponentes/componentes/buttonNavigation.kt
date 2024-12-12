package com.example.probandocomponentes.componentes

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarDefaults
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

//Define una barra de navegación inferior
@Composable
fun NavigationBarExample() {
    //Es el contenedor principal que representa la barra de navegación inferior.
    //WindowInsets asegura que la barra respete los márgenes del sistema
    NavigationBar( windowInsets = NavigationBarDefaults.windowInsets ){
        NavigationBarItem(
            selected = true, // Indica si este elemento está seleccionado
            onClick = { /*TODO*/ }, //Acción al hacer clic
            icon = { Icon( Icons.Filled.Favorite, null) }, // Ícono del elemento
            label = { Text(text = "Aris")}// Texto asociado al ícono
        )
        NavigationBarItem(
            selected = false,
            onClick = { /*TODO*/ },
            icon = { Icon( Icons.Filled.Favorite, null) },
            label = { Text(text = "Aris")}
        )
        NavigationBarItem(
            selected = false,
            onClick = { /*TODO*/ },
            icon = { Icon( Icons.Filled.Favorite, null) },
            label = { Text(text = "Aris")}
        )
        NavigationBarItem(
            selected = true,
            onClick = { /*TODO*/ },
            icon = { Icon( Icons.Filled.Favorite, null) },
            label = { Text(text = "Aris")}
        )
    }
}