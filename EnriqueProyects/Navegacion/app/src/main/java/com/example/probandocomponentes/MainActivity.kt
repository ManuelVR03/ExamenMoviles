package com.example.probandocomponentes

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.probandocomponentes.componentes.TabExample


import com.example.probandocomponentes.screens.Ruta.Pantalla1
import com.example.probandocomponentes.screens.Ruta.Pantalla2
import com.example.probandocomponentes.screens.Ruta.Pantalla3
import com.example.probandocomponentes.screens.screen1
import com.example.probandocomponentes.screens.screen2
import com.example.probandocomponentes.screens.screen3

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            //val navigationController= rememberNavController()
            /*NavHost(navController = navigationController, startDestination = Pantalla1.ruta){
                composable(Pantalla1.ruta){screen1(navigationController)}
                composable(Pantalla2.ruta){screen2(navigationController)}
                composable(Pantalla3.ruta){screen3(navigationController)}
            }
            */
            TabExample()
        }
    }
}
