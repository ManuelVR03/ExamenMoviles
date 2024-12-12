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
import com.example.probandocomponentes.screens.Ruta.Pantalla3



@Composable
fun screen2(navController: NavHostController){
    Box(modifier = Modifier
        .fillMaxSize()
        .background(Color.Red)

    ){
        Text(text="pantalla 2",modifier= Modifier.align(Alignment.Center)
            .clickable { navController.navigate(Pantalla3.ruta) })
    }

}