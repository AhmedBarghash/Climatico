package com.vodafone.connectedliving.designsystem.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.vodafone.connectedliving.designsystem.DevicePreviews
import com.vodafone.connectedliving.localization.R
import com.vodafone.connectedliving.designsystem.icon.CLIcons
import com.vodafone.connectedliving.designsystem.theme.ConnectedLivingTheme
import com.vodafone.connectedliving.designsystem.utils.isTablet

@Composable
fun EmptyScreen(
    isEditable: Boolean,
    addNewButtonClicked: () -> Unit,
    showGuidesClicked: () -> Unit
) {
    ConnectedLivingTheme {
        val columMargin = if (isTablet()) 32.dp else 16.dp
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .padding(columMargin),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Image(
                painter = painterResource(id = CLIcons.EmptyScreen),
                contentDescription = null,
                modifier = Modifier
                    .width(160.dp)
                    .height(160.dp)
            )
            Spacer(modifier = Modifier.height(32.dp))
            Text(
                text = stringResource(id = R.string.empty_list_header_message),
                style = MaterialTheme.typography.titleLarge,
                color = MaterialTheme.colorScheme.onBackground
            )
            if (isEditable) {
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = stringResource(id = R.string.create_your_first_item_here),
                    color = MaterialTheme.colorScheme.onSecondary,
                    style = MaterialTheme.typography.titleMedium,
                    textAlign = TextAlign.Center
                )
                Spacer(modifier = Modifier.height(32.dp))
                val buttonHeight = if (isTablet()) 68.dp else 48.dp
                RedButton(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(buttonHeight),
                    text = stringResource(id = R.string.add_new),
                    onClick = { addNewButtonClicked() },
                    style = MaterialTheme.typography.titleMedium
                )
                Spacer(modifier = Modifier.height(32.dp))
                Row(
                    modifier = Modifier.clickable { showGuidesClicked() },
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    val imageSize = if (isTablet()) 24.dp else 18.dp
                    Image(
                        painter = painterResource(id = CLIcons.PlayOutline),
                        contentDescription = "",
                        modifier = Modifier
                            .width(imageSize)
                            .height(imageSize)
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(
                        text = stringResource(id = R.string.empty_screen_show_an_example),
                        color = MaterialTheme.colorScheme.secondary,
                        style = MaterialTheme.typography.bodyMedium
                    )
                }
            }
        }
    }
}

@DevicePreviews
@Composable
fun EmptyScreenPreview() {
    EmptyScreen(isEditable = true, {}, {})
}