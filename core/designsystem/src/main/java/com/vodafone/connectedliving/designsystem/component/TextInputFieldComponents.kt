package com.vodafone.connectedliving.designsystem.component

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun ErrorHintText(errorOrHintText: String, colour: Color = MaterialTheme.colorScheme.primary) {
    Text(
        text = errorOrHintText,
        modifier = Modifier.padding(top = 8.dp),
        color = colour,
        style = MaterialTheme.typography.bodyMedium,
    )
}

@Composable
fun LabelText(labelText: String, colour: Color = MaterialTheme.colorScheme.primary) {
    Text(
        text = labelText,
        color = colour,
    )
}

@Composable
fun PlaceholderText(placeholderText: String) {
    Text(
        text = placeholderText,
        color = MaterialTheme.colorScheme.primary,
        style = MaterialTheme.typography.bodyLarge,
    )
}