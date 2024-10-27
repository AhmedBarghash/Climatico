package com.vodafone.connectedliving.designsystem.component

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Divider
import androidx.compose.material3.DrawerState
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.vodafone.connectedliving.designsystem.DevicePreviews
import com.vodafone.connectedliving.designsystem.R
import com.vodafone.connectedliving.designsystem.icon.CLIcons
import com.vodafone.connectedliving.designsystem.theme.CLColors
import com.vodafone.connectedliving.designsystem.theme.ConnectedLivingTheme
import com.vodafone.connectedliving.designsystem.utils.isTablet


@DevicePreviews
@Composable
fun LightAppDrawerPreview() {
    ConnectedLivingTheme(darkTheme = false) {
        AppDrawer(
            drawerState = rememberDrawerState(initialValue = DrawerValue.Open),
            drawerItems = mutableListOf(
                DrawerItem(
                    id = "ahmedragab.se@gmail.com",
                    name = "Ahmed Ragab",
                    nickName = "Ragabz",
                    profileImage = "https://images.unsplash.com/photo-1503023345310-bd7c1de61c7d?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8Mnx8aHVtYW58ZW58MHx8MHx8fDA%3D&w=1000&q=80",
                    isSelected = true
                ),
                DrawerItem(
                    id = "ragabz1028@gmail.com",
                    name = "Ahmed Ragab 2",
                    nickName = "Ragabz 2",
                    profileImage = "",
                    isSelected = false
                ),
            ),
            onItemClick = {})

    }
}

@DevicePreviews
@Composable
fun DarkAppDrawerPreview() {
    ConnectedLivingTheme(darkTheme = true) {
        AppDrawer(
            drawerState = rememberDrawerState(initialValue = DrawerValue.Open),
            drawerItems = mutableListOf(
                DrawerItem(
                    id = "ahmedragab.se@gmail.com",
                    name = "Ahmed Ragab",
                    nickName = "Ragabz",
                    profileImage = "https://images.unsplash.com/photo-1503023345310-bd7c1de61c7d?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8Mnx8aHVtYW58ZW58MHx8MHx8fDA%3D&w=1000&q=80",
                    isSelected = true
                ),
                DrawerItem(
                    id = "ragabz1028@gmail.com",
                    name = "Ahmed Ragab 2",
                    nickName = "Ragabz 2",
                    profileImage = "",
                    isSelected = false
                ),
            ),
            onItemClick = {})
    }
}


@Composable
fun AppDrawer(
    modifier: Modifier = Modifier,
    drawerState: DrawerState,
    drawerItems: List<DrawerItem>,
    onItemClick: (id: String) -> Unit

) {

    ModalDrawerSheet(modifier = modifier) {
        Surface(modifier = Modifier.animateContentSize()) {
            Column(modifier = Modifier.fillMaxSize()) {

                // header
                DrawerHeader(modifier = Modifier.padding(16.dp))

                // items
                LazyColumn(modifier = Modifier.padding(16.dp)) {
                    items(drawerItems, key = { item ->
                        item.hashCode()
                    }) { item ->
                        Column(
                            Modifier
                                .padding(8.dp)
                                .fillMaxWidth()
                                .wrapContentHeight()

                        ) {
                            DrawerItem(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .wrapContentHeight(), model = item
                            ) { id ->
                                onItemClick(id)
                            }
                            if (item.isSelected.not()) {
                                Divider(thickness = 1.dp, color = Color(0xFFBBBBBB), modifier = Modifier.padding(top = 8.dp))
                            }
                        }
                    }
                }
            }
        }
    }
}


@Composable
fun DrawerItem(
    modifier: Modifier = Modifier,
    model: DrawerItem,
    onClick: (id: String) -> Unit
) {
    Row(modifier = modifier
        .background(
            if (model.isSelected) MaterialTheme.colorScheme.background else Color.Unspecified,
            RoundedCornerShape(6.dp)
        )
        .clickable {
            onClick(model.id)
        }) {
        // profile image or icon
        ChooserImage(
            modifier = Modifier
                .align(Alignment.CenterVertically)
                .padding(8.dp)
                .height(80.dp),
            imageUrl = model.profileImage
        )
        // names
        Column(modifier = Modifier.align(Alignment.CenterVertically)) {

            // name
            DrawerItemText(
                modifier = Modifier.padding(bottom = 4.dp),
                text = model.name,
                style = MaterialTheme.typography.titleMedium,
                color = MaterialTheme.colorScheme.onBackground
            )

            // nick name
            DrawerItemText(
                text = if (model.nickName.isNotBlank()) model.nickName else "No Nick Name",
                style = MaterialTheme.typography.bodyLarge,
                color = if (isSystemInDarkTheme()) CLColors.Gray05 else CLColors.Gray10
            )

        }
    }
}

@Composable
fun ChooserImage(
    modifier: Modifier = Modifier, imageUrl: String
) {
    when (imageUrl.isEmpty()) {
        true -> {
            Icon(
                painter = painterResource(id = CLIcons.ChooserProfile),
                contentDescription = null,
                modifier = modifier.size(if(isTablet()) 120.dp else 80.dp)
            )
        }

        false -> {
            AsyncImage(
                model = imageUrl,
                contentDescription = null,
                contentScale = ContentScale.FillBounds,
                modifier = modifier.size(if(isTablet()) 120.dp else 80.dp).clip(CircleShape)
            )
        }
    }
}

@Composable
fun DrawerHeader(
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier) {
        // title
        DrawerItemText(
            text = stringResource(R.string.title_drawer_header),
            style = MaterialTheme.typography.titleLarge,
            color = MaterialTheme.colorScheme.onBackground
        )
        // description
        DrawerItemText(
            text = stringResource(R.string.description_drawer_header),
            style = MaterialTheme.typography.titleMedium,
            color = if (isSystemInDarkTheme()) CLColors.Gray05 else CLColors.Gray10
        )
    }
}

@Composable
fun DrawerItemText(
    modifier: Modifier = Modifier,
    text: String,
    style: TextStyle,
    color: Color
) {
    Text(
        text = text,
        style = style,
        color = color,
        modifier = modifier
    )
}


data class DrawerItem(
    val id: String,
    val name: String = "",
    val nickName: String = "",
    val profileImage: String = "",
    val isSelected: Boolean = false
)