package com.example.examenjpc_1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.examenjpc_1.componentes.NavigationButton
import com.example.examenjpc_1.modelo.Alimento
import com.example.examenjpc_1.screens.Formulario
import com.example.examenjpc_1.screens.Inicio

import com.example.examenjpc_1.screens.ListadoDetalle
import com.example.examenjpc_1.ui.theme.ExamenJPC_1Theme
import java.security.Principal

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ExamenJPC_1Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Main(modifier = Modifier.padding(innerPadding),
                        name = "GESTIÓN DE ALIMENTOS")
                }

            }
        }
    }
}

@Composable
fun Main(modifier: Modifier = Modifier, name: String) {


    var screen = remember { mutableStateOf(0) }
    val alimentos = remember { mutableStateListOf<Alimento>() }



    Column(modifier.padding(20.dp)){

        NavigationButton(screen)

        Box() {
            when (screen.value) {
                0 -> Inicio()
                1 -> Formulario(alimentos)
                2 -> ListadoDetalle(alimentos)

            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun Main() {

}