package com.vodafone.connectedliving.designsystem.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp


@ExperimentalMaterial3Api
@Composable
fun EmailField(
    value: String,
    label: String,
    colors: TextFieldColors,
    onValueChange: (String) -> Unit,
    errorOrHint: String = "",
) {
    Column {
        OutlinedTextField(
            value = value,
            singleLine = true,
            onValueChange = { onValueChange.invoke(it) },
            label = {
                WhiteText(text = label)
            },
            modifier = Modifier.fillMaxWidth(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
            colors = colors,
        )
        Text(
            text = errorOrHint,
            color = Color.White,
            modifier = Modifier.padding(top = 8.dp),
        )
    }
}

