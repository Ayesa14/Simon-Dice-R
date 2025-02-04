package com.ayesa.simondice2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.material3.Surface
import src.main.java.com.ayesa.simondice2.ui.theme.SimonDiceTheme

class MainActivity : ComponentActivity() {
    private val viewModel: VModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SimonDiceTheme {
                Surface {
                    GameScreen(viewModel)
                }

            }
        }
    }
}