package com.vodafone.connectedliving.designsystem.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.DialogProperties
import com.vodafone.connectedliving.designsystem.DevicePreviews
import com.vodafone.connectedliving.designsystem.DevicePreviewsWithSystemUI
import com.vodafone.connectedliving.designsystem.icon.CLIcons
import com.vodafone.connectedliving.designsystem.theme.ConnectedLivingTheme
import com.vodafone.connectedliving.designsystem.utils.isTablet
import com.vodafone.connectedliving.localization.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DisplayAlertDialog(
    onCancelClickedCallback: () -> Unit,
    onDeleteClickedCallback: () -> Unit,
    itemType: String,
) {
    AlertDialog(
        onDismissRequest = { onCancelClickedCallback.invoke() },
        properties = DialogProperties(
            usePlatformDefaultWidth = false,
        ),
        modifier = Modifier.fillMaxWidth(), /*.padding(16.dp)*/
    ) {
        DisplayDeleteAlertBody(
            onCancelClickedCallback = { onCancelClickedCallback.invoke() },
            onDeleteClickedCallback = {
                onDeleteClickedCallback.invoke()
            },
            itemType = itemType,
        )
    }
}

@Composable
fun DisplayDeleteAlertBody(
    onCancelClickedCallback: () -> Unit,
    onDeleteClickedCallback: () -> Unit,
    itemType: String,
) {
    var modifierPadding = if (isTablet()) {
        Modifier.padding(start = 24.dp, end = 24.dp)
    } else {
        Modifier.padding(start = 16.dp, end = 16.dp)
    }
    ConnectedLivingTheme {
        Box(
            modifier = modifierPadding
                .fillMaxWidth()
                .background(
                    MaterialTheme.colorScheme.onSurfaceVariant,
                    shape = RoundedCornerShape(6.dp),
                ),
        ) {
            Column(
                modifier = Modifier
                    .padding(24.dp)
                    .fillMaxWidth(),
            ) {
                DisplayDeleteAlertTitle()
                Spacer(modifier = Modifier.height(8.dp))
                DisplayDeleteAlertSubtext(itemType = itemType)
                Spacer(modifier = Modifier.height(16.dp))
                DisplayDeleteAlertButtons(
                    onCancelClickedCallback = { onCancelClickedCallback.invoke() },
                    onDeleteClickedCallback = { onDeleteClickedCallback.invoke() },
                )
            }
        }
    }
}

@Composable
fun DisplayDeleteAlertTitle() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 24.dp, end = 24.dp, top = 16.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Icon(
            painterResource(id = CLIcons.AlertTriangle),
            modifier = Modifier.size(32.dp),
            contentDescription = null,
            tint = MaterialTheme.colorScheme.primary,
        )
        Spacer(modifier = Modifier.width(8.dp))
        Text(
            text = stringResource(id = R.string.delete_forever),
            color = MaterialTheme.colorScheme.primary,
            fontSize = MaterialTheme.typography.titleMedium.fontSize,
        )
    }
}

@Composable
fun DisplayDeleteAlertSubtext(itemType: String) {
    Text(
        text = stringResource(id = R.string.delete_selected_items, itemType),
        color = MaterialTheme.colorScheme.primary,
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 24.dp, end = 24.dp),
        fontSize = MaterialTheme.typography.bodyLarge.fontSize,
    )
}

@Composable
fun DisplayDeleteAlertButtons(
    onCancelClickedCallback: () -> Unit,
    onDeleteClickedCallback: () -> Unit,
) {
    var modifier = if (isTablet()) {
        Modifier.height(72.dp)
    } else {
        Modifier.height(52.dp)
    }
    Row(
        modifier = Modifier.padding(start = 24.dp, end = 24.dp, bottom = 24.dp),
    ) {
        WhiteButton(
            text = stringResource(id = R.string.no_cancel),
            onClick = { onCancelClickedCallback.invoke() },
            modifier = modifier.padding(end = 16.dp).weight(1f),
            style = MaterialTheme.typography.bodyMedium,
        )
        RedButton(
            text = stringResource(id = R.string.yes_delete),
            onClick = { onDeleteClickedCallback.invoke() },
            modifier = modifier.weight(1f),
            style = MaterialTheme.typography.bodyMedium,
        )
    }
}

@Preview(uiMode = 1)
@Composable
fun DisplayAlertDialogPreviews() {
    DisplayAlertDialog({}, {}, stringResource(id = R.string.shopping))
}
