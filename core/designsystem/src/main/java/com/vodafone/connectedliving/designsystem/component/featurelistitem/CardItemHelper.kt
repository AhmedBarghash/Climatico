package com.vodafone.connectedliving.designsystem.component.featurelistitem

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.vodafone.connectedliving.designsystem.R
import com.vodafone.connectedliving.designsystem.component.loadIconsByName
import com.vodafone.connectedliving.designsystem.theme.CLColors
import com.vodafone.connectedliving.designsystem.theme.ConnectedLivingTheme
import com.vodafone.connectedliving.designsystem.utils.isTablet

class CardItemHelper {
    companion object {
        fun setCardStatus(status: CardStatus) = when (status) {
            CardStatus.DONE -> {
                CardStatusData(true, R.drawable.card_item_done_indicator)
            }

            CardStatus.UPCOMING -> {
                CardStatusData(false, R.drawable.card_item_upcoming_indicator)
            }

            CardStatus.OVERDUE -> {
                CardStatusData(false, R.drawable.card_item_overdue_indicator)
            }
        }
    }
}

// TODO - change diminutions

@Composable
fun ImageCardItemView(
    icon: String,
    @DrawableRes placeHolder: Int,
    image: String,
) {
    var heightmodifier = if (isTablet()) {
        Modifier.width(120.dp)
            .height(120.dp)
    } else {
        Modifier.width(76.dp)
            .height(76.dp)
    }
    Box(
        contentAlignment = Alignment.Center,
        modifier = heightmodifier
            .padding(all = 8.dp),
    ) {
        if (image.isNullOrEmpty().not()) {
            AsyncImage(
                model = image,
                contentDescription = "feature image",
            )
        } else if (icon.isNullOrEmpty().not()) {
            loadIconsByName(icon)?.let {
                Image(
                    painter = it,
                    modifier = Modifier,
                    contentDescription = "feature icon",

                )
            }
        } else {
            Image(
                painter = painterResource(id = placeHolder),
                modifier = Modifier
                    .width(44.dp)
                    .height(44.dp),
                contentDescription = "feature placeHolder",
            )
        }
    }
}

// For testing only
@Preview(showBackground = true, backgroundColor = 0xFF666666)
@Composable
fun PreviewImageCardItemView() {
    Row {
        ImageCardItemView(
            icon = "",
            R.drawable.ic_launcher_background,
            image = "https://images.immediate.co.uk/production/volatile/sites/30/2020/02/Glass-and-bottle-of-milk-fe0997a.jpg?quality=90&resize=556,505",
        )
        ImageCardItemView(
            icon = "icon_heart",
            R.drawable.ic_launcher_background,
            image = "",
        )
        ImageCardItemView(
            icon = "",
            R.drawable.ic_launcher_background,
            image = "",
        )
    }
}

// TODO - handle the filterList view.
@Composable
fun TextCardItemView(
    title: String,
    subTitle: String?,
    filterList: List<String>,
    status: CardStatus,
    modifier: Modifier,
) {
    Column(
        modifier = modifier.wrapContentHeight(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.Start,
    ) {
        Text(
            text = title,
            style = MaterialTheme.typography.titleMedium.copy(
                textDecoration = if (status == CardStatus.DONE) {
                    TextDecoration.LineThrough
                } else {
                    TextDecoration.None
                },
            ),
            color = MaterialTheme.colorScheme.onBackground,
            maxLines = 2,
            overflow = TextOverflow.Ellipsis,
        )
        subTitle?.let {
            Text(
                text = subTitle,
                color = CLColors.Gray10,
                style = MaterialTheme.typography.bodySmall,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewTextCardItemView() {
    ConnectedLivingTheme(darkTheme = true) {
        Column {
            TextCardItemView(
                "Milkskfjbvlskjbsljkdblskjdblskfjbnlskfjnblskdnblksdnfbsfbknslkfbnlksfnblskfbnklsfbnslfknbslkfnblskfnblksfnb",
                "12:00 PM",
                emptyList(),
                status = CardStatus.DONE,
                Modifier,
            )
        }
    }
}

data class CardStatusData(val doneANotDoneStatus: Boolean, val resourceIconIndicator: Int)

data class CLFeatureListItem(
    val itemId: String,
    val title: String,
    val image: String,
    val icon: String = "",
    val status: CardStatus = CardStatus.UPCOMING,
    val supTitle: String = "",
    val filterList: List<String> = emptyList(),
)

enum class CardStatus {
    DONE, OVERDUE, UPCOMING
}

fun getShoppingList() = arrayListOf(
    CLFeatureListItem(
        itemId = "0",
        title = "Milk akjdbvak jdbnakk fkjsnfkjsnfjgnsfkjgnsfkjgnsfkjgnskfjngskjfngskjfngksfjngfkjgn kkkkkk djbnakdj bnadkjbnv mnmn alkdnajkdngjn aodjgnadjgnadinj lknadlgknadg mnmn",
        supTitle = "Thi is my description lkdml kadflkna dlfknadlfk nadlfknad lkfn",
        image = "https://images.immediate.co.uk/production/volatile/sites/30/2020/02/Glass-and-bottle-of-milk-fe0997a.jpg?quality=90&resize=556,505",
    ),
    CLFeatureListItem(
        itemId = "1",
        title = "Shower gel",
        image = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTW-d3JNSYe8rW1QVJAENybEQDoUs90XSfXx_gu2gZ7mAHgQFGi8_QJRA3o2_520Cx3Xgs&usqp=CAU",
    ),
    CLFeatureListItem(
        itemId = "2",
        title = "Milk",
        image = "https://images.immediate.co.uk/production/volatile/sites/30/2020/02/Glass-and-bottle-of-milk-fe0997a.jpg?quality=90&resize=556,505",
    ),
    CLFeatureListItem(
        itemId = "3",
        title = "Shower gel",
        status = CardStatus.DONE,
        image = "",
    ),
    CLFeatureListItem(
        itemId = "4",
        title = "Shower gel",
        status = CardStatus.OVERDUE,
        image = "",
    ),
    CLFeatureListItem(
        itemId = "5",
        title = "Milk",
        status = CardStatus.UPCOMING,
        image = "",
    ),
    CLFeatureListItem(
        itemId = "6",
        title = "Shower gel",
        image = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTW-d3JNSYe8rW1QVJAENybEQDoUs90XSfXx_gu2gZ7mAHgQFGi8_QJRA3o2_520Cx3Xgs&usqp=CAU",
    ),
)
