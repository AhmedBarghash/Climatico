package com.developerx.climatico

//AIzaSyBu3D7uxNnCkrSM0BJFXpq-duHsTWut96I

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Surface
import com.developerx.climatico.ui.theme.ClimaticoTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ClimaticoTheme {
                Surface {
                    MainScreenContent()
                }
            }
        }
    }
}
