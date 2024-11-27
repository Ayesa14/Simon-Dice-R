package src.main.java.com.ayesa.simondice2

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ayesa.simondice2.Data
import com.ayesa.simondice2.VModel


/**
 * Composable principal que muestra la pantalla de saludo del juego.
 * Muestra información como la ronda actual, el récord, la botonera de colores y botones de inicio y envío.
 *
 * @param miModel La instancia del modelo VModel asociado a la pantalla de saludo.
 */
@Composable
fun Greeting(miModel: VModel) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(16.dp)) // Añadir espacio superior
        Row {
            Ronda() // Mostrar el componente Ronda aquí
            Spacer(modifier = Modifier.width(16.dp)) // Espacio entre componentes
            Record() // Mostrar el componente Record aquí

        }

        Botonera(vModel = miModel)
        Spacer(modifier = Modifier.height(16.dp)) // Añadir espacio entre la Botonera y los botones
        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {
            StartButton(miModel = miModel)
            Spacer(modifier = Modifier.width(16.dp)) // Espacio entre botones
            Enviar(miModel = miModel)
        }
    }



}
