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
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import com.vodafone.connectedliving.designsystem.R


@ExperimentalMaterial3Api
@Composable
fun PasswordField(
    value: String,
    label: String,
    colors: TextFieldColors,
    showPassword: Boolean = false,
    onValueChange: (String) -> Unit,
    errorOrHint: String = "",
    passwordMatchError: Boolean = false
) {
    Column {
        OutlinedTextField(
            value = value,
            singleLine = true,
            onValueChange = {
                onValueChange.invoke(it)
            },
            label = { WhiteText(label) },
            visualTransformation = if (showPassword)
                VisualTransformation.None else PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            modifier = Modifier.fillMaxWidth(),
            colors = colors,
            trailingIcon = if (passwordMatchError) trailingIcon else null
        )
        Text(
            text = errorOrHint,
            color = Color.White,
            modifier = Modifier.padding(top = 8.dp),
        )
    }
}

val trailingIcon: @Composable () -> Unit = {TrailingIcon(resId = R.drawable.ic_alert_triangle_outlined_white, colourId = Color.White)}