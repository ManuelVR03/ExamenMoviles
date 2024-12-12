package com.example.examenjpc_1.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.examenjpc_1.modelo.Alimento

@Composable
fun Formulario(lista: SnapshotStateList<Alimento>){

    var alimento by remember{mutableStateOf(Alimento())}
    var text1 by remember{mutableStateOf("")}
    var text2 by remember{mutableStateOf("")}
    var text3 by remember{mutableStateOf("")}
    var text4 by remember{mutableStateOf("")}
    var text5 by remember{mutableStateOf("")}

        Box(modifier = Modifier.fillMaxWidth()) {
            Column(){
                Text(text=""+alimento.calculaKcal())
                TextField(
                    value =text1,
                    onValueChange = { newText ->
                        alimento.nombre = newText
                        text1=newText},
                    label = { Text("Escribe nombre") },
                    placeholder = { Text("Introduce nombre aquí") },
                    modifier = Modifier.fillMaxWidth()
                )
                TextField(
                    value =text2,
                    onValueChange = { newText ->
                        alimento.grProt = newText.toDoubleOrNull()?:0.0
                        text2=newText},
                    label = { Text("Cantidad de proteínas por 100 grs") },
                    placeholder = { Text("Introduce cantidad aquí") },
                    modifier = Modifier.fillMaxWidth()
                )
                TextField(
                    value =text3,
                    onValueChange = { newText ->
                        alimento.grHC = newText.toDoubleOrNull()?:0.0
                        text3=newText},
                    label = { Text("Cantidad de Hidratos de carbono por 100 grs") },
                    placeholder = { Text("Introduce cantidad aquí") },
                    modifier = Modifier.fillMaxWidth()
                )
                TextField(
                    value =text4,
                    onValueChange = { newText ->
                        alimento.grLip =newText.toDoubleOrNull()?:0.0
                        text4=newText},
                    label = { Text("Cantidad de Lípidos por 100 grs") },
                    placeholder = { Text("Introduce cantidad aquí") },
                    modifier = Modifier.fillMaxWidth()
                )
                TextField(
                    value =text5,
                    onValueChange = { newText ->
                        alimento.cantidad = newText.toDoubleOrNull()?:0.0
                        text5=newText},
                    label = { Text("Cantidad de alimento en gramos") },
                    placeholder = { Text("Introduce cantidad aquí") },
                    modifier = Modifier.fillMaxWidth()
                )
                  Button(
                    onClick = {
                        lista.add(alimento) //Se añade a la lista
                        alimento=Alimento() //Se crea alimento nuevo
                        //Se borran campos
                        text1 = ""
                        text2 = ""
                        text3 = ""
                        text4 = ""
                        text5 = ""

                    }
                ) { Text(text = "Aceptar") } //Al hacer click se guarda ese nombre en el listado


            }
        }

    }




