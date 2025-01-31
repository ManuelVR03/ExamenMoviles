package com.example.examenjpc_1

import BD_Fichero_Android
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.examenjpc_1.componentes.NavigationButton
import com.example.examenjpc_1.screens.Formulario
import com.example.examenjpc_1.screens.Inicio

import com.example.examenjpc_1.screens.ListadoDetalle
import com.example.examenjpc_1.ui.theme.ExamenJPC_1Theme
import modelo.ComponenteDieta

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

    val context = LocalContext.current
    val bdFichero: BD_Fichero_Android=BD_Fichero_Android(context, "alimentos")

    var screen = remember { mutableStateOf(0) }
    var alimentos = remember { mutableStateListOf<ComponenteDieta>() }


    Column(modifier.padding(20.dp)){
        NavigationButton(screen)
        when (screen.value) {
                0 -> Inicio(bdFichero, alimentos)
                1 -> Formulario(alimentos)
                2 -> ListadoDetalle(alimentos)
        }
    }
}


@Preview(showBackground = true)
@Composable
fun Main() {

}