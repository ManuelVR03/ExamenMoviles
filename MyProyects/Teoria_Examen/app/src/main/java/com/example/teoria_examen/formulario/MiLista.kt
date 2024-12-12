package com.example.teoria_examen.formulario

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.Modifier
import com.example.teoria_examen.dataclass.Persona

@Composable
fun MiLista(personas: SnapshotStateList<Persona>){
    Column(modifier = Modifier.fillMaxWidth()) {
        Text(text = "Listado: ")
        personas.forEach {
            Text(text = it.nombre + " " + it.apellido + " " + it.sexo
                    + if (it.carnet) " Permiso B" else{""} + if (it.master) " Master" else "",
                Modifier.clickable{personas.remove(it)})
        }
    }
}