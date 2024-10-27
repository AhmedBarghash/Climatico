package com.vodafone.connectedliving.designsystem.component.bottomsheets

import androidx.annotation.DrawableRes
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.SheetState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.vodafone.connectedliving.designsystem.component.text.BodyMediumText
import com.vodafone.connectedliving.designsystem.icon.CLIcons
import com.vodafone.connectedliving.designsystem.theme.CLColors

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun OptionBottomSheet(
    modifier: Modifier = Modifier,
    visible: Boolean = false,
    sheetState: SheetState,
    onEditOption: () -> Unit,
    onDeleteOption: () -> Unit,
    onReOrderOption: () -> Unit,
    onDismiss: () -> Unit
) {
    if (visible) {
        ModalBottomSheet(
            onDismissRequest = onDismiss,
            sheetState = sheetState,
            modifier = modifier
        ) {
            Column {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    horizontalArrangement = Arrangement.End,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        painter = painterResource(id = CLIcons.Close),
                        contentDescription = "close",
                        tint = Color.Unspecified,
                        modifier = Modifier.clickable {
                            onDismiss()
                        }
                    )
                }
                OptionCard(
                    modifier = Modifier
                        .height(100.dp)
                        .clickable { onEditOption() },
                    iconResource = CLIcons.EditPencil,
                    title = "Edit",
                    description = "Edit the selected item"
                )
                Divider(modifier = Modifier.background(CLColors.Gray05))
                OptionCard(
                    modifier = Modifier
                        .height(100.dp)
                        .clickable { onDeleteOption() },
                    iconResource = CLIcons.Delete,
                    title = "Delete",
                    description = "Open the delete mode"
                )
                Divider(modifier = Modifier.background(CLColors.Gray05))
                OptionCard(
                    modifier = Modifier
                        .height(100.dp)
                        .clickable { onReOrderOption() },
                    iconResource = CLIcons.ReOrder,
                    title = "ReOrder",
                    description = "Open the reorder mode"
                )
            }
        }
    }
}


@Composable
fun OptionCard(
    modifier: Modifier = Modifier,
    @DrawableRes iconResource: Int,
    title: String,
    description: String
) {
    Row(modifier = modifier.padding(16.dp)) {
        /* icon */
        Icon(
            painter = painterResource(id = iconResource),
            contentDescription = "edit",
            modifier = Modifier
                .align(Alignment.CenterVertically)
                .padding(16.dp),
            tint = Color.Unspecified
        )
        /* column ( title & description ) */
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .align(Alignment.CenterVertically)
        ) {
            BodyMediumText(
                text = title,
                color = MaterialTheme.colorScheme.onBackground,
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.padding(4.dp))
            BodyMediumText(
                text = description,
                color = MaterialTheme.colorScheme.onBackground,
                modifier = Modifier.fillMaxWidth()
            )
        }

    }
}

@Composable
@Preview
fun OptionCardPreview() {
    OptionCard(
        modifier = Modifier
            .height(100.dp)
            .clickable {},
        iconResource = CLIcons.EditPencil,
        title = "Edit",
        description = "Edit the selected item"
    )
}