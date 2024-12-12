package com.example.teoria_examen.formulario

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.teoria_examen.dataclass.Persona

@Composable
fun Formulario(personas: SnapshotStateList<Persona>, nombre: MutableState<String>, apellido: MutableState<String>,
               sexos: List<String>, seleccion: MutableState<String>, checkeds: List<String>, checkList: SnapshotStateList<Boolean>) {
    Column() {
        TextField(
            value = nombre.value,
            onValueChange = { newText -> nombre.value = newText },
            label = { Text("Escribe nombre") },
            placeholder = { Text("Introduce texto aquí") },
            modifier = Modifier.fillMaxWidth()
        )
        TextField(
            value = apellido.value,
            onValueChange = { newText2 -> apellido.value = newText2 },
            label = { Text("Escribe apellido") },
            placeholder = { Text("Introduce texto aquí") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(10.dp))
        MiRadioButton(sexos, seleccion)
        Spacer(modifier = Modifier.height(10.dp))
        MiCheckBox(checkeds, checkList)
        Spacer(modifier = Modifier.height(10.dp))
        MiMenuDesplegable(sexos, seleccion)
        Button(onClick = {
            personas.add(
                Persona
                    (nombre.value, apellido.value, seleccion.value, checkList[0], checkList[1])
            )
            Resetea(nombre, apellido, seleccion, checkList)
        })
        { Text(text = "Enviar") }
        Spacer(modifier = Modifier.height(10.dp))
        MiLista(personas)


    }
}

fun Resetea(nombre: MutableState<String>, apellido: MutableState<String>, seleccion: MutableState<String>, checkList: SnapshotStateList<Boolean>){
    nombre.value = ""
    apellido.value = ""
    seleccion.value = "Hombre"
    for (i in checkList.indices)
        checkList[i] = false
    // checkList.fill(false)
}
