package com.example.examenjpc_1.componentes

import android.util.Log
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.AccountCircle
import androidx.compose.material.icons.rounded.Menu
import androidx.compose.material.icons.rounded.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable


@OptIn(ExperimentalMaterial3Api::class)
@Composable
//barra superior que incluye un ícono de menú (hamburguesa) para abrir el drawer.
fun MiTopAppBar(onMenuClick: () -> Unit) {
    //Este componente crea la barra superior.
    //Recibe tres parámetros principales.
    TopAppBar(
        // El ícono de menú (hamburguesa) que aparece a la izquierda.
        navigationIcon = {
            //Se coloca un IconButton que contiene el ícono de menú (hamburguesa)
            //Cuando el usuario hace clic en el botón, se llama a onMenuClick.
            //En el MainActivity, la función onMenuClick abre el drawer lateral
            IconButton(onClick =  onMenuClick )  {
                Icon(imageVector = Icons.Rounded.Menu, contentDescription = null)
            }
        },
        //El título de la barra, que se muestra en el centro.
        //Muestra el texto "Gestión de alimentos" en el centro de la barra.
        title = { Text(text = "Gestión de alimentos") },
        //Los íconos de acción que aparecen a la derecha (búsqueda y cuenta de usuario).
        actions = {
            //Ícono de búsqueda
            IconButton(onClick = { /*TODO*/ } ) {
                Icon(
                    imageVector = Icons.Rounded.Search,
                    contentDescription = null
                )
            }
            // Ícono de usuario
            IconButton(onClick = { /*TODO*/ }) {
                Icon(
                    imageVector = Icons.Outlined.AccountCircle,
                    contentDescription = null
                )
            }
        }
    )
}

