package com.example.examenjpc_1.screens

import BD_Fichero_Android
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.snapshots.SnapshotStateList
import modelo.ComponenteDieta

@Composable
fun Inicio(bdFichero: BD_Fichero_Android, alimentos: SnapshotStateList<ComponenteDieta>) {
    Row(){
        Button(
            onClick = {
                bdFichero.guardar(alimentos)
            }
        ){Text( text="Guardar archivo")}


        Button(
            onClick = {
               alimentos.addAll(bdFichero.leer())
            }
        ){Text( text="Abrir archivo")}
    }
}