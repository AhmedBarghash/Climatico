package com.vodafone.connectedliving.designsystem.component

import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource

@Composable
fun TrailingIcon(resId: Int, colourId: Color, modifier: Modifier = Modifier) {
    Icon(
        painter = painterResource(id = resId),
        contentDescription = "",
        tint = colourId,
        modifier = modifier
    )
}