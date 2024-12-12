package com.example.teoria_examen.formulario

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun MiRadioButton(sexos: List<String>, seleccion: MutableState<String>) {

    Column {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = "Sexo: ", Modifier.padding(end = 15.dp))
            for (sexo in sexos) {
                Text(text = sexo)
                RadioButton(selected = seleccion.value == sexo,
                    onClick = { seleccion.value = sexo })
            }

        }
    }
}