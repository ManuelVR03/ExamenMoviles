package com.example.probandocomponentes.componentes

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material3.Icon
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.NavigationDrawerItemDefaults

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import com.example.probandocomponentes.screens.Ruta

@OptIn(ExperimentalMaterial3Api::class)
@Composable
//menú lateral que se abre desde la izquierda.
fun DrawerContent(onDestinationClicked: (String) -> Unit) {
    //Se crea una lista de objetos de tipo NavigationItem
    //Cada elemento define:
    //title: El título de la opción que se muestra en el menú (por ejemplo, Pantalla 1).
    //route: La ruta asociada con esa opción (por ejemplo, Ruta.Pantalla1.ruta).
    //selectedIcon: El ícono que se muestra cuando la opción está seleccionada (por ejemplo, Icons.Filled.Home).
    //unselectedIcon: El ícono que se muestra cuando la opción no está seleccionada (por ejemplo, Icons.Outlined.Home).
    val items = listOf(
        NavigationItem("Pantalla 1", Ruta.Pantalla1.ruta, Icons.Filled.Home, Icons.Outlined.Home),
        NavigationItem("Pantalla 2", Ruta.Pantalla2.ruta, Icons.Filled.Person, Icons.Outlined.Person),
        NavigationItem("Pantalla 3", Ruta.Pantalla3.ruta, Icons.Filled.Settings, Icons.Outlined.Settings)
    )
    //Crea la hoja de navegación lateral (drawer) que se muestra cuando el usuario abre el menú.
    //Contiene la lista de elementos de navegación.
    ModalDrawerSheet {
        Spacer(modifier = Modifier.height(24.dp))// Espacio entre la parte superior y el primer elemento
        items.forEach { item ->
            //Cada opción de navegación dentro del drawer.
            NavigationDrawerItem(
                // texto que se muestra en la opción.
                label = { Text(text = item.title) },
                //Define si la opción está seleccionada o no.
                selected = false, // No gestionamos selección aquí
                //Acción que se ejecuta al hacer clic en la opción (navegar a la ruta correspondiente).
                onClick = { onDestinationClicked(item.route) },
                //El ícono que se muestra a la izquierda de la opción.
                icon = {
                    Icon(imageVector = item.selectedIcon, contentDescription =item.title)
                },
                modifier = Modifier.padding(NavigationDrawerItemDefaults.ItemPadding)
            )
        }
    }
}

//es una data class que define la estructura de cada elemento del drawer.
data class NavigationItem(
    val title: String,
    val route: String,
    val selectedIcon: ImageVector,
    val unselectedIcon: ImageVector
)