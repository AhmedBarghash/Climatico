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

/**
 * it will be rendered in edit screen
 * 1- title centered
 * 2- X button as leading button with action to close the add screen
 * 3- trailing icon ✔️ to confirm adding and start calling the API to add the item* 4- trash icon to delete item
 */
@OptIn(ExperimentalMaterial3Api::class)
@DevicePreviews
@Composable
fun CLEditFeatureTopAppBar(
    modifier: Modifier = Modifier,
    title: String = "Edit Routine",
    onBackClickedCallback: () -> Unit = {},
    onSaveClickedCallback: () -> Unit = {},
    onDeleteClickedCallback: () -> Unit = {},
) {
    TopAppBar(title = {
        SubTitleText(
            text = title,
            textAlign = TextAlign.Center,
            color = MaterialTheme.colorScheme.onBackground,
            modifier = Modifier.fillMaxWidth()
        )
    },
        navigationIcon = {
            IconButton(onClick = { onBackClickedCallback.invoke() }) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_close_thin_black),
                    contentDescription = "close",
                    tint = MaterialTheme.colorScheme.primary
                )
            }
        },
        actions = {
            IconButton(onClick = { onDeleteClickedCallback.invoke() }) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_delete),
                    contentDescription = "delete",
                    tint = MaterialTheme.colorScheme.primary
                )
            }
            IconButton(onClick = { onSaveClickedCallback.invoke() }) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_apply),
                    contentDescription = "apply",
                    tint = MaterialTheme.colorScheme.primary
                )
            }
        }
    )
}