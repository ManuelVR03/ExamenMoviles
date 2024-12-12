package com.example.examenjpc_1

import BD_Fichero_Android
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Scaffold
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.examenjpc_1.componentes.DrawerContent
import com.example.examenjpc_1.componentes.MiTopAppBar
import com.example.examenjpc_1.componentes.NavigationButton
import com.example.examenjpc_1.screens.Formulario
import com.example.examenjpc_1.screens.Inicio

import com.example.examenjpc_1.screens.ListadoDetalle
import com.example.examenjpc_1.screens.Ruta
import com.example.examenjpc_1.ui.theme.ExamenJPC_1Theme
import kotlinx.coroutines.launch
import modelo.ComponenteDieta

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ExamenJPC_1Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Main(modifier = Modifier.padding(innerPadding),
                        name = "GESTIÓN DE ALIMENTOS")
                }

            }
        }
    }
}

@Composable
fun Main(modifier: Modifier = Modifier, name: String) {

    val context = LocalContext.current
    val bdFichero: BD_Fichero_Android=BD_Fichero_Android(context, "alimentos")

    val navigationController = rememberNavController()
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scope = rememberCoroutineScope()

    var alimentos = remember { mutableStateListOf<ComponenteDieta>() }


    Column(modifier.padding(20.dp)){
        ModalNavigationDrawer(
            drawerState = drawerState,
            drawerContent = {
                DrawerContent {
                        route -> scope.launch { drawerState.close() }
                    navigationController.navigate(route)
                }
            }
        ){
            Scaffold(
                topBar = {
                    MiTopAppBar(onMenuClick = { scope.launch { drawerState.open() } })
                }
            ){ paddingValues ->
                //lo mismo que el proyecto anterior
                NavHost(
                    navController = navigationController,
                    startDestination = Ruta.Inicio.ruta,
                    modifier = Modifier.padding(paddingValues)
                ) {
                    composable(Ruta.Inicio.ruta) { Inicio(bdFichero,alimentos) }
                    composable(Ruta.Formulario.ruta) { Formulario(alimentos) }
                    composable(Ruta.ListadoDetalle.ruta) { ListadoDetalle(alimentos) }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun Main() {

}