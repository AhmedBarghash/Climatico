package com.vodafone.connectedliving.designsystem.component.featurelistitem

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.combinedClickable
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.vodafone.connectedliving.designsystem.DevicePreviews
import com.vodafone.connectedliving.designsystem.R
import com.vodafone.connectedliving.designsystem.component.featurelistitem.CardItemHelper.Companion.setCardStatus
import com.vodafone.connectedliving.designsystem.theme.CLColors
import com.vodafone.connectedliving.designsystem.theme.ConnectedLivingTheme
import com.vodafone.connectedliving.designsystem.utils.isTablet
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

// TODO - change Text diminutions
// TODO - the Res for the image.
@OptIn(ExperimentalFoundationApi::class)
@Composable
fun CardItem(
    itemId: String,
    title: String,
    image: String,
    icon: String,
    supTitle: String?,
    status: CardStatus,
    filterList: List<String>,
    onItemLongClicked: () -> Unit,
    onItemClicked: () -> Unit,
    changeItemStatus: (String) -> Unit,
    placeHolderResID: Int,
    modifier: Modifier = Modifier,
) {
    var showRadioButton by remember { mutableStateOf(true) }
    val scope = rememberCoroutineScope()
    var heightmodifier = if (isTablet()) {
        modifier.height(152.dp)
    } else {
        modifier.height(92.dp)
    }
    Box(
        modifier = heightmodifier.padding(bottom = 8.dp)
            .combinedClickable(
                onClick = onItemClicked,
                onLongClick = onItemLongClicked,
            )
            .clip(shape = RoundedCornerShape(size = 12f))
            .background(MaterialTheme.colorScheme.surface),
    ) {
        val cardStatus = setCardStatus(status)
        var radioButtonModifier = if (isTablet()) {
            modifier.padding(32.dp).size(30.dp)
        } else {
            modifier.padding(8.dp).size(30.dp)
        }
        Row(
            modifier = modifier.wrapContentHeight(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically,
        ) {
            if (showRadioButton) {
                RadioButton(
                    modifier = radioButtonModifier,
                    // inside this method we are
                    // adding selected with a option.
                    selected = cardStatus.doneANotDoneStatus,
                    onClick = {
                        changeItemStatus(itemId)
                        showRadioButton = false
                        scope.launch {
                            delay(2000)
                            showRadioButton = true
                        }
                    },
                    colors = RadioButtonDefaults.colors(
                        selectedColor = MaterialTheme.colorScheme.secondary,
                        unselectedColor = MaterialTheme.colorScheme.secondary,
                    ),
                )
            } else {
                CircularProgressIndicator(
                    modifier = radioButtonModifier,
                    color = if (isSystemInDarkTheme()) CLColors.White else CLColors.VodafoneDarkRed,
                )
            }
            Divider(
                color = CLColors.Gray05,
                modifier = Modifier
                    .fillMaxHeight()
                    .width(1.dp),
            )

            ImageCardItemView(icon, placeHolderResID, image)
            TextCardItemView(
                title,
                supTitle,
                filterList,
                status,
                modifier
                    .weight(2f)
                    .padding(top = 8.dp, bottom = 8.dp),
            )

            Image(
                painter = painterResource(id = cardStatus.resourceIconIndicator),
                contentDescription = "",
                modifier = if (isTablet()) {
                    modifier.padding(all = 16.dp)
                } else {
                    modifier.padding(all = 8.dp)
                },
            )
        }
    }
}

@DevicePreviews
@Composable
fun PreviewCardItemView() {
    ConnectedLivingTheme(darkTheme = true) {
        CardItem(
            itemId = "0",
            title = "Go to the library sfsdfsdfsddfadfafadfdfafadf",
            supTitle = "Assigned 26 December 2022",
            icon = "icon_heart",
            image = "",
            filterList = emptyList(),
            status = CardStatus.DONE,
            onItemLongClicked = {},
            onItemClicked = {},
            changeItemStatus = { id -> },
            placeHolderResID = R.drawable.ic_launcher_background,
            modifier = Modifier,
        )
    }
}
