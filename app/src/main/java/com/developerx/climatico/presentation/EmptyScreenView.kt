package com.developerx.climatico.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.BasicText
import androidx.compose.material.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.developerx.climatico.R

@Composable
fun EmptyScreenView() {
    Box(
        modifier = Modifier
            .wrapContentSize()
            .background(colorResource(id = R.color.gray)), // Replace with your color
        contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = Modifier
                .wrapContentWidth()
                .wrapContentHeight()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_empty),
                contentDescription = null,
                modifier = Modifier.size(144.dp)
            )
            Spacer(modifier = Modifier.height(16.dp))
            BasicText(
                text = stringResource(id = R.string.empty_screen_title),
                style = MaterialTheme.typography.h4.copy(color = Color.Gray, fontSize = 20.sp)
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                textAlign = TextAlign.Center,
                text = stringResource(id = R.string.empty_screen_message),
                style = MaterialTheme.typography.body1.copy(color = Color.Gray, fontSize = 16.sp)
            )
            Spacer(modifier = Modifier.height(16.dp))
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewEmptyStateView() {
    EmptyScreenView()
}
