package com.vodafone.connectedliving.designsystem.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun PasswordCheckBox(
    text: String,
    isChecked: Boolean,
    onCheckChange: (Boolean) -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier.clickable {
            onCheckChange.invoke(!isChecked)
        },
    ) {
        Checkbox(
            checked = isChecked,
            onCheckedChange = {
                onCheckChange.invoke(!isChecked)
            },
            colors = CheckboxDefaults.colors(
                checkedColor = Color.White,
                checkmarkColor = Color.Red,
                uncheckedColor = Color.White,
            ),
        )
        Text(
            text = text,
            color = Color.White,
            modifier = Modifier.padding(start = 8.dp),
        )
    }
}