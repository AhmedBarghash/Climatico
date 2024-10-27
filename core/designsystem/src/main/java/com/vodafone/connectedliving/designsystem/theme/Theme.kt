package com.vodafone.connectedliving.designsystem.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import com.vodafone.connectedliving.designsystem.utils.isTablet



@Composable
fun ConnectedLivingTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    /*
    * define theme color based on system in dark mode or not
    *
    * */
    val colorScheme = when {
        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }

    /*
    * define typography based on the device size ( tablet or phone )
    * */
    val typography = when (isTablet()) {
        true -> TabletTypography
        false -> PhoneTypography
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = typography,
        content = content
    )
}


