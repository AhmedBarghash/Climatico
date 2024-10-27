package com.vodafone.connectedliving.designsystem.component.topbar

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.vodafone.connectedliving.designsystem.DevicePreviews
import com.vodafone.connectedliving.designsystem.R
import com.vodafone.connectedliving.designsystem.component.text.SubTitleText
import com.vodafone.connectedliving.designsystem.icon.CLIcons

/**
 * it will be rendered in edit screen
 * 1- title centered
 * 2- X button as leading button with action to close the add screen
 * 3- trailing icon (delete) to confirm delete action
 * 4- selected item count showed as text example: (1)
 */
@OptIn(ExperimentalMaterial3Api::class)
@DevicePreviews
@Composable
fun DeleteTopAppBar(
    modifier: Modifier = Modifier,
    onBackAction: () -> Unit,
    onDeleteAction: () -> Unit,
    title: String,
    selectedCount: Int
) {
    TopAppBar(
        modifier = modifier,
        title = {
            SubTitleText(
                text = title,
                textAlign = TextAlign.Center,
                color = MaterialTheme.colorScheme.onBackground,
                modifier = Modifier.fillMaxWidth()
            )
        },
        navigationIcon = {
            IconButton(onClick = { onBackAction() }) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_close_thin_black),
                    contentDescription = "close",
                    tint = MaterialTheme.colorScheme.primary
                )
            }
        },
        actions = {
            TextButton(
                enabled = true,
                onClick = {},
            ) {
                Text(text = "(${selectedCount})")
            }
            IconButton(onClick = { onDeleteAction() }) {
                Icon(
                    painter = painterResource(id = CLIcons.Delete),
                    contentDescription = "delete",
                    tint = MaterialTheme.colorScheme.primary,
                    modifier = Modifier.size(32.dp, 32.dp)
                )
            }
        }
    )
}