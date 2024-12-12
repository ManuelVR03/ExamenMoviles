package com.example.probandocomponentes

import android.os.Bundle
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
import com.example.probandocomponentes.screens.screen1
import com.example.probandocomponentes.screens.screen2
import com.example.probandocomponentes.screens.screen3
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val navigationController = rememberNavController()
            val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
            val scope = rememberCoroutineScope()

            ModalNavigationDrawer(
                drawerState = drawerState,
                drawerContent = {
                    DrawerContent { route ->
                        scope.launch { drawerState.close() }
                        navigationController.navigate(route)
                    }
                }
            ) {
                Scaffold(
                    topBar = {
                        MiTopAppBar(onMenuClick = { scope.launch { drawerState.open() } })
                    }
                ) { paddingValues ->
                    NavHost(
                        navController = navigationController,
                        startDestination = Ruta.Pantalla1.ruta,
                        modifier = Modifier.padding(paddingValues)
                    ) {
                        composable(Ruta.Pantalla1.ruta) { screen1(navigationController) }
                        composable(Ruta.Pantalla2.ruta) { screen2(navigationController) }
                        composable(Ruta.Pantalla3.ruta) { screen3(navigationController) }
                    }
                }
            }
        }
    }

}

