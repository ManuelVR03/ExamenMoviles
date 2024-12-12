package com.example.probandocomponentes

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Scaffold
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.probandocomponentes.componentes.DrawerContent
import com.example.probandocomponentes.componentes.MiTopAppBar
import com.example.probandocomponentes.screens.Ruta

import com.example.probandocomponentes.screens.Ruta.Pantalla1
import com.example.probandocomponentes.screens.Ruta.Pantalla2
import com.example.probandocomponentes.screens.Ruta.Pantalla3
import com.example.probandocomponentes.screens.screen1
import com.example.probandocomponentes.screens.screen2
import com.example.probandocomponentes.screens.screen2_1
import com.example.probandocomponentes.screens.screen2_2
import com.example.probandocomponentes.screens.screen3
import com.example.probandocomponentes.screens.screen3_1
import com.example.probandocomponentes.screens.screen3_2
import kotlinx.coroutines.launch
@OptIn(ExperimentalMaterial3Api::class)
//TAREA 1: En el mismo proyecto usar en la pantalla 2 el componente Tab para navegar a otras dos pantallas y en la pantalla 3 el Button Navigation para navegar a otras dos diferentes. Todas las rutas usan el mismo Nav Host
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            //Controlador de navegación para gestionar las pantallas activas.
            //Se pasa a todas las pantallas para permitir la navegación.
            val navigationController = rememberNavController()
            //Controla si el drawer (menú lateral) está abierto o cerrado.
            //DrawerValue.Closed significa que el drawer está cerrado inicialmente
            val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
            //Esto se usa para controlar la apertura y cierre del drawer con scope.launch {}.
            val scope = rememberCoroutineScope()

            //Componente que muestra un drawer lateral deslizante.
            ModalNavigationDrawer(
                //Para abrir y cerrar el drawer.
                drawerState = drawerState,
                // El contenido del drawer (un menú con enlaces).
                drawerContent = {
                    DrawerContent {
                        //Cada vez que se selecciona una opción del menú, se cierra el drawer con:
                        route -> scope.launch { drawerState.close() }
                        navigationController.navigate(route)
                    }
                }
            ) {
                //Proporciona la estructura de la pantalla principal.
                Scaffold(
                    //Es un parámetro de Scaffold que se usa para definir la barra superior.
                    //Aquí se pasa la función MiTopAppBar para que se muestre la barra en la parte superior de la pantalla.
                    topBar = {
                        //Barra superior que muestra un ícono de menú (hamburguesa).
                        //Se pasa una función lambda que se ejecuta al hacer clic en el ícono de menú (hamburguesa).
                        //La acción de esta función es abrir el drawer
                        MiTopAppBar(onMenuClick = { scope.launch { drawerState.open() } })
                    }
                    //se usa para definir el espacio disponible para el contenido.
                    //Viene de Scaffold y permite que el contenido no se superponga con la barra superior, barra inferior o drawer.
                    //Se aplica con Modifier.padding(paddingValues) para respetar los márgenes.
                    //Los cuatro lados de padding (top, bottom, start, end) se calculan automáticamente.
                ) { paddingValues ->
                    //lo mismo que el proyecto anterior
                    NavHost(
                        navController = navigationController,
                        startDestination = Ruta.Pantalla1.ruta,
                        modifier = Modifier.padding(paddingValues)
                    ) {
                        composable(Ruta.Pantalla1.ruta) { screen1(navigationController) }
                        composable(Ruta.Pantalla2.ruta) { screen2(navigationController) }
                        composable(Ruta.Pantalla2_1.ruta) { screen2_1(navigationController) }
                        composable(Ruta.Pantalla2_2.ruta) { screen2_2(navigationController) }
                        composable(Ruta.Pantalla3.ruta) { screen3(navigationController) }
                        composable(Ruta.Pantalla3_1.ruta) { screen3_1(navigationController) }
                        composable(Ruta.Pantalla3_2.ruta) { screen3_2(navigationController) }
                    }
                }
            }
        }
    }

}

