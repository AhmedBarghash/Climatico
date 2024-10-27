package com.vodafone.connectedliving.designsystem.component.topbar

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import com.vodafone.connectedliving.designsystem.R
import com.vodafone.connectedliving.designsystem.component.text.SubTitleText

/**
 * it will be rendered in list screen
 * 1- contains only the title centered
 * 2- contains the back button to navigate back to previous screen
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CLEmptyListTopAppBar(
    modifier: Modifier = Modifier,
    title: String = "Routines",
    backAction: () -> Unit
) {
    TopAppBar(
        modifier = modifier,
        title = {
            SubTitleText(
                text = title,
                textAlign = TextAlign.Center,
                color = MaterialTheme.colorScheme.onBackground,
                modifier = Modifier.fillMaxWidth()
            )
        }, navigationIcon = {
            IconButton(onClick = backAction) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_back),
                    contentDescription = "back",
                    tint = MaterialTheme.colorScheme.primary
                )
            }
        }
    )
}