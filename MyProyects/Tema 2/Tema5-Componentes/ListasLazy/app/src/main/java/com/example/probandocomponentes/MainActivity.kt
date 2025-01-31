package com.example.probandocomponentes

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.probandocomponentes.ui.theme.ProbandoComponentesTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ProbandoComponentesTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}
//Le ponemos @Composable a una función cuando esa función está destinada a crear y manejar elementos
// que se van a mostrar en la interfaz de usuario. Esto incluye texto, botones, listas, imágenes, y cualquier otro componente visual
@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    MyRecyclerView()

}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ProbandoComponentesTheme {
        Greeting("Android")
    }
}