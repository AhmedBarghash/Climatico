package com.vodafone.connectedliving.designsystem.component

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
import com.vodafone.connectedliving.designsystem.icon.CLIcons

@Composable
fun DateInputField(
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
    dateClickedCallback: () -> Unit,
    clearDateClickedCallback: () -> Unit
) {
    Column (
        modifier = Modifier.fillMaxWidth()
    ) {
        val iconColour = if (enabled) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.onPrimary
        val trailingIconDisplay: @Composable () -> Unit = if (error) {
            { TrailingIcon(resId = CLIcons.AlertTriangle, colourId = iconColour) }
        } else if (value.isNotEmpty()) {
            { TrailingIcon(resId = CLIcons.Close, colourId = iconColour, modifier = Modifier.clickable { clearDateClickedCallback.invoke() }) }
        } else {
            { TrailingIcon(resId = CLIcons.CalendarPlaceholder, colourId = iconColour) }
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
                        dateClickedCallback.invoke()
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


//        Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
//            // Pre-select a date for January 4, 2020
//            val time = Calendar.getInstance().timeInMillis
//            val datePickerState = rememberDatePickerState(initialSelectedDateMillis = time /*1578096000000*/)
//            DatePicker(state = datePickerState, modifier = Modifier.padding(16.dp))
//
//            Text("Selected date timestamp: ${datePickerState.selectedDateMillis ?: "no selection"}")
//        }
    }
}