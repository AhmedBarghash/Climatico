package com.vodafone.connectedliving.designsystem.component

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.TextFieldColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.vodafone.connectedliving.designsystem.icon.CLIcons
import com.vodafone.connectedliving.designsystem.theme.ConnectedLivingTheme

@Composable
fun TimeInputField(
    value: String,
    label: String,
    colours: TextFieldColors = OutlinedTextFieldDefaults.colors(
        focusedTextColor = MaterialTheme.colorScheme.primary,
        unfocusedTextColor = MaterialTheme.colorScheme.tertiary,
        focusedLabelColor = MaterialTheme.colorScheme.primary,
        unfocusedLabelColor = MaterialTheme.colorScheme.tertiary,
        focusedBorderColor = MaterialTheme.colorScheme.primary,
        unfocusedBorderColor = MaterialTheme.colorScheme.tertiary,
        disabledBorderColor = MaterialTheme.colorScheme.onPrimary,
        disabledContainerColor = MaterialTheme.colorScheme.error,
        disabledLabelColor = MaterialTheme.colorScheme.onPrimary,
        disabledTrailingIconColor = MaterialTheme.colorScheme.onPrimary,
    ),
    errorOrHint: String = "",
    error: Boolean = false,
    enabled: Boolean = true,
    timeClickedCallback: () -> Unit,
    clearTimeClickedCallback: () -> Unit,
) {
    Column (
        modifier = Modifier.fillMaxWidth()
    ) {
        val iconColour = if (enabled) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.onPrimary
        val trailingIconDisplay: @Composable () -> Unit = if (error) {
            { TrailingIcon(resId = CLIcons.AlertTriangle, colourId = iconColour) }
        } else if (value.isNotEmpty()) {
            { TrailingIcon(resId = CLIcons.Close, colourId = iconColour, modifier = Modifier.clickable { clearTimeClickedCallback.invoke() }) }
        } else {
            { TrailingIcon(resId = CLIcons.TimePlaceholder, colourId = iconColour) }
        }
        OutlinedTextField(
            value = value,
            onValueChange = {},
            label = {
                LabelText(
                    labelText = label,
                    colour = if (!enabled) MaterialTheme.colorScheme.onPrimary else MaterialTheme.colorScheme.primary
                )
                    },
            modifier = Modifier
                .fillMaxWidth()
                .onFocusChanged {
                    if (it.hasFocus) {
                        timeClickedCallback.invoke()
                    }
                },
            colors = colours,
            trailingIcon = trailingIconDisplay,
            enabled = enabled,
            readOnly = true,
        )
        ErrorHintText(
            errorOrHintText = errorOrHint,
        )
    }
}

@Preview
@Composable
fun PreviewTimeInputField() {
    ConnectedLivingTheme {
        Column (
            Modifier.background(Color.White)
        ) {
            TimeInputField(value = "", label = "Time",
                timeClickedCallback = {},
                clearTimeClickedCallback = {},
            )
            TimeInputField(
                value = "",
                label = "Time",
                errorOrHint = "This field is required",
                error= true,
                timeClickedCallback = {},
                clearTimeClickedCallback = {},
            )
            TimeInputField(value = "", label = "Time", enabled = false,
                timeClickedCallback = {},
                clearTimeClickedCallback = {},
            )
            TimeInputField(value = "", label = "Time", enabled = true,
                timeClickedCallback = {},
                clearTimeClickedCallback = {},
            )
        }
    }
}