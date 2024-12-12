package com.example.probando_jpc_mvvm

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBars
import androidx.compose.material3.Button
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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.probando_jpc_mvvm.model.NumeroModelView
import com.example.probando_jpc_mvvm.ui.theme.Probando_JPC_MVVMTheme

class MainActivity : ComponentActivity() {

    val viewModel:NumeroModelView by viewModels()

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
                    Column(){
                        SinModelView(
                            name = "Android",
                            modifier = Modifier.padding(innerPadding)
                        )
                        ConModelView()
                        ConModelViewLiveData()
                    }

                }
            }
        }
    }

@Composable
fun SinModelView(name: String, modifier: Modifier = Modifier) {

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


}














