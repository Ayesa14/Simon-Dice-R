# SIMON DICE
En este proyecto vamos a realizar un juego de Simón Dice que consistirá en tener 4 botones de colores que se iluminarán de forma aleatoria y el usuario tendrá que repetir la secuencia.

## Comenzando
Para ejecutar el proyecto, es necesario comprender la lógica del juego de Simón Dice. Para ello, vamos a estructurar el código de la siguiente manera:
## Índice de Contenidos

1. [Estructura del código](#estructura-del-código)
2. [Data Class](#data-class)
3. [ViewModel](#viewmodel)
4. [Interfaz de Usuario (UI)](#interfaz-de-usuario-ui)
5. [MainActivity](#mainactivity)

### Estructura del código
Vamos a emplear el patrón de diseño MVVM, donde tendremos:
- Una `data class` que contendrá los datos de los botones y el estado del juego.
- Un `ViewModel` que contendrá la lógica del juego.
- Una `Activity` que contendrá la vista del juego.

### Data Class
En la data class, almacenamos los datos esenciales del juego:
- `round`: el número de ronda actual.
- `sequence`: la secuencia generada aleatoriamente por el juego.
- `sequenceUser`: la secuencia ingresada por el usuario.
- `record`: el récord actual del jugador.
- `state`: el estado del juego (START, SEQUENCE, WAITING, CHECKING o FINISHED).
- `colors`: una lista de colores disponibles en el juego.
- `numColors`: una enumeración de los colores definidos en el juego.
- `colorPath`: el color actual utilizado en el juego.

### ViewModel

El `ViewModel` es responsable de manejar la lógica del juego y la interacción entre la vista y los datos. Contiene métodos esenciales para iniciar un juego nuevo, cambiar el estado del juego, generar la secuencia de colores, manejar la interacción con los botones y verificar la secuencia ingresada por el usuario.

Este ViewModel contiene los siguientes métodos principales:

- `startGame()`: Inicia un nuevo juego reiniciando los valores del juego a su estado inicial.
- `changeState()`: Cambia el estado de la aplicación al siguiente estado en el ciclo del juego.
- `generarSecuencia()`: Genera una secuencia aleatoria de colores en el juego de Simon, mostrando secuencialmente los colores almacenados en la secuencia.
- `aumentarSecuencia()`: Aumenta la secuencia de colores en el juego de Simon si el estado actual lo permite.
- `guardarSecuenciaUsuario()`: Guarda el color seleccionado por el usuario en la secuencia del jugador.
- `comprobarSecuencia()`: Comprueba si la secuencia del jugador coincide con la secuencia generada por el juego.

Este ViewModel hace uso de coroutines para controlar los tiempos de espera entre acciones, así como también se encarga de manejar el estado del juego y los colores de los botones de manera adecuada.

Es importante ajustar y adaptar estas funcionalidades según las necesidades específicas de tu aplicación, así como también implementar la lógica de interacción con la vista para crear una experiencia de juego óptima.

### Interfaz de Usuario (UI)

El archivo UI (`composable`) proporciona la interfaz de usuario del juego de Simón Dice. Este archivo contiene componibles (funciones `@Composable`) que definen la estructura y la apariencia visual del juego.

#### Composables Principales

- **Greeting**: Es el `Composable` principal que muestra la pantalla de saludo del juego. Presenta la información de la ronda actual, el récord, la botonera de colores y botones de inicio y envío.

- **Record**: Muestra el récord actual del juego utilizando el valor almacenado en `Data.record`.

- **Ronda**: Muestra el número de la ronda actual del juego utilizando el valor almacenado en `Data.round`.

- **Botonera**: Organiza los botones de colores en filas y columnas utilizando el modelo `VModel`.

- **Boton**: Define un botón personalizado con un color, un modelo (`VModel`) y un nombre dados. Este botón está asociado con la lógica del juego.

- **StartButton**: Muestra un botón de inicio para comenzar el juego. Al presionar este botón, se inicia el juego y se genera la secuencia inicial.

- **Enviar**: Muestra un botón para enviar una secuencia en el juego. Este botón verifica la secuencia del jugador y realiza acciones dependiendo del estado del juego.

Estos composables se encargan de mostrar la información relevante, los botones de colores y los controles necesarios para jugar, interactuando con el `VModel` para manejar la lógica del juego y los estados de la aplicación.

### MainActivity

La `MainActivity` es la entrada principal de la aplicación. En ella, se establece el tema visual y se define la estructura de la interfaz de usuario a través de los componibles de Jetpack Compose.

En este caso, la `MainActivity`:

- Extiende de `ComponentActivity`, una clase proporcionada por Android Jetpack que permite interactuar con el ciclo de vida de una actividad en Android.

- En el método `onCreate()`, se establece el contenido de la actividad utilizando `setContent`. Dentro de este método se utiliza el tema `SimonDiceTheme` y se coloca un `Surface` que contiene el `Composable` principal llamado `Greeting`, pasándole una instancia del modelo `VModel()`.

- `SimonDiceTheme` proporciona el tema visual global de la aplicación, definiendo la apariencia y estilos que se aplican a los elementos de la interfaz de usuario.

- `Surface` es un contenedor visual que muestra el contenido definido por el `Composable` `Greeting`, el cual representa la pantalla principal del juego de Simón Dice.

Esta clase es esencial para la configuración inicial de la aplicación y la presentación de la interfaz de usuario basada en los componibles de Jetpack Compose.


