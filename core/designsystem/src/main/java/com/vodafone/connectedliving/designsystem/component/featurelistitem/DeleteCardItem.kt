package com.vodafone.connectedliving.designsystem.component.featurelistitem

import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.vodafone.connectedliving.designsystem.DevicePreviews
import com.vodafone.connectedliving.designsystem.R
import com.vodafone.connectedliving.designsystem.theme.CLColors
import com.vodafone.connectedliving.designsystem.theme.ConnectedLivingTheme

@Composable
fun DeleteCardItem(
    itemId: String,
    title: String,
    image: String,
    icon: String,
    subTitle: String?,
    filterList: List<String>,
    changeItemStatus: (String, Boolean) -> Unit,
    placeHolder: Int,
    modifier: Modifier = Modifier,
    isChecked: Boolean
) {
    val colors = when (isSystemInDarkTheme()) {
        true -> CheckboxDefaults.colors(
            checkedColor = Color.White,
            checkmarkColor = CLColors.Gray13,
            uncheckedColor = CLColors.White,
        )

        false -> CheckboxDefaults.colors(
            checkedColor = Color.Red,
            checkmarkColor = Color.White,
            uncheckedColor = Color.Red,
        )
    }
    val checked = remember { mutableStateOf(isChecked) }

    Box(
        modifier = modifier
            .clip(shape = RoundedCornerShape(size = 12f))
            .background(MaterialTheme.colorScheme.surface),
    ) {
        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Checkbox(
                checked = checked.value,
                onCheckedChange = { state ->
                    checked.value = state
                    changeItemStatus(itemId, state)
                },
                colors = colors,
            )
            Row(
                modifier = Modifier
                    .wrapContentHeight()
                    .defaultMinSize(minHeight = 92.dp),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically,
            ) {
                ImageCardItemView(icon, placeHolder, image)
                TextCardItemView(
                    title,
                    subTitle,
                    filterList,
                    CardStatus.UPCOMING,
                    modifier
                        .weight(2f)
                        .padding(top = 8.dp, bottom = 8.dp),
                )
            }
        }
    }
}

@DevicePreviews
@Composable
fun PreviewDeleteCardItemView() {
    ConnectedLivingTheme(darkTheme = false) {
        DeleteCardItem(
            itemId = "0",
            title = "Milk akjdbvak jdbnakk fkjsnfkjsnfjgnsfkjgnsfkjgnsfkjgnskfjngskjfngskjfngksfjngfkjgn kkkkkk djbnakdj bnadkjbnv mnmn alkdnajkdngjn aodjgnadjgnadinj lknadlgknadg mnmn",
            subTitle = "aaaaaaaaaaa",
            icon = "",
            image = "https://images.immediate.co.uk/production/volatile/sites/30/2020/02/Glass-and-bottle-of-milk-fe0997a.jpg?quality=90&resize=556,505",
            filterList = emptyList(),
            changeItemStatus = { id, status ->
            },
            placeHolder = R.drawable.ic_launcher_background,
            isChecked = true
        )
    }
}
