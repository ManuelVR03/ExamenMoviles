package com.example.probandocomponentes.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.Icon
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.probandocomponentes.componentes.HomeScreen
import com.example.probandocomponentes.componentes.ProfileScreen
import com.example.probandocomponentes.componentes.SettingScreen
import com.example.probandocomponentes.componentes.TabData
import com.example.probandocomponentes.screens.Ruta.Pantalla2_1
import com.example.probandocomponentes.screens.Ruta.Pantalla2_2

@Composable
fun screen2(navController: NavHostController) {
    val tabs = listOf(
        TabData("Pantalla2", Icons.Filled.Home),
        TabData("Pantalla2_1", Icons.Filled.PermIdentity),
        TabData("Pantalla2_2", Icons.Filled.Person),
    )
    //Es una variable de estado (mutableStateOf) que guarda cuál pestaña está seleccionada actualmente.
    //Inicialmente, la pestaña seleccionada es la primera (0).
    val selectedTab = remember { mutableStateOf(0) }

    Column {
        //Es el contenedor principal que muestra las pestañas de forma horizontal.
        //selectedTabIndex sspecifica cuál pestaña está actualmente seleccionada. Se actualiza dinámicamente con selectedTab.value.
        TabRow(selectedTabIndex = selectedTab.value) {
            tabs.forEachIndexed { index, tab ->
                //Representa cada pestaña individual dentro de TabRow.
                Tab(
                    selected = selectedTab.value == index, //Define si esta pestaña está seleccionada comparando su índice con selectedTab.value.
                    onClick = {
                        selectedTab.value = index //Cambia el estado de selectedTab al índice de la pestaña seleccionada.
                    },
                    text = { Text(text = tab.title) }, //Muestra el título del tab.
                    icon = {
                        Icon(
                            imageVector = tab.icon,
                            contentDescription = null
                        )
                    } //Muestra el ícono correspondiente.
                )
            }
        }
        when (selectedTab.value) {
            0 -> Box(modifier = Modifier
                    .fillMaxSize()
                    .background(Color.Cyan)

                ){
                    Text(text="PAGINA 2",modifier= Modifier.align(Alignment.Center)
                        .clickable { navController.navigate(Ruta.Pantalla3.ruta) })
                }
            1 -> navController.navigate(Ruta.Pantalla2_1.ruta)
            2 -> navController.navigate(Ruta.Pantalla2_2.ruta)
        }
    }
}
//Creamos una data class para el texto y el titulo del Tab
data class TabData(val title: String, val icon: ImageVector, val route: String)