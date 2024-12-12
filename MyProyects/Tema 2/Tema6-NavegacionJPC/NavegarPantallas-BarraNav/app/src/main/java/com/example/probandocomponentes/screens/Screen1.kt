package com.example.probandocomponentes.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavHostController
import com.example.probandocomponentes.screens.Ruta.Pantalla2


@Composable
fun screen1(navController: NavHostController) {
    Box(modifier = Modifier
        .fillMaxSize()
        .background(Color.Blue)

    ){
        //texto que permite que cuando lo clickemos nos lleve a la pantalla 2 a traves de la variable que teniamos en el main.
        Text(text="pantalla 1", modifier= Modifier.align(Alignment.Center)
            .clickable { navController.navigate(Pantalla2.ruta) })
    }

}