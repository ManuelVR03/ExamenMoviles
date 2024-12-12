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
            //Esta variable contiene la pantalla actual y las que hemos visitando antes. Y le ponemos remeber para que no se vuelva
            // a crear en cada pantalla  con un valor inicial desde 0.
            val navigationController= rememberNavController()
            //NavHost es como un contenedor al que le apso por parametro la variable de antes y la ruta inicial donde se va a cargar la app.
            /*NavHost(navController = navigationController, startDestination = Pantalla1.ruta){
                //Creamos las rutas a las diferentes pantallas y con una lambda le indicamos que cuando navegas a cada pantalla, se ejecute
                //la pantalla de cada una(contenido que debe mostrarse).
                //Al recibir por parametro la variable navigation, esas pantallas pueden volver a la anterior o navegar entre ellas.
                composable(Pantalla1.ruta){screen1(navigationController)}
                composable(Pantalla2.ruta){screen2(navigationController)}
                composable(Pantalla3.ruta){screen3(navigationController)}

            }*/
            TabExample()
        }
    }
}
