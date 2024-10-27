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
 * 1- back button as leading button with action to navigate up to previous screen
 * 3- trailing icon ✐ to edit screen* 4- trash icon to delete the item
 */
@OptIn(ExperimentalMaterial3Api::class)
@DevicePreviews
@Composable
fun CLFeatureDetailsTopAppBar(
    modifier: Modifier = Modifier,
    editable: Boolean = true,
    onBackClickedCallback: () -> Unit = {},
    onDeleteClickedCallback: () -> Unit = {},
    onEditClickedCallback: () -> Unit = {},
    title: String = "Shopping Item"
) {
    TopAppBar(
        title = {
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
                    painter = painterResource(id = R.drawable.ic_back),
                    contentDescription = "back",
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
            if (editable) {
                IconButton(onClick = { onEditClickedCallback.invoke() }) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_edit),
                        contentDescription = "back",
                        tint = MaterialTheme.colorScheme.primary
                    )
                }
            }
        }
    )
}