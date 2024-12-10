package com.example.alertdialog

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.alertdialog.ui.theme.AlertDialogTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AlertDialogTheme {
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

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    var showDialog by remember { mutableStateOf(false) }
    var selectedButton by remember { mutableStateOf(0) }
    var texto by remember { mutableStateOf("Jesús Martín") } 

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Row {
                Text(texto)
            }
            Row {
                Button(onClick = { selectedButton = 1; showDialog = true }) {
                    Text("Botón 1")
                }
            }
            Row {
                Button(onClick = { selectedButton = 2; showDialog = true }) {
                    Text("Botón 2")
                }
            }
            Row {
                Button(onClick = { selectedButton = 3; showDialog = true }) {
                    Text("Botón 3")
                }
            }
            Row {
                Button(onClick = { selectedButton = 4; showDialog = true }) {
                    Text("Botón 4")
                }
            }
            Row {
                Button(onClick = { selectedButton = 5; showDialog = true }) {
                    Text("Botón 5")
                }
            }
        }

        if (showDialog) {

            AlertDialog(
                onDismissRequest = { showDialog = false },
                title = {
                    Text(
                        text = when (selectedButton) {
                            1 -> "Confirmación de Acción"
                            2 -> "Eliminar Elemento"
                            3 -> "Aviso Importante"
                            4 -> "Requiere Autenticación"
                            5 -> "Error Crítico"
                            else -> {"ERROR"}
                        }
                    )
                },
                text = {
                    Text(
                        text = when (selectedButton) {
                            1 -> "¿Estás seguro de que deseas continuar con esta acción?"
                            2 -> "Esta acción es irreversible. ¿Deseas eliminar este elemento?"
                            3 -> "Recuerda que los cambios realizados no se pueden deshacer"
                            4 -> "Para continuar, necesitas autenticarte de nuevo."
                            5 -> "Se ha producido un error crítico. ¿Deseas intentar nuevamente?"
                            else -> {"ERROR"}
                        }
                    )
                },

                confirmButton = {
                    TextButton(
                        onClick = {
                            showDialog = false
                            texto = when (selectedButton) {
                                1 -> "Confirmada"
                                2 -> "Eliminado Correctamente"
                                4 -> "Usuario Autenticado"
                                5 -> "Intento de Reintento"
                                else -> if(selectedButton == 3) texto else "ERROR"
                            }
                        }
                    ) {
                        Text(
                            text = when (selectedButton) {
                                1 -> "Si"
                                2 -> "Eliminar"
                                3 -> "Entendido"
                                4 -> "Autenticar"
                                5 -> "Reintentar"
                                else -> {"ERROR"}
                            }
                        )
                    }
                },
                dismissButton = {
                    TextButton(onClick = { showDialog = false }) {
                        Text(
                            text = when (selectedButton) {
                                1 -> "No"
                                2 -> "Cancelar"
                                3 -> ""
                                4 -> "Cancelar"
                                5 -> "Cancelar"
                                else -> {"ERROR"}
                            }
                        )
                    }
                }
            )
        }
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    AlertDialogTheme {
        Greeting("Android")
    }
}
