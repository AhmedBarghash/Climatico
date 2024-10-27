package com.vodafone.connectedliving.designsystem.component

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

@Composable
fun WhiteText(
    text: String,
    modifier: Modifier = Modifier,
) {
    Text(text, color = Color.White, modifier = modifier)
}
