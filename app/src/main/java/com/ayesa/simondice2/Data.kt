package com.ayesa.simondice2

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.graphics.Color
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
/**
 * Clase que almacena los datos globales del juego Simon Dice.
 * Utiliza un enfoque basado en estado mutable para la reactividad en la UI.
 */
object Data {
    private val _round = MutableStateFlow(0)
    val round: StateFlow<Int> = _round

    private val _sequence = MutableStateFlow<List<Int>>(emptyList())
    val sequence: StateFlow<List<Int>> = _sequence

    private val _userSequence = MutableStateFlow<List<Int>>(emptyList())
    val userSequence: StateFlow<List<Int>> = _userSequence

    private val _record = MutableStateFlow(0)
    val record: StateFlow<Int> = _record

    private val _state = MutableStateFlow(State.START)
    val state: StateFlow<State> = _state

    val colors = listOf(
        Colors.ROJO.color,
        Colors.AZUL.color,
        Colors.AMARILLO.color,
        Colors.VERDE.color
    )

    var numColors = Colors.values()
    var colorPath: Color = Color.White

    fun updateRound(value: Int) {
        _round.value = value
    }

    fun updateSequence(newSequence: List<Int>) {
        _sequence.value = newSequence
    }

    fun updateUserSequence(newSequence: List<Int>) {
        _userSequence.value = newSequence
    }

    fun updateRecord(value: Int) {
        _record.value = value
    }

    fun updateState(newState: State) {
        _state.value = newState
    }
    fun increaseRound() {
        _round.value++
    }

    /**
     * Enumeración que representa los distintos estados del juego.
     * Los estados incluyen START, SEQUENCE, WAITING, CHECKING y FINISHED.
     */
    enum class State {
        START, // Estado inicial del juego
        SEQUENCE, // Mostrando la secuencia de colores
        WAITING, // Esperando la interacción del usuario
        CHECKING, // Comprobando la secuencia del usuario
        FINISHED, // Juego finalizado
        SHOW_SEQUENCE
    }


    /**
     * Enumeración que representa los colores del juego Simon.
     * Cada color tiene asociado un estado mutable y un nombre.
     *
     * @property color El estado mutable del color.
     * @property colorName El nombre del color.
     */
    enum class Colors(val color: MutableState<Color>, val colorName: String) {
        ROJO(mutableStateOf(Color.Red), "ROJO"),
        AZUL(mutableStateOf(Color.Blue), "AZUL"),
        AMARILLO(mutableStateOf(Color.Yellow), "AMARILLO"),
        VERDE(mutableStateOf(Color.Green), "VERDE"),

    }


}

