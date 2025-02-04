package com.ayesa.simondice2

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

/**
 * Representa la pantalla principal del juego Simon Dice.
 * Muestra la información de la partida, los botones de colores y los controles de inicio y envío.
 *
 * @param viewModel La instancia del ViewModel que maneja la lógica del juego.
 */
@Composable
fun GameScreen(viewModel: VModel) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(16.dp))
        GameInfo(viewModel)
        Spacer(modifier = Modifier.height(16.dp))
        ButtonGrid(viewModel)
        Spacer(modifier = Modifier.height(16.dp))
        ControlButtons(viewModel)
    }
}

/**
 * Muestra la información de la ronda y el récord del juego.
 */
@Composable
fun GameInfo(viewModel: VModel) {
    val round by viewModel.round.collectAsState()
    val record by viewModel.record.collectAsState()

    Row {
        GameText("RONDA: $round")
        Spacer(modifier = Modifier.width(16.dp))
        GameText("RÉCORD: $record")
    }
}

@Composable
fun GameText(text: String) {
    Text(
        text = text,
        color = Color.Black,
        fontWeight = FontWeight.ExtraBold,
        fontSize = 20.sp
    )
}

/**
 * Crea una cuadrícula de botones de colores.
 */
@Composable
fun ButtonGrid(viewModel: VModel) {
    val colorsInTwoRows = Data.Colors.values().toList().chunked(2)

    Column(
        modifier = Modifier.padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        colorsInTwoRows.forEachIndexed { rowIndex, rowColors ->
            Row {
                rowColors.forEachIndexed { colIndex, color ->
                    val buttonIndex = (rowIndex * 2) + colIndex
                    Spacer(modifier = Modifier.width(8.dp))
                    GameButton(color.color, viewModel, color.colorName, buttonIndex)
                }
            }
            Spacer(modifier = Modifier.height(8.dp))
        }
    }
}

/**
 * Crea un botón de color que cambia dinámicamente cuando se resalta.
 */
@Composable
fun GameButton(color: MutableState<Color>, viewModel: VModel, name: String, index: Int) {
    val activeButton by viewModel.activeButton.collectAsState()

    val buttonColor = if (activeButton == index) Color.White else color.value

    Button(
        onClick = {
            viewModel.addUserInput(index)
        },
        modifier = Modifier
            .padding(10.dp)
            .size(150.dp),
        shape = androidx.compose.foundation.shape.RoundedCornerShape(20.dp),
        colors = ButtonDefaults.buttonColors(buttonColor)
    ) {
        Text(
            text = name,
            color = Color.Black,
            fontWeight = FontWeight.ExtraBold,
            fontSize = 20.sp
        )
    }
}

/**
 * Muestra los botones de control "START" y "ENVIAR".
 */
@Composable
fun ControlButtons(viewModel: VModel) {
    Row(
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.fillMaxWidth()
    ) {
        ControlButton("START") {
            viewModel.startGame()
        }
        Spacer(modifier = Modifier.width(16.dp))
        ControlButton("ENVIAR") {
            viewModel.addUserInput(-1) // -1 indica que se finaliza la entrada del usuario
        }
    }
}

/**
 * Crea un botón de control con texto personalizado.
 */
@Composable
fun ControlButton(text: String, onClick: () -> Unit) {
    Button(onClick = onClick) {
        Text(
            text = text,
            color = Color.Black,
            fontWeight = FontWeight.ExtraBold,
            fontSize = 20.sp
        )
    }
}
