package src.main.java.com.ayesa.simondice2

import Greeting
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Surface
import com.ayesa.simondice2.ui.theme.SimonDiceTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SimonDiceTheme {
                // A surface container using the 'background' color from the theme
                Surface {
                    Greeting(miModel = VModel())
                }

            }
        }
    }
}