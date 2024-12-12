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

@Composable
fun TabExample() {
    val tabs = listOf(
        TabData("Home", Icons.Filled.Home),
        TabData("Profile", Icons.Filled.Person),
        TabData("Setting", Icons.Filled.Settings)
    )
    val selectedTab = remember { mutableStateOf(0) }

    Column {
        TabRow(selectedTabIndex = selectedTab.value) {
            tabs.forEachIndexed { index, tab ->
                Tab(
                    selected = selectedTab.value == index,
                    onClick = { selectedTab.value = index },
                    text = { Text(text = tab.title) },
                    icon = { Icon(
                        imageVector = tab.icon,
                        contentDescription = null // Provide a content description if needed
                    )}
                )
            }
        }

        // Contenido para cada tab
        when (selectedTab.value) {
            0 -> HomeScreen()
            1 -> ProfileScreen()
            2 -> SettingScreen()
        }
    }
}

//Creamos una data class para el texto y el titulo del Tab
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