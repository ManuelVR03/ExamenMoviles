package com.example.probandocomponentes.componentes

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarDefaults
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@Composable
fun NavigationBarExample() {
    NavigationBar( windowInsets = NavigationBarDefaults.windowInsets ){
        NavigationBarItem(
            selected = true,
            onClick = { /*TODO*/ },
            icon = { Icon( Icons.Filled.Favorite, null) },
            label = { Text(text = "Aris")}
        )
        NavigationBarItem(
            selected = false,
            onClick = { /*TODO*/ },
            icon = { Icon( Icons.Filled.Favorite, null) },
            label = { Text(text = "Aris")}
        )
        NavigationBarItem(
            selected = false,
            onClick = { /*TODO*/ },
            icon = { Icon( Icons.Filled.Favorite, null) },
            label = { Text(text = "Aris")}
        )
        NavigationBarItem(
            selected = true,
            onClick = { /*TODO*/ },
            icon = { Icon( Icons.Filled.Favorite, null) },
            label = { Text(text = "Aris")}
        )
    }
}