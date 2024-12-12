package com.example.teoria_examen

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.teoria_examen.calculadora.Calculadora
import com.example.teoria_examen.ui.theme.Teoria_ExamenTheme

class SegundaActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Teoria_ExamenTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Calculadora(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Botonera3(calculadora: Calculadora, estadoPantalla: EstadoPantalla){
    Column {
        var numeros = listOf("1", "2", "3", "4", "5", "6", "7", "8", "9")
        var id = 0
        for (i in 1..3){
            Row {
                for (j in 1..3){
                    var num = numeros[id]
                    Button(onClick = { gestionBotonesRef(num, calculadora, estadoPantalla) }) {
                        Text(
                            text = num
                        )
                    }
                    id++
                }
            }
        }
        Row {
            Button(onClick = {calculadora.reset()
                estadoPantalla.pantalla="0.0"}) { Text(text = "C") }
            Button(onClick = { gestionBotonesRef("0", calculadora, estadoPantalla) }) {
                Text(text = "0")
            }
            Button(onClick = {estadoPantalla.pantalla = calculadora.resuelveAddOperacion()}) { Text(text = "=") }
        }
    }
}

@Composable
fun BotonesOperacion3(calculadora: Calculadora, estadoPantalla: EstadoPantalla){
    val operaciones = listOf("+" to "suma", "-" to "resta", "x" to "multiplica", "/" to "divide", "^2" to "cuadrado", "Raíz" to "raizCuadrada")
    Column {
        operaciones.forEach { (simbolo, operacion) ->
            Button(onClick = {estadoPantalla.pantalla = calculadora.resuelveAddOperacion(operacion)}) { Text(text = simbolo) }
        }
    }
}

fun gestionBotonesRef( s: String, calculadora:Calculadora, estadoPantalla:EstadoPantalla) {
    var n = s.toDouble()
    if (calculadora.operacion == "") {
        calculadora.operando1 = (calculadora.operando1 * 10) + n
        estadoPantalla.pantalla=""+calculadora.operando1

    } else {
        calculadora.operando2 = (calculadora.operando2 * 10) + n
        estadoPantalla.pantalla=""+calculadora.operando2
    }
}

@Composable
fun Calculadora(name: String, modifier: Modifier = Modifier) {
    val context = LocalContext.current
    var calculadora: Calculadora by remember {mutableStateOf(Calculadora())}
    var estadoPantalla = remember {EstadoPantalla()}
    Column(modifier = modifier.padding(vertical = 25.dp)) {
        Text(
            text = "Calculadora",
            modifier = Modifier
                .border(BorderStroke(1.dp, Color.Black))
                .padding(5.dp),
            fontSize = 32.sp
        )
        Spacer(modifier = Modifier.height(15.dp))
        Text(
            text = estadoPantalla.pantalla,
            fontSize = 24.sp,modifier = Modifier.fillMaxWidth()
                .border(BorderStroke(1.dp, Color.Black))
                .padding(16.dp),textAlign = TextAlign.End
        )
        Row{
            Botonera3(calculadora, estadoPantalla)
            BotonesOperacion3(calculadora, estadoPantalla)
        }
        Spacer(modifier = Modifier.height(100.dp))
        Button(onClick = {mainActivity(context)}) { Text(text = "Formulario") }
    }
}

class EstadoPantalla(){
    var pantalla by mutableStateOf("0")
}

fun mainActivity(context: Context) {
    context.startActivity(Intent(context, MainActivity::class.java))
}