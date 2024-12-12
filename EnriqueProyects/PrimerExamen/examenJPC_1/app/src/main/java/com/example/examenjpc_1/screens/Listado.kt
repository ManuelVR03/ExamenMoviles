package com.example.examenjpc_1.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box


import androidx.compose.foundation.layout.Column

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.snapshots.SnapshotStateList

import androidx.compose.ui.Modifier

import androidx.compose.foundation.layout.fillMaxSize

import com.example.examenjpc_1.componentes.AlertDialogo

import com.example.examenjpc_1.modelo.Alimento


@Composable
fun ListadoDetalle(alimentos: SnapshotStateList<Alimento>){

    var refAlimento by remember{mutableStateOf<Alimento>(Alimento())}

    //La sentencia de abajo es más apropiada, pero como no lo hemos visto en clase,
    //la de arriba también vale
    //var refAlimento by remember{mutableStateOf<Alimento?>(null)}

    var mostrarDialogo by remember{mutableStateOf<Boolean>(false)}

    Box( modifier = Modifier
        .fillMaxSize()){

            Column(){
                alimentos.forEachIndexed{ i, alimento->
                    Text(text="${alimento.nombre}: ${alimento.cantidad} grs: ${alimento.KcalTotales} KCal",
                        Modifier.clickable {
                            refAlimento=alimento
                            mostrarDialogo=true
                        }
                    )
                }

            }
        //Aquí se implementa la función Lambda que nos interesa
        if(mostrarDialogo){
            AlertDialogo("Está seguro de que quiere borrar?") {
                if (it) {
                    alimentos.remove(refAlimento)
                    mostrarDialogo = false
                } else {
                    mostrarDialogo = false
                }
            }
        }
    }



}


