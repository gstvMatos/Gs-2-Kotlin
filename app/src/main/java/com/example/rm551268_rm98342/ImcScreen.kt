package com.example.rm551268_rm98342

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun ImcScreen(
    onBackToMenu: () -> Unit
) {
    var nome by remember { mutableStateOf("") }
    var peso by remember { mutableStateOf("") }
    var altura by remember { mutableStateOf("") }
    var resultado by remember { mutableStateOf("") }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        contentAlignment = Alignment.TopCenter
    ) {
        Column(
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            Text(text = "Calculadora IMC", style = MaterialTheme.typography.headlineSmall)

            OutlinedTextField(
                value = nome,
                onValueChange = { nome = it },
                label = { Text("Seu nome") },
                modifier = Modifier.fillMaxWidth()
            )

            OutlinedTextField(
                value = peso,
                onValueChange = { peso = it },
                label = { Text("Seu peso (kg)") },
                modifier = Modifier.fillMaxWidth()
            )

            OutlinedTextField(
                value = altura,
                onValueChange = { altura = it },
                label = { Text("Sua altura (m)") },
                modifier = Modifier.fillMaxWidth()
            )

            Row(
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Button(
                    onClick = {
                        val pesoNum = peso.replace(",", ".").toFloatOrNull()
                        val alturaNum = altura.replace(",", ".").toFloatOrNull()

                        if (pesoNum != null && alturaNum != null && alturaNum > 0f && nome.isNotBlank()) {
                            val imc = pesoNum / (alturaNum * alturaNum)
                            resultado = "$nome, seu IMC é %.2f".format(imc)
                        } else {
                            resultado = "Preencha nome, peso e altura."
                        }
                    }
                ) {
                    Text("Calcular")
                }

                Button(onClick = onBackToMenu) {
                    Text("Voltar")
                }
            }

            if (resultado.isNotEmpty()) {
                Text(text = resultado)
            }
        }
    }
}