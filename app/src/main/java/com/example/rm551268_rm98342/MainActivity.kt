package com.example.rm551268_rm98342

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.tooling.preview.Preview

enum class Screen {
        LOGIN,
        MENU,
        IMC,
        EQUIPE
    }

    class MainActivity : ComponentActivity() {
        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContent {
                App()
            }
        }
    }

    @Composable
    fun App() {
        MaterialTheme {
            var currentScreen by remember { mutableStateOf(Screen.LOGIN) }

            when (currentScreen) {
                Screen.LOGIN -> LoginScreen(
                    onLoginSuccess = { currentScreen = Screen.MENU }
                )
                Screen.MENU -> MenuScreen(
                    onGoToLogin = { currentScreen = Screen.LOGIN },
                    onGoToImc = { currentScreen = Screen.IMC },
                    onGoToEquipe = { currentScreen = Screen.EQUIPE }
                )
                Screen.IMC -> ImcScreen(
                    onBackToMenu = { currentScreen = Screen.MENU }
                )
                Screen.EQUIPE -> EquipeScreen(
                    onBackToMenu = { currentScreen = Screen.MENU }
                )
            }
        }
    }

    @Preview(showBackground = true)
    @Composable
    fun AppPreview() {
        App()
    }