package com.example.probandocomponentes.componentes

import android.widget.Toast
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.example.probandocomponentes.modelo.Persona
import com.example.probandocomponentes.modelo.getPersonas


@Composable
fun SimpleRecyclerView(){

    val lista= listOf("dato 1","dato 2","dato 3")

    LazyColumn {
        //Introducimos item uno a uno
        item{Text(text= "primer item")}
        item{Text(text= "segundo item")}

        //Segunda forma
        items (3){
            Text(text= "item repetido Nº $it")
        }

        //Tercera forma la más usual, recibimos datos

        items(lista){
            Text(text= ""+it)
        }
    }
}

@Composable
fun MyRecyclerView(){
    val context = LocalContext.current
    LazyColumn {

        items(getPersonas()){persona->
          MyItem(persona){
              Toast.makeText(context, persona.nombre, Toast.LENGTH_SHORT).show()
          }
        }
    }

}
@Composable
fun MyItem(persona: Persona, onClickItem:(Persona)->Unit){
    Card (border= BorderStroke(2.dp, Color.Blue),
          modifier= Modifier
              .width(200.dp)
              .clickable { onClickItem(persona) })
          {
            Row(){
                Text(text=persona.nombre)
                Text(text=""+persona.edad)
            }
    }

}


