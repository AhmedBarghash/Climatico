package com.vodafone.connectedliving.designsystem.component.featurelistitem

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.vodafone.connectedliving.designsystem.R
import com.vodafone.connectedliving.designsystem.theme.ConnectedLivingTheme

@Composable
fun OrderCardItem(
    itemId: String,
    title: String,
    image: String,
    icon: String,
    supTitle: String,
    filterList: List<String>,
    placeHolder: Int,
    modifier: Modifier = Modifier,
) {
    Box(
        modifier = modifier
            .clip(shape = RoundedCornerShape(size = 12f))
            .background(MaterialTheme.colorScheme.background),
    ) {
        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Row(
                modifier = modifier
                    .wrapContentHeight()
                    .defaultMinSize(minHeight = 92.dp),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically,
            ) {
                ImageCardItemView(icon, placeHolder, image)
                TextCardItemView(
                    title,
                    supTitle,
                    filterList,
                    CardStatus.UPCOMING,
                    modifier
                        .weight(2f)
                        .padding(top = 8.dp, bottom = 8.dp),
                )
                Image(
                    painter = painterResource(id = R.drawable.card_item_reorder_indicator),
                    contentDescription = "",
                    modifier = modifier.padding(all = 8.dp),
                )
            }
        }
    }
}

@Preview(device = Devices.PHONE, showBackground = true)
@Composable
fun PreviewOrderCardItemView() {
    ConnectedLivingTheme(darkTheme = true) {
        OrderCardItem(
            itemId = "0",
            title = "Milk akjdbvak jdbnakk fkjsnfkjsnfjgnsfkjgnsfkjgnsfkjgnskfjngskjfngskjfngksfjngfkjgn kkkkkk djbnakdj bnadkjbnv mnmn alkdnajkdngjn aodjgnadjgnadinj lknadlgknadg mnmn",
            supTitle = "aaaaaaaaaaa",
            icon = "",
            image = "",
            filterList = emptyList(),
            placeHolder = R.drawable.ic_launcher_background,
            modifier = Modifier,
        )
    }
}
