package com.vodafone.connectedliving.designsystem.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredSize
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.vodafone.connectedliving.designsystem.icon.CLIcons

@Composable
fun HowToLinkField(
    value: String,
    label: String,
    colours: TextFieldColors = OutlinedTextFieldDefaults.colors(
        focusedTextColor = MaterialTheme.colorScheme.primary,
        unfocusedTextColor = MaterialTheme.colorScheme.tertiary,
        focusedBorderColor = MaterialTheme.colorScheme.primary,
        unfocusedBorderColor = MaterialTheme.colorScheme.tertiary,
        focusedLabelColor = MaterialTheme.colorScheme.primary,
        unfocusedLabelColor = MaterialTheme.colorScheme.tertiary,
        disabledBorderColor = MaterialTheme.colorScheme.onPrimary,
        disabledContainerColor = MaterialTheme.colorScheme.error,
        disabledLabelColor = MaterialTheme.colorScheme.onPrimary,
    ),
    onFieldClickedCallback: () -> Unit,
    enabled: Boolean = true
) {
    val iconColour = if (enabled) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.onPrimary
    OutlinedTextField(
        value = value,
        onValueChange = {},
        label = {
            LabelText(
                labelText = label,
                colour = if (!enabled) MaterialTheme.colorScheme.onPrimary else MaterialTheme.colorScheme.primary
            )
        },
        colors = colours,
        modifier = Modifier
            .fillMaxWidth()
            .onFocusChanged {
                if (it.hasFocus) onFieldClickedCallback.invoke()
            },
        enabled = enabled,
        readOnly = true,
        trailingIcon = { TrailingIcon(resId = CLIcons.TimePlaceholder, colourId = iconColour) }
    )
}

@Composable
fun HowToLinkBottomSheetLayout(
    valueClicked: ((id: String, title: String) -> Unit),
    howToList: List<HowTo>?,
    onCloseButtonClicked: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(MaterialTheme.colorScheme.surface)
    ) {
        BottomSheetTitle(
            title = "How To List",
            closeClickedCallback = { onCloseButtonClicked.invoke() }
        )
        if (!howToList.isNullOrEmpty()) {
            Column {
                Text(
                    text = "Select none",
                    color = MaterialTheme.colorScheme.primary,
                    style = MaterialTheme.typography.bodyLarge,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                        .clickable {
                            onCloseButtonClicked.invoke()
                        },
                )
                BottomSheetDividerLine()
                LazyColumn() {
                    itemsIndexed(items = howToList) { index, item ->
                        HowToListItem(
                            id = item.id,
                            title = item.steps[0].title,
                            imageUrl = item.steps[0].imageUrl,
                            selectedHowTo = {
                                valueClicked.invoke(item.id, item.steps[0].title)
                            }
                        )
                        if (index != howToList.lastIndex) BottomSheetDividerLine()
                    }
                }
            }
        } else {
            HowToListEmptyScreen(
                addHowToClickedCallback = {  },
            )
        }
    }
}

@Composable
fun HowToListItem(
    id: String,
    title: String,
    imageUrl: String,
    selectedHowTo: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .clickable {
                selectedHowTo.invoke()
            },
    ) {
        Image(
            painter = rememberAsyncImagePainter(imageUrl),
            contentDescription = "",
            modifier = Modifier.requiredSize(32.dp)
        )
        Spacer(modifier = Modifier.width(16.dp))
        Text(
            text = title,
            color = MaterialTheme.colorScheme.primary,
            style = MaterialTheme.typography.bodyLarge,
            modifier = Modifier
//                .fillMaxWidth()
                .weight(1f)
        )
    }
}

@Composable
fun HowToListEmptyScreen(
    addHowToClickedCallback: () -> Unit,
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Nothing here yet!",
            color = MaterialTheme.colorScheme.primary,
            style = MaterialTheme.typography.bodyLarge,
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = "Create your first How To",
            color = MaterialTheme.colorScheme.primary,
            style = MaterialTheme.typography.bodyLarge,
        )
        Spacer(modifier = Modifier.height(8.dp))
        RedButton(
            text = "Add New How To",
            onClick = { addHowToClickedCallback.invoke() },
            style = MaterialTheme.typography.titleMedium
        )
    }
}

data class HowTo(
    val id: String,
    var index: Int,
    val steps: MutableList<HowToStep>,
    var checked: Boolean = false
)

data class HowToStep(
    val description: String,
    val icon: String,
    val id: String,
    val imageUrl: String,
    val index: Int,
    val title: String,
    var checked: Boolean = false
)