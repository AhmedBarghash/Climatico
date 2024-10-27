package com.vodafone.connectedliving.designsystem.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.TextFieldColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardCapitalization
import com.vodafone.connectedliving.designsystem.icon.CLIcons
import com.vodafone.connectedliving.designsystem.theme.CLColors

@Composable
fun TextInputField(
    value: String,
    label: String,
    colours: TextFieldColors = OutlinedTextFieldDefaults.colors(
        focusedTextColor = MaterialTheme.colorScheme.primary,
        unfocusedTextColor = MaterialTheme.colorScheme.tertiary,
        focusedBorderColor = MaterialTheme.colorScheme.primary,
        unfocusedBorderColor = MaterialTheme.colorScheme.tertiary,
        focusedLabelColor = MaterialTheme.colorScheme.primary,
        unfocusedLabelColor = MaterialTheme.colorScheme.tertiary,
        disabledBorderColor = MaterialTheme.colorScheme.onPrimary,
        disabledContainerColor = MaterialTheme.colorScheme.error,
        disabledLabelColor = MaterialTheme.colorScheme.onPrimary,
        errorBorderColor = CLColors.VodafoneRed,
    ),
    onValueChange: (String) -> Unit,
    errorOrHint: String = "",
    error: Boolean = false,
    modifier: Modifier = Modifier.fillMaxWidth(),
    enabled: Boolean = true,
    readOnly: Boolean = false
) {
    val trailingIcon: @Composable () -> Unit = {TrailingIcon(resId = CLIcons.AlertTriangle, colourId = CLColors.VodafoneRed)}
    Column {
        OutlinedTextField(
            value = value,
            onValueChange = { onValueChange.invoke(it) },
            label = { LabelText(labelText = label) },
            modifier = modifier,
            colors = colours,
            trailingIcon = if (error) trailingIcon else null,
            enabled = enabled,
            readOnly = readOnly,
            keyboardOptions = KeyboardOptions.Default.copy(capitalization = KeyboardCapitalization.Sentences),
            isError = error
        )
        ErrorHintText(
            errorOrHintText = errorOrHint,
            colour = if (error) CLColors.VodafoneRed else MaterialTheme.colorScheme.primary
        )
    }
}