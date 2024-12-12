package com.example.probandocomponentes.componentes

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.fillMaxSize
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
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import androidx.compose.ui.Alignment
import androidx.compose.foundation.layout.Box

@Composable
fun TabExample() {
    val tabs = listOf(
        TabData("Home", Icons.Filled.Home),
        TabData("Profile", Icons.Filled.Person),
        TabData("Setting", Icons.Filled.Settings)
    )
    val selectedTab = remember { mutableStateOf(0) }

    // Usamos Box para poder controlar la posición del TabRow
    Box(modifier = Modifier.fillMaxSize()) {
        // Contenido de cada tab en la parte superior
        Column(Modifier.padding(top = 55.dp)) {
            when (selectedTab.value) {
                0 -> HomeScreen()
                1 -> ProfileScreen()
                2 -> SettingScreen()
            }
        }

        // Alineamos el TabRow al centro y fondo de la pantalla
        TabRow(
            selectedTabIndex = selectedTab.value,
            modifier = Modifier.align(Alignment.BottomCenter) // Alinea el TabRow al fondo y al centro
        ) {
            tabs.forEachIndexed { index, tab ->
                Tab(
                    selected = selectedTab.value == index,
                    onClick = { selectedTab.value = index },
                    text = { Text(text = tab.title) },
                    icon = {
                        Icon(
                            imageVector = tab.icon,
                            contentDescription = null // Provide a content description if needed
                        )
                    }
                )
            }
        }
    }
}

// Creamos una data class para el texto y el icono del Tab
data class TabData(val title: String, val icon: ImageVector)

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
