package com.vodafone.connectedliving.designsystem.component

import androidx.annotation.DrawableRes
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.vodafone.connectedliving.designsystem.theme.CLColors
import com.vodafone.connectedliving.designsystem.utils.isTablet

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BadgeIcon(
    modifier: Modifier = Modifier,
    @DrawableRes icon: Int,
    badgeCount: Int = 0
) {
    val iconSize = if (isTablet()) 30.dp else 25.dp
    Box(modifier = modifier) {
        if (badgeCount != 0) {
            BadgedBox(badge = {
                Badge(containerColor = CLColors.VodafoneRed) {
                    Text(text = "$badgeCount", color = CLColors.White)
                }
            }) {
                Icon(
                    painter = painterResource(id = icon),
                    contentDescription = null,
                    modifier = Modifier.size(iconSize),
                    tint = MaterialTheme.colorScheme.primary
                )
            }
        } else {
            Icon(
                painter = painterResource(id = icon),
                contentDescription = null,
                modifier = Modifier.size(iconSize),
                tint = MaterialTheme.colorScheme.primary
            )
        }
    }

}
