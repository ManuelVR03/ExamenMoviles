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
fun screen2_1(navController: NavHostController){
    Box(modifier = Modifier
        .fillMaxSize()
        .background(Color.Magenta)

    ){
        Text(text="Pantalla 2_1",modifier= Modifier.align(Alignment.Center)
            .clickable { navController.navigate(Ruta.Pantalla2.ruta) })
    }

}