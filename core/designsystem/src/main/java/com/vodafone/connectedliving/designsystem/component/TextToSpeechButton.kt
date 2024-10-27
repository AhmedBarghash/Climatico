package com.vodafone.connectedliving.designsystem.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.vodafone.connectedliving.designsystem.icon.CLIcons

@Composable
fun TextToSpeechButton(
    ttsClickedCallback: () -> Unit
) {
    Box(
        modifier  = Modifier.clickable { ttsClickedCallback.invoke() }
            .width(48.dp)
            .height(48.dp),
    ) {
        Image(
            painter = painterResource(CLIcons.AudioSpeaker),
            contentDescription = "",
            modifier = Modifier
                .background(MaterialTheme.colorScheme.secondary, CircleShape)
                .align(Alignment.Center)
                .padding(8.dp),
            contentScale = ContentScale.Crop,
        )
    }
}