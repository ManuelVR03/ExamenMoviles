package com.example.teoria_examen.formulario

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun MiMenuDesplegable(opciones:List<String>, seleccion: MutableState<String>) {
    var menu by remember { mutableStateOf(false) }

    Box(
        modifier = Modifier
            .padding(16.dp)
            .clickable { menu = !menu }
            .background(Color.LightGray)
            .padding(16.dp)
    ) {

        if (!menu) {
            Text(text = seleccion.value)
        } else {
            // Menú desplegable
            Column(
                modifier = Modifier
                    .background(Color.White)
                    .padding(8.dp)
                    .align(Alignment.TopStart)
            ) {
                opciones.forEach { opcion ->
                    Text(
                        text = opcion,
                        modifier = Modifier
                            .fillMaxWidth()
                            .clickable {
                                seleccion.value = opcion
                                menu = false
                            }
                            .padding(8.dp)
                    )
                }
            }
        }
    }
}