package com.vodafone.connectedliving.designsystem.component

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.vodafone.connectedliving.designsystem.DevicePreviews
import com.vodafone.connectedliving.designsystem.theme.CLColors
import com.vodafone.connectedliving.localization.R

@Composable
fun WhiteButton(
    modifier: Modifier = Modifier,
    text: String,
    isEnabled: Boolean = true,
    onClick: () -> Unit,
    style: TextStyle,
) {
    Button(
        modifier = modifier,
        onClick = onClick,
        enabled = isEnabled,
        border = BorderStroke(width = 2.dp, color = MaterialTheme.colorScheme.primary),
        colors = ButtonDefaults.outlinedButtonColors(
            containerColor = MaterialTheme.colorScheme.onSurfaceVariant,
            contentColor = MaterialTheme.colorScheme.primary,
        ),
        shape = RoundedCornerShape(8.dp),
    ) {
        Text(
            text = text,
            style = style,
            color = MaterialTheme.colorScheme.primary,
            fontWeight = FontWeight.Bold,
        )
    }
}

@DevicePreviews
@Composable
fun WhiteButtonPreviews() {
    WhiteButton(
        Modifier,
        stringResource(id = R.string.no_cancel),
        true,
        {},
        style = MaterialTheme.typography.bodyLarge,
    )
}
