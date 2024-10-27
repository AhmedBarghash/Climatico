package com.vodafone.connectedliving.designsystem.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.vodafone.connectedliving.designsystem.icon.validationIcon

@Composable
fun PasswordValidationScheme(
    modifier: Modifier = Modifier,
    validationSchemeMap: Map<Int, ValidationItem>
) {
    Column(modifier) {
        validationSchemeMap.forEach { (index, item) ->
            ValidationRow(title = item.title, isValid = item.isValid)
            Spacer(modifier = Modifier.padding(4.dp))
        }
    }
}

@Composable
@Preview(showBackground = true)
fun PreviewValidationRow() {
    ValidationRow(title = "test item validation", isValid =  true)
}

@Composable
fun ValidationRow(
    modifier: Modifier = Modifier,
    title: String,
    isValid: Boolean,
) {
    Row(modifier = modifier) {
        ValidationIcon(modifier = Modifier.align(Alignment.CenterVertically), isValid = isValid)
        Spacer(modifier = Modifier.padding(4.dp))
        WhiteText(modifier = Modifier.align(Alignment.CenterVertically),text = title)
    }

}

@Composable
fun ValidationIcon(
    modifier: Modifier = Modifier,
    isValid: Boolean
) {

    Image(
        painter = painterResource(
            when (isValid) {
                true -> validationIcon.validIcon
                false -> validationIcon.errorIcon
            }
        ),
        contentDescription = "validation_icon",
        modifier = modifier.size(20.dp)
    )

}


data class ValidationItem(
    val title: String,
    val isValid: Boolean
)