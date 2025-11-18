package com.example.rm551268_rm98342

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.runtime.Composable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun MenuScreen(
    onGoToLogin: () -> Unit,
    onGoToImc: () -> Unit,
    onGoToEquipe: () -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        contentAlignment = Alignment.Center
    ) {
        Column(
            verticalArrangement = Arrangement.spacedBy(12.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "MENU", style = MaterialTheme.typography.headlineSmall)

            Button(
                onClick = onGoToImc,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Cálculo de IMC")
            }

            Button(
                onClick = onGoToEquipe,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Equipe")
            }

            Button(
                onClick = onGoToLogin,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Voltar para Login")
            }
        }
    }
}