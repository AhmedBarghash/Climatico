package com.vodafone.connectedliving.designsystem.component.topbar

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import com.vodafone.connectedliving.designsystem.DevicePreviews
import com.vodafone.connectedliving.designsystem.R
import com.vodafone.connectedliving.designsystem.component.text.SubTitleText
import com.vodafone.connectedliving.designsystem.icon.CLIcons

/**
 * it will be rendered in edit screen
 * 1- title centered
 * 2- X button as leading button with action to close the add screen
 * 3- trailing icon + to navigate to add screen
 * 4- guide button
 */
@OptIn(ExperimentalMaterial3Api::class)
@DevicePreviews
@Composable
fun CLListFeatureTopAppBar(
    modifier: Modifier = Modifier,
    onBackAction: () -> Unit,
    onGuideAction: () -> Unit,
    onAddAction: () -> Unit,
    title: String,
    showAddIcon: Boolean
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
                    painter = painterResource(id = R.drawable.ic_back),
                    contentDescription = "close",
                    tint = MaterialTheme.colorScheme.primary
                )
            }
        },
        actions = {
            IconButton(onClick = { onGuideAction() }) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_guide),
                    contentDescription = "guide",
                    tint = MaterialTheme.colorScheme.primary
                )
            }
            if(showAddIcon) {
                IconButton(onClick = { onAddAction() }) {
                    Icon(
                        painter = painterResource(id = CLIcons.Add),
                        contentDescription = "add",
                        tint = MaterialTheme.colorScheme.primary
                    )
                }
            }
        }
    )
}