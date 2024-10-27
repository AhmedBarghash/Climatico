package com.vodafone.connectedliving.designsystem.component.topbar

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.vodafone.connectedliving.designsystem.DevicePreviews
import com.vodafone.connectedliving.designsystem.R
import com.vodafone.connectedliving.designsystem.component.BadgeIcon
import com.vodafone.connectedliving.designsystem.component.text.SubTitleText
import com.vodafone.connectedliving.designsystem.theme.CLColors

/**
 * it will be rendered in list screen
 * 1- contains only the title centered
 * 2- contains the back button to navigate back to previous screen
 */
@OptIn(ExperimentalMaterial3Api::class)
@DevicePreviews
@Composable
fun CLHomeTopAppBar(
    modifier: Modifier = Modifier,
    title: String = "",
    showNotificationIcon: Boolean = true,
    notificationCount: Int = 1234
) {
    TopAppBar(title = {
        SubTitleText(
            text = title,
            textAlign = TextAlign.Center,
            color = MaterialTheme.colorScheme.onBackground,
            modifier = Modifier.fillMaxWidth()
        )

    }, navigationIcon = {
        IconButton(onClick = { }) {
            Icon(
                painter = painterResource(id = R.drawable.ic_logo),
                contentDescription = "Logo",
                tint = if (isSystemInDarkTheme()) CLColors.White else Color.Unspecified
            )
        }
    }, actions = {
        if (showNotificationIcon) {
            BadgeIcon(
                modifier = Modifier.padding(end = 25.dp),
                icon = R.drawable.ic_notification,
                badgeCount = notificationCount
            )
        }
    })
}










