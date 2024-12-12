package com.example.probandocomponentes

import android.widget.Toast
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.PointerIcon.Companion.Text
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.example.probandocomponentes.modelo.Persona
import com.example.probandocomponentes.modelo.getPersonas


@Composable
fun SimpleRecyclerView(){

    val lista= listOf("dato 1","dato 2","dato 3")

    //Lista simple estática
    //Útil para mostrar datos predefinidos o pequeños ejemplos.
    //Incluye elementos individuales (item) y listas dinámicas (items).
    LazyColumn {
        // Primera forma: Introducir elementos uno por uno con `item`.
        // Es útil para casos específicos donde queremos añadir elementos individuales a la lista.
        item{Text(text= "primer item")}
        item{Text(text= "segundo item")}

        // Segunda forma: Añadir elementos dinámicos mediante un bucle.
        // En este caso, creamos 3 elementos repetidos (0, 1, 2) usando el índice `it`.
        items (3){
            Text(text= "item repetido Nº $it")
        }

        // Tercera forma: La más común, basada en datos predefinidos.
        // Recorremos la lista `lista` y mostramos cada elemento como texto.

        items(lista){
            Text(text= ""+it)
        }
    }
}

//Lista dinámica con objetos
//Diseñada para trabajar con datos complejos, en este caso, objetos Persona.
//Utiliza un modelo de datos (Persona) y una función (getPersonas) para obtener la información que se muestra.
//Cada elemento de la lista es interactivo: al hacer clic, muestra un mensaje emergente (Toast).
@Composable
fun MyRecyclerView(){
    //esto es necesario para TOAST
    val context = LocalContext.current
    //lazy column es un componente para mostrar listas, esa lista va a contener varios items que esos items se sacan del metodo getpersonas
    // que recorre la lista es decir seria como un bucle y por cada persona llamamos a la funcion myitem y
    // le pasamos ese indice persona que nos va a permitir mostrar en un elemento carta el nombre y la edad de esa persona.
    LazyColumn {
        items(getPersonas()){persona->
          MyItem(persona){
              //cuando el último parámetro de una función es un lambda, puedes usar una sintaxis especial para pasarlo fuera de los paréntesis.
              //Esto indica que cuando se haga click en una carta se ejecute esta parte de codigo
              // Muestra un mensaje emergente con el nombre de la persona sobre la que se hizo click, por un periodo corto
              //de tiempo y el show que es necesario para mostrarlo.
              Toast.makeText(context, persona.nombre, Toast.LENGTH_SHORT).show()
          }
        }
    }

}
@Composable
fun MyItem(persona: Persona, onClickItem:(Persona)->Unit){
    //El parametro onClickItem:(Persona) es una funcion lambda.

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


