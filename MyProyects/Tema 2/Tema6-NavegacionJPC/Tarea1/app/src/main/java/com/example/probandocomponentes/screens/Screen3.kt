package com.example.probandocomponentes.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarDefaults
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavHostController
import com.example.probandocomponentes.screens.Ruta.Pantalla1


@Composable
fun screen3(navController: NavHostController){
    Box(modifier = Modifier
        .background(Color.Yellow)
        .fillMaxSize()

    ){
        Text(text="pantalla 3",modifier= Modifier.align(Alignment.Center)
            .clickable { navController.navigate(Pantalla1.ruta) })
    }
    NavigationBar( windowInsets = NavigationBarDefaults.windowInsets ){
        NavigationBarItem(
            selected = false, // Indica si este elemento está seleccionado
            onClick = {
                navController.navigate(Ruta.Pantalla3_1.ruta)
            }, //Acción al hacer clic
            icon = { Icon( Icons.Filled.Favorite, null) }, // Ícono del elemento
            label = { Text(text = "Pantalla3_1")}// Texto asociado al ícono
        )
        NavigationBarItem(
            selected = false,
            onClick = {
                navController.navigate(Ruta.Pantalla3_2.ruta)
            },
            icon = { Icon( Icons.Filled.Favorite, null) },
            label = { Text(text = "Pantalla3_2")}
        )
    }

}