package com.vodafone.connectedliving.designsystem.component.text

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow

@Composable
fun BodyLargeText(
    modifier: Modifier = Modifier,
    text: String,
    color: Color,
    maxLines: Int = 1,
    fontWeight: FontWeight = FontWeight.Normal,
    overflow: TextOverflow = TextOverflow.Ellipsis,
    textAlign: TextAlign? = null
) {
    Text(
        text = text,
        modifier = modifier,
        style = MaterialTheme.typography.bodyLarge,
        color = color,
        maxLines = maxLines,
        fontWeight = fontWeight,
        overflow = overflow,
        textAlign= textAlign
    )
}

@Composable
fun BodySmallText(
    modifier: Modifier = Modifier,
    text: String,
    color: Color,
    maxLines: Int = 1,
    fontWeight: FontWeight = FontWeight.Normal,
    overflow: TextOverflow = TextOverflow.Ellipsis,
) {
    Text(
        text = text,
        modifier = modifier,
        style = MaterialTheme.typography.bodySmall,
        color = color,
        maxLines = maxLines,
        fontWeight = fontWeight,
        overflow = overflow,
    )
}

@Composable
fun BodyMediumText(
    modifier: Modifier = Modifier,
    text: String,
    color: Color,
    maxLines: Int = 1,
    textAlign: TextAlign = TextAlign.Start,
    fontWeight: FontWeight = FontWeight.Normal,
    overflow: TextOverflow = TextOverflow.Ellipsis,
) {
    Text(
        text = text,
        modifier = modifier,
        style = MaterialTheme.typography.bodyMedium,
        color = color,
        maxLines = maxLines,
        fontWeight = fontWeight,
        textAlign = textAlign,
        overflow = overflow,
    )
}

@Composable
fun TitleText(
    modifier: Modifier = Modifier,
    text: String,
    color: Color,
    maxLines: Int = 1,
    fontWeight: FontWeight = FontWeight.Normal,
    overflow: TextOverflow = TextOverflow.Ellipsis,
) {
    Text(
        text = text,
        modifier = modifier,
        style = MaterialTheme.typography.titleLarge,
        color = color,
        maxLines = maxLines,
        fontWeight = fontWeight,
        overflow = overflow,
    )
}

@Composable
fun SubTitleText(
    modifier: Modifier = Modifier,
    text: String,
    color: Color,
    textAlign: TextAlign = TextAlign.Start,
    maxLines: Int = 1,
    fontWeight: FontWeight = FontWeight.Normal,
    overflow: TextOverflow = TextOverflow.Ellipsis,
) {
    Text(
        text = text,
        modifier = modifier,
        style = MaterialTheme.typography.titleMedium,
        color = color,
        textAlign = textAlign,
        maxLines = maxLines,
        fontWeight = fontWeight,
        overflow = overflow,
    )
}
