# 🎮 SIMON DICE  

Este proyecto es una implementación del clásico juego "Simón Dice", en el cual el usuario debe repetir una secuencia de colores generada aleatoriamente. Se ha desarrollado siguiendo el patrón **MVVM** y utilizando **StateFlow** para una mejor reactividad en la interfaz de usuario.  

## 🚀 Comenzando  
  

## 📌 Índice de Contenidos  

- Estructura del código  
- Data Class  
- ViewModel  
- Interfaz de Usuario (UI)  
- MainActivity  

## 🛠 Estructura del código  

Se ha implementado el patrón de diseño **MVVM**, con una separación clara entre la lógica de negocio y la interfaz de usuario:  

✅ **Data Class**: Contiene los datos del juego y el estado de la aplicación.  
✅ **ViewModel**: Maneja la lógica del juego y la comunicación con la interfaz.  
✅ **UI (Jetpack Compose)**: Renderiza la interfaz de usuario, interactuando con el ViewModel.  
✅ **MainActivity**: Configura la aplicación y muestra la pantalla principal del juego.  

---

## 📂 Data Class  

La Data Class almacena y gestiona los datos esenciales del juego, como:  

- `round`: Número de ronda actual.  
- `sequence`: Secuencia generada aleatoriamente por el juego.  
- `userSequence`: Secuencia ingresada por el usuario.  
- `record`: Récord actual del jugador.  
- `state`: Estado del juego (`START`, `SEQUENCE`, `WAITING`, `CHECKING`, `FINISHED`).  
- `colors`: Lista de colores disponibles en el juego.  
- `numColors`: Enumeración de los colores utilizados en el juego.  

---

## 🎯 ViewModel (Lógica del juego)  

El ViewModel maneja la lógica del juego y la interacción entre la vista y los datos, implementando **StateFlow** para mejorar la reactividad.  

### 🔹 Principales funciones del ViewModel  

- **`startGame()`** → Reinicia la partida y genera una nueva secuencia.  
- **`changeState()`** → Controla el flujo del juego cambiando su estado.  
- **`generateSequence()`** → Genera y muestra la secuencia de colores de manera dinámica.  
- **`increaseSequence()`** → Agrega un nuevo color a la secuencia en cada ronda.  
- **`addUserInput()`** → Guarda la selección del usuario y verifica la secuencia.  
- **`checkSequence()`** → Comprueba si la secuencia ingresada por el usuario es correcta.  

### 🔹 Mejoras en el ViewModel  

✅ **Uso de `StateFlow`** para manejar los cambios de estado de forma reactiva.  
✅ **Manejo de corutinas** para gestionar la visualización de la secuencia y los tiempos de espera.  
✅ **Separación clara entre la lógica del juego y la interfaz de usuario.**  

---

## 🎨 Interfaz de Usuario (UI - Jetpack Compose)  

La UI del juego se compone de varios **@Composable** para estructurar y mostrar la información de manera eficiente.  

### 🖥 Composables principales  

- **`GameScreen(viewModel: VModel)`** → Composable principal que organiza la interfaz.  
- **`GameInfo(viewModel: VModel)`** → Muestra la ronda y el récord en tiempo real.  
- **`ButtonGrid(viewModel: VModel)`** → Renderiza los botones de colores.  
- **`GameButton(color, viewModel, name, index)`** → Representa cada botón de color con animaciones.  
- **`ControlButtons(viewModel: VModel)`** → Controles "START" y "ENVIAR".  

### 🔹 Mejoras en la UI  

✅ **Implementación de `collectAsState()`** para actualizar la interfaz en tiempo real.  
✅ **Cambio dinámico de color en los botones** usando `StateFlow`.  
✅ **Animaciones fluidas y diseño optimizado con Jetpack Compose.**  

---

## 📌 MainActivity (Punto de entrada)  

La **MainActivity** configura la aplicación y muestra la interfaz de usuario utilizando Jetpack Compose.  

- Se extiende de `ComponentActivity`.  
- Usa `setContent {}` para definir la estructura de la UI.  
- Inicia `GameScreen(viewModel = VModel())` como el Composable principal.  
- Aplica el tema `SimonDiceTheme` para el estilo visual.  

---

## ✨ Conclusión  

Esta versión del juego **Simón Dice** implementa el patrón **MVVM**, el **patrón de diseño Observer** con `StateFlow`, y **corutinas** para manejar tareas asíncronas.  
El código está optimizado para mejorar la fluidez, la reactividad y la experiencia del usuario.  

### 📌 Características clave  

✅ Arquitectura **MVVM** bien estructurada.  
✅ Uso eficiente de **StateFlow** y **corutinas**.  
✅ UI moderna con **Jetpack Compose**.  
✅ Implementación del patrón **Observer** para reactividad.  
✅ Experiencia de juego fluida e intuitiva.  

---

¡Listo para jugar y mejorar reflejos! 🚀🎮  
