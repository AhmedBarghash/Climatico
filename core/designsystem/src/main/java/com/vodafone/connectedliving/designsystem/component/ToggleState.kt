package com.vodafone.connectedliving.designsystem.component

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.vodafone.connectedliving.designsystem.theme.CLColors
import com.vodafone.connectedliving.designsystem.theme.ConnectedLivingTheme


@Composable
fun ToggleState(
    state: Boolean,
    trueText: String,
    falseText: String,
    toggleStateChangedCallback: () -> Unit,
) {
    ConnectedLivingTheme {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 8.dp)
                .requiredHeight(68.dp)
                .background(
                    color = MaterialTheme.colorScheme.onTertiaryContainer,
                    shape = RoundedCornerShape(6.dp)
                )
        ) {
            Row(
                modifier = Modifier
                    .align(Alignment.Center)
                    .fillMaxWidth()
                    .padding(4.dp)
            ) {
                if (state) {
                    DisplayTrueSelected(
                        trueText = trueText,
                        falseText = falseText,
                        unselectedClickedCallback = { toggleStateChangedCallback.invoke() },
                        modifier = Modifier.weight(1f)
                    )
                } else {
                    DisplayFalseSelected(
                        trueText = trueText,
                        falseText = falseText,
                        unselectedClickedCallback = { toggleStateChangedCallback.invoke() },
                        modifier = Modifier.weight(1f)
                    )
                }
            }
        }
    }
}

@Composable
fun DisplayTrueSelected(trueText: String, falseText: String, unselectedClickedCallback: () -> Unit, modifier: Modifier) {
    Box(
        modifier = modifier
    ) {
        DisplayUnselectedOption(
            optionString = falseText,
            unselectedClickedCallback = { unselectedClickedCallback.invoke() }
        )
    }
    Box(
        modifier = modifier
    ) {
        DisplaySelectedOption(
            optionString = trueText,
        )
    }
}
@Composable
fun DisplayFalseSelected(trueText: String, falseText: String, unselectedClickedCallback: () -> Unit, modifier: Modifier) {
    Box(
        modifier = modifier
    ) {
        DisplaySelectedOption(
            optionString = falseText,
        )
    }
    Box(
        modifier = modifier
    ) {
        DisplayUnselectedOption(
            optionString = trueText,
            unselectedClickedCallback = { unselectedClickedCallback.invoke() }
        )
    }
}

@Composable
fun DisplaySelectedOption(optionString: String) {
    Box(
        modifier = Modifier
            .background(color = CLColors.VodafoneRed, shape = RoundedCornerShape(6.dp))
            .fillMaxHeight(),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = optionString,
            color = CLColors.White,
            fontWeight = FontWeight.Bold,
            fontSize = MaterialTheme.typography.bodyLarge.fontSize,
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth()
        )
    }
}

@Composable
fun DisplayUnselectedOption(optionString: String, unselectedClickedCallback: () -> Unit) {
    Box(
        modifier = Modifier
            .background(color = MaterialTheme.colorScheme.onTertiaryContainer)
            .fillMaxHeight()
            .clickable { unselectedClickedCallback.invoke() },
        contentAlignment = Alignment.Center,
    ) {
        Text(
            text = optionString,
            color = MaterialTheme.colorScheme.tertiaryContainer,
            fontWeight = FontWeight.Bold,
            fontSize = MaterialTheme.typography.bodyLarge.fontSize,
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth()
        )
    }
}