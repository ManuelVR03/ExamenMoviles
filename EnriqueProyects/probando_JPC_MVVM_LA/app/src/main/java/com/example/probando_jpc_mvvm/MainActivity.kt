package com.example.probando_jpc_mvvm

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBars
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.probando_jpc_mvvm.model.NumeroModelView
import com.example.probando_jpc_mvvm.model.Persona
import com.example.probando_jpc_mvvm.model.PersonasModelView
import com.example.probando_jpc_mvvm.ui.theme.Probando_JPC_MVVMTheme

class MainActivity : ComponentActivity() {

    val viewModel:NumeroModelView by viewModels()

    val viewModel2: PersonasModelView by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {

            Probando_JPC_MVVMTheme {
                Scaffold(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(WindowInsets.systemBars.asPaddingValues()) // Respeta las barras del sistema
                ) { innerPadding ->
                    Column(modifier = Modifier.padding(innerPadding)){

                        //SinModelView()
                        //ConModelView()
                        //ConModelViewLiveData()
                        val persona =Persona(1, "pepe", 30)
                        viewModel2.guardaPersona(persona)
                        viewModel2.añadirPersona(persona)
                        ProbandoModelViewPersonas()
                    }

                }
            }
        }
    }

@Composable
fun SinModelView() {

    var numero by remember { mutableStateOf(0) }

    Column(){
        Text(
            text = "$numero",
            style = TextStyle(fontWeight = FontWeight.Bold, fontSize = 24.sp)
        )
        MiBoton(numero){numero++}
    }
}
@Composable
fun MiBoton(numero:Int, sumar:(numero:Int)->Unit){
    Button(
        onClick = {sumar(numero)}
    ){Text( text="Sumar Uno")}
}
@Composable
fun ConModelView(){
        //NO ESTÁ FUNCIONANDO, NO ENCUENTRA DEPENDENCIAS
        //val viewModel: NumeroModelView = viewModel()


        Vista(viewModel.numero2){ viewModel.incrementarNumero2()}
    }
@Composable
fun Vista(num: Int, incrementa: ()->Unit) {

        Column(){
            Text(
                text = "$num",
                style = TextStyle(fontWeight = FontWeight.Bold, fontSize = 24.sp)
            )
            Button(
                onClick = incrementa
            ){Text( text="Sumar Uno")}
        }
    }
@Composable
fun ConModelViewLiveData() {
        //val viewModel:NumeroModelView by viewModels()
        // Observa el valor de LiveData
        val numero3 by viewModel.numero3.observeAsState(0)

        Column(modifier = Modifier.padding(16.dp)) {
            Text(
                text = "$numero3",
                style = TextStyle(fontSize = 24.sp)
            )

            Button(
                onClick = { viewModel.incrementarNumero3() }
            ) {
                Text(text = "Sumar Uno (LiveData)")
            }
        }
    }


    @Composable
    fun ProbandoModelViewPersonas() {
        var id by remember { mutableStateOf("") }
        var nombre by remember { mutableStateOf("") }
        var edad by remember { mutableStateOf("") }
        var personaSeleccionada by remember { mutableStateOf<Persona?>(null) }

        val persona by viewModel2.persona.observeAsState(Persona())
        val personas by viewModel2.personas.observeAsState(emptyList())

        Column(modifier = Modifier.padding(16.dp)) {
            OutlinedTextField(
                value = id,
                onValueChange = { id = it },
                label = { Text("ID") },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
            )

            Spacer(modifier = Modifier.height(8.dp))

            OutlinedTextField(
                value = nombre,
                onValueChange = { nombre = it },
                label = { Text("Nombre") },
                modifier = Modifier.fillMaxWidth()
            )

            OutlinedTextField(
                value = edad,
                onValueChange = { edad = it },
                label = { Text("Edad") },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                modifier = Modifier.fillMaxWidth()
            )

            Text(
                text = "${persona?.nombre}, edad: ${persona?.edad} años",
                style = TextStyle(fontSize = 24.sp)
            )
            Button(
                onClick = {
                    val personaNueva = Persona(
                        id = id.toIntOrNull() ?: 0,
                        nombre = nombre,
                        edad = edad.toIntOrNull() ?: 0
                    )
                    viewModel2.guardaPersona(personaNueva)
                    viewModel2.añadirPersona(persona)
                }
            ) {
                Text(text = "Crear Persona")
            }

            Button(
                onClick = {
                    viewModel2.incrementarEdad()
                    viewModel2.actualizarPersona(persona.id, persona)
                }
            ) {
                Text(text = "Incrementar edad")
            }

            if (!personas.isEmpty()) {
                for (p in personas) {
                    Column() {
                        Text(text = "${p.nombre}, edad: ${p.edad} años",
                            modifier = Modifier
                                .fillMaxWidth()
                                .clickable {
                                    personaSeleccionada = persona
                                }
                        )
                    }
                }
            }
        }
        personaSeleccionada?.let { persona ->
            EditarPersonaDialog(
             persona = persona,
             onGuardar = { nuevaPersona ->
                 viewModel2.actualizarPersona(persona.id, nuevaPersona)
             },
             onBorrar = {
                 viewModel2.eliminarPersona(persona.id)
             },
             onDismiss = { personaSeleccionada = null }
         )
    }

    }
    @Composable
    fun EditarPersonaDialog(
        persona: Persona,
        onGuardar: (Persona) -> Unit,
        onBorrar: () -> Unit,
        onDismiss: () -> Unit
    ) {
        var nombre by remember { mutableStateOf(persona.nombre) }
        var edad by remember { mutableStateOf(persona.edad.toString()) }

        AlertDialog(
            onDismissRequest = { onDismiss() },
            title = { Text(text = "Editar Persona") },
            text = {
                Column {
                    OutlinedTextField(
                        value = nombre,
                        onValueChange = { nombre = it },
                        label = { Text(text = "Nombre") }
                    )
                    OutlinedTextField(
                        value = edad,
                        onValueChange = { edad = it },
                        label = { Text(text = "Edad") },
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
                    )
                }
            },
            confirmButton = {
                Row {
                    Button(
                        onClick = {
                            val personaActualizada = persona.copy(
                                nombre = nombre,
                                edad = edad.toIntOrNull() ?: persona.edad
                            )
                            onGuardar(personaActualizada)
                            onDismiss()
                        }
                    ) {
                        Text(text = "Guardar")
                    }

                    Spacer(modifier = Modifier.width(8.dp))

                    Button(
                        onClick = {
                            onBorrar()
                            onDismiss()
                        }
                    ) {
                        Text(text = "Borrar")
                    }
                }
            },
            dismissButton = {
                Button(onClick = onDismiss) {
                    Text(text = "Cancelar")
                }
            }
        )
    }



}
















