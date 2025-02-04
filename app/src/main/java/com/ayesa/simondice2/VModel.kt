package com.ayesa.simondice2

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlin.random.Random

class VModel : ViewModel() {

    private val _gameState = MutableStateFlow(Data.state.value)
    val gameState: StateFlow<Data.State> = _gameState

    private val _round = MutableStateFlow(Data.round.value)
    val round: StateFlow<Int> = _round

    private val _record = MutableStateFlow(Data.record.value)
    val record: StateFlow<Int> = _record

    private val _sequence = MutableStateFlow<List<Int>>(emptyList())
    val sequence: StateFlow<List<Int>> = _sequence

    private val _userInput = MutableStateFlow<List<Int>>(emptyList())
    val userInput: StateFlow<List<Int>> = _userInput

    private val _activeButton = MutableStateFlow<Int?>(null)
    val activeButton: StateFlow<Int?> = _activeButton  // Índice del botón que debe resaltarse


    /**
     * Inicia el juego cambiando el estado a SEQUENCE y generando la secuencia inicial.
     */
    fun startGame() {
        viewModelScope.launch {
            _round.value = 1
            _record.value = Data.record.value
            _sequence.value = emptyList()
            _userInput.value = emptyList()
            _gameState.value = Data.State.SEQUENCE
            generateSequence()
        }
    }

    /**
     * Genera una nueva secuencia agregando un color aleatorio.
     */
    fun generateSequence() {
        viewModelScope.launch {
            val newSequence = _sequence.value.toMutableList().apply {
                add(Random.nextInt(Data.colors.size)) // Agrega un nuevo color aleatorio
            }
            _sequence.value = newSequence
            Data.updateState(Data.State.SHOW_SEQUENCE)
            _gameState.value = Data.State.SHOW_SEQUENCE

            // Simulación de mostrar la secuencia con retraso
            for (colorIndex in newSequence) {
                highlightButton(colorIndex)
                delay(800) // Simula el tiempo de resaltado
                resetButton()
                delay(200) // Pequeño retraso entre colores
            }

            Data.updateState(Data.State.WAITING)
            _gameState.value = Data.State.WAITING
        }
    }

    /**
     * Agrega el input del usuario y comprueba si la secuencia es correcta.
     */
    fun addUserInput(colorIndex: Int) {
        if (_gameState.value == Data.State.WAITING) {
            viewModelScope.launch {
                highlightButton(colorIndex)
                delay(300) // Simula el efecto de pulsación
                resetButton()

                val newUserInput = _userInput.value.toMutableList().apply {
                    add(colorIndex)
                }
                _userInput.value = newUserInput

                if (newUserInput.size == _sequence.value.size) {
                    validateSequence()
                }
            }
        }
    }

    /**
     * Valida si la secuencia ingresada por el usuario es correcta.
     */
    private fun validateSequence() {
        viewModelScope.launch {
            if (_userInput.value == _sequence.value) {
                increaseRound()
                generateSequence()
            } else {
                endGame()
            }
        }
    }

    /**
     * Aumenta la ronda y actualiza el estado.
     */
    private fun increaseRound() {
        viewModelScope.launch {
            _round.value++
            if (_round.value > _record.value) {
                _record.value = _round.value
                Data.updateRecord(_record.value)
            }
        }
    }

    /**
     * Termina el juego y actualiza el estado.
     */
    private fun endGame() {
        viewModelScope.launch {
            Data.updateState(Data.State.FINISHED)
            _gameState.value = Data.State.FINISHED
        }
    }

    /**
     * Simula el resaltado de un botón en la UI.
     */
    private fun highlightButton(colorIndex: Int) {
        _activeButton.value = colorIndex
    }

    /**
     * Resetea el botón después de resaltarlo.
     */
    private fun resetButton() {
        _activeButton.value = null
    }
}