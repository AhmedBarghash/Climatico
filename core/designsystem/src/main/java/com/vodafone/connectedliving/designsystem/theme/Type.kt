package com.vodafone.connectedliving.designsystem.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.vodafone.connectedliving.designsystem.R

val VodafoneFontFamily = FontFamily(
    fonts = listOf(
        Font(
            resId = R.font.vdf_bold,
            weight = FontWeight.Bold,
            style = FontStyle.Normal
        ),
        Font(
            resId = R.font.vdf_regular,
            weight = FontWeight.Normal,
            style = FontStyle.Normal
        ),
    )
)

val PhoneTypography = Typography(
    titleLarge = TextStyle(
        fontFamily = VodafoneFontFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 32.sp,
    ),
    // as subtitle
    titleMedium = TextStyle(
        fontFamily = VodafoneFontFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 24.sp,

        ),

    bodyLarge = TextStyle(
        fontFamily = VodafoneFontFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 20.sp,

        ),
    bodyMedium = TextStyle(
        fontFamily = VodafoneFontFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,

        ),
    bodySmall = TextStyle(
        fontFamily = VodafoneFontFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp,

        ),
)

val TabletTypography = Typography(
    titleLarge = TextStyle(
        fontFamily = VodafoneFontFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 48.sp,

        ),
    titleMedium = TextStyle(
        fontFamily = VodafoneFontFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 40.sp,

        ),
    bodyLarge = TextStyle(
        fontFamily = VodafoneFontFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 32.sp,

        ),
    bodyMedium = TextStyle(
        fontFamily = VodafoneFontFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 24.sp,

        ),
    bodySmall = TextStyle(
        fontFamily = VodafoneFontFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 20.sp,

        ),
)


