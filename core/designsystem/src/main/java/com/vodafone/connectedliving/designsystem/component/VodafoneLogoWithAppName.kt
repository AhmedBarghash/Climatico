package com.vodafone.connectedliving.designsystem.component

import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import com.vodafone.connectedliving.designsystem.R

@Composable
fun VodafoneLogoWithAppName(modifier: Modifier = Modifier) {
    Image(
        painter = painterResource(
            id = R.drawable.ic_vodafone_logo,
        ),
        contentDescription = "",
        modifier = modifier,
    )
}
