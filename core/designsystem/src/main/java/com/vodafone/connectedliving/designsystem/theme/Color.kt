package com.vodafone.connectedliving.designsystem.theme

import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.ui.graphics.Color

object CLColors {
    val Gray01 = Color(0xFFDDDDDD)
    val Gray02 = Color(0xFFEEEEEE)
    val Gray12 = Color(0xFF444444)
    val Gray13 = Color(0xFF333333)
    val Gray10 = Color(0xFF666666)
    val Gray11 = Color(0xFF555555)
    val Gray05 = Color(0xFFBBBBBB)
    val Gray03 = Color(0xFF999999)
    val VodafoneRed = Color(0xFFE60000)
    val White = Color(0xFFFFFFFF)
    val Green = Color(0xFF008A00)
    val LightGray = Color(0xFFF4F4F4)
    val VodafoneDarkRed = Color(0xFFA90000)

    val VodafoneLightRed = Color(0xFFFF0000)

    // HB - Colors
    val LightGreen = Color(0xFFE5F3E5)
    val StatusRedReverse = Color(0xFFF8E5E5)
    val StatusRed = Color(0xFFBD0000)
    val StatusOrange = Color(0xFFeb6100)
    val StatusOrangeReverse = Color(0xFFFDEFE5)

}


internal val LightColorScheme = lightColorScheme(
    primary = CLColors.Gray13, // text input selected
    secondary = CLColors.VodafoneRed,
    tertiary = CLColors.Gray10, // text input unselected
    background = CLColors.Gray02,
    onPrimary = CLColors.Gray05, // disabled colour - text/icons
    surface = CLColors.White,
    onSecondary = CLColors.Gray10,
    onBackground = CLColors.Gray13,
    error = CLColors.Gray02, // disabled colour - background
    onTertiary = CLColors.Gray10,
    onSurface = CLColors.White,
    surfaceVariant = CLColors.Gray05,
    onSurfaceVariant = CLColors.White, // add/edit background color
    onPrimaryContainer = CLColors.Gray01,
    tertiaryContainer = CLColors.Gray05, // toggle background
    onTertiaryContainer = CLColors.Gray02, // toggle text
)

internal val DarkColorScheme = darkColorScheme(
    primary = CLColors.White, // text input selected
    secondary = CLColors.White,
    tertiary = CLColors.Gray05,  // text input unselected
    background = CLColors.Gray13,
    onPrimary = CLColors.Gray05, // disabled colour - text/icons
    surface = CLColors.Gray12,
    onSecondary = CLColors.White,
    onBackground = CLColors.White,
    error = CLColors.Gray10, // disabled colour - background
    onTertiary = CLColors.Gray05,
    onSurface = CLColors.VodafoneRed,
    surfaceVariant = CLColors.Gray10,
    onSurfaceVariant = CLColors.Gray12, // add/edit background color
    onPrimaryContainer = CLColors.Gray12,
    tertiaryContainer = CLColors.Gray10, // toggle background
    onTertiaryContainer = CLColors.Gray12, // toggle text
)
