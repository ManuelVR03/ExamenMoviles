package com.example.teoria_examen.variables

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.example.teoria_examen.mainActivity
import com.example.teoria_examen.ui.theme.Teoria_ExamenTheme

class VariablesComposables : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Teoria_ExamenTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Variables(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}



class PantallaTercera(){
    var newPantalla by mutableStateOf("3")
}

@Composable
fun PrimerUso(setPantalla: (String) -> Unit){
Button(onClick = {setPantalla("Hola desde primer uso")}) { Text("Boton 1") }
}

@Composable
fun SegundoUso(pantalla2: MutableState<String>){
    Button(onClick = {pantalla2.value = "Hola desde segundo uso"}) { Text("Boton 2") }
}

@Composable
fun TercerUso(pantalla3: PantallaTercera){
Button(onClick = {pantalla3.newPantalla = "Hola desde tercer uso"}) { Text("Boton 3") }
}


@Composable
fun Variables(name: String, modifier: Modifier){
    val context = LocalContext.current
    // Primera forma
    var pantalla: String by remember { mutableStateOf("1") }
    // Segunda forma
    var pantalla2 = remember { mutableStateOf("2") }
    // Tercera forma
    var pantalla3 = remember { PantallaTercera() }

    Column(modifier = Modifier.padding(vertical = 70.dp)) {
        Text(text = pantalla, Modifier.clickable {pantalla = "1"})
        PrimerUso({newTexto -> pantalla = newTexto})
        Text(text = pantalla2.value, Modifier.clickable {pantalla2.value = "2"})
        SegundoUso(pantalla2)
        Text(text = pantalla3.newPantalla, Modifier.clickable {pantalla3.newPantalla = "3"})
        TercerUso(pantalla3)
        Spacer(modifier = Modifier.height(100.dp))
        Button(onClick = {mainActivity(context)}) { Text(text = "Primer Activity") }
    }
}