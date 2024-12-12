package com.example.examenjpc_1.componentes

import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember

@Composable
fun NavigationButton(screen: MutableState<Int>) {

    Row(){
        Button(
            onClick = {screen.value=0}
        ){Text( text="Principal")}
        Button(
            onClick = {screen.value=1}
        ){Text( text="Formulario")}
        Button(
            onClick = {
               screen.value=2}
        ){Text( text="Listado")}

    }


}

