package com.example.teoria_examen

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.teoria_examen.dataclass.Persona
import com.example.teoria_examen.formulario.Formulario
import com.example.teoria_examen.ui.theme.Teoria_ExamenTheme
import com.example.teoria_examen.variables.Variables
import com.example.teoria_examen.variables.VariablesComposables

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Teoria_ExamenTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Principal(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Principal(name: String, modifier: Modifier = Modifier) {
    val context = LocalContext.current
    var personas = remember { mutableStateListOf<Persona>() }
    var nombre = remember { mutableStateOf<String>("") }
    var apellido = remember{ mutableStateOf<String>("") }
    var sexos = listOf("Hombre", "Mujer")
    var seleccion = remember { mutableStateOf("Hombre") }
    var checkeds = listOf("Carnet", "Master")
    var checkList = remember { mutableStateListOf<Boolean>() }
    checkList.addAll(List(checkeds.size){false})
    Column(modifier = modifier.padding(vertical = 25.dp)) {
        Text(
            text = "Formulario",
            modifier = Modifier
                .border(BorderStroke(1.dp, Color.Black))
                .padding(5.dp),
            fontSize = 32.sp
        )
        Spacer(modifier = Modifier.height(15.dp))
        Formulario(personas, nombre, apellido, sexos, seleccion, checkeds, checkList)
        Spacer(modifier = Modifier.height(150.dp))
        Row(horizontalArrangement = Arrangement.Center, modifier = Modifier.fillMaxWidth()) {
            Button(onClick = {segundaActivity(context)}) { Text(text = "Calculadora") }
            Button(onClick = {variables(context)}) { Text(text = "Variables") }
        }

    }
}

fun segundaActivity(context: Context) {
    context.startActivity(Intent(context, SegundaActivity::class.java))
}

fun variables(context: Context) {
    context.startActivity(Intent(context, VariablesComposables::class.java))
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Teoria_ExamenTheme {
        Principal("Android")
    }
}