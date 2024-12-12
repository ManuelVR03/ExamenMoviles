package com.example.probandocomponentes.componentes

import androidx.compose.foundation.layout.Column
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Icon
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.vector.ImageVector
//Este código implementa un sistema de pestañas (tabs), donde cada pestaña tiene un ícono, un título,
// y muestra contenido diferente al seleccionarse.
@Composable
fun TabExample() {
    //Una lista de objetos TabData, que contiene el título (title) y el ícono (icon) de cada pestaña.
    val tabs = listOf(
        TabData("Home", Icons.Filled.Home),
        TabData("Profile", Icons.Filled.Person),
        TabData("Setting", Icons.Filled.Settings)
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
                    onClick = { selectedTab.value = index }, //Cambia el estado de selectedTab al índice de la pestaña seleccionada.
                    text = { Text(text = tab.title) }, //Muestra el título del tab.
                    icon = { Icon(
                        imageVector = tab.icon,
                        contentDescription = null
                    )} //Muestra el ícono correspondiente.
                )
            }
        }

        // Contenido para cada tab
        //Evalúa cuál pestaña está seleccionada (selectedTab.value) y muestra el contenido correspondiente.
        when (selectedTab.value) {
            0 -> HomeScreen()
            1 -> ProfileScreen()
            2 -> SettingScreen()
        }
    }
}

//Creamos una data class para el texto y el titulo del Tab
data class TabData(val title: String, val icon: ImageVector)

//Estas funciones definen el contenido de cada pestaña.
@Composable
fun HomeScreen() {
    // Contenido pantalla Home
}

@Composable
fun ProfileScreen() {
    // Contenido pantalla Profile
}

@Composable
fun SettingScreen() {
    NavigationBarExample()
}