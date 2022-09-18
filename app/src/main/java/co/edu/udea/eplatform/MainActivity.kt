package co.edu.udea.eplatform

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import co.edu.udea.eplatform.navigation.AppNavigation
import co.edu.udea.eplatform.ui.theme.EplatformTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            EplatformTheme {
                AppNavigation()
            }
        }
    }
}