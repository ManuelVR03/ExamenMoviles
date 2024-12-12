package com.example.examenjpc_1.componentes

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

//Ejemplo práctico de una función de orden superior a la que se le
//pasa una función lambda y que es definida en otro sitio.
//VENTAJA: Allí donde es definida puede usar las variables de aquel contexto
//y no tenemos que pasarselas a esta función como hemos hecho hasta ahora
@Composable
fun AlertDialogo(texto:String, lambda:(borrado:Boolean)->Unit ) {

    Box(
        modifier = Modifier
            .fillMaxSize() // Hace que el Box ocupe toda la pantalla
            .wrapContentSize(Alignment.Center) // Centra el contenido en el medio de la pantalla
            .background(Color.LightGray, shape = RoundedCornerShape(8.dp))
            .padding(16.dp)
    ){
        Column(){
            Text (text=texto)
            Row(){
                //Las funciones Lambda son llamadas, pero no sabemos que hacen
                //Solo sabemos que le tenemos que pasar un boolean
                Button(onClick ={lambda(true)} ){ Text(text="Aceptar") }
                Button(onClick ={lambda(false)} ){ Text(text="Cancelar") }
            }
        }
    }

}