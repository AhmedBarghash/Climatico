package com.vodafone.connectedliving.designsystem.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.Paint
import androidx.compose.ui.graphics.PaintingStyle
import androidx.compose.ui.graphics.PathEffect
import androidx.compose.ui.graphics.drawscope.drawIntoCanvas
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.vodafone.connectedliving.designsystem.R
import com.vodafone.connectedliving.designsystem.icon.CLIcons
import com.vodafone.connectedliving.designsystem.theme.ConnectedLivingTheme
import com.vodafone.connectedliving.designsystem.utils.isTablet

@Composable
fun ImagePickerField(
    bitmap: ImageBitmap?,
    url: String?,
    onAddImageClickedCallback: () -> Unit
) {
    ConnectedLivingTheme {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
        ) {
            val imageHeight = if (isTablet()) 340.dp else 200.dp
            val editImageModifier = Modifier
                .background(MaterialTheme.colorScheme.secondary, CircleShape)
                .align(Alignment.BottomEnd)
                .clickable { onAddImageClickedCallback.invoke() }
                .size(48.dp)
                .padding(8.dp)

            if (!url.isNullOrBlank()) {
                Image(
                    painter = rememberAsyncImagePainter(url),
                    contentDescription = "",
                    modifier = Modifier
                        .fillMaxWidth()
                        .aspectRatio(1f) // Make the image square.
                        .clip(shape = RoundedCornerShape(6.dp)),
                    contentScale = ContentScale.Crop,

                )
                DisplayChangeImageButton(
                    modifier = editImageModifier
                )
            } else if (bitmap != null) {
                Image(
                    bitmap = bitmap,
                    contentDescription = "",
                    modifier = Modifier
                        .fillMaxWidth()
                        .aspectRatio(1f) // Make the image square.
                        .clip(shape = RoundedCornerShape(6.dp))
                        .clickable { onAddImageClickedCallback.invoke() },
                    contentScale = ContentScale.Crop
                )
                DisplayChangeImageButton(
                    modifier = editImageModifier
                )
            } else {
                DisplayImagePlaceholder { onAddImageClickedCallback.invoke() }
            }
        }
    }
}

@Composable
fun DisplayImagePlaceholder(onAddImageClickedCallback: () -> Unit) {
    val placeholderHeight = if (isTablet()) 120.dp else 80.dp
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(placeholderHeight)
            .background(
                color = colorResource(id = R.color.image_chooser_background),
                shape = RoundedCornerShape(6.dp)
            )
            .dashedBorder(1.dp, 6.dp, colorResource(id = R.color.image_chooser_outline))
            .clickable { onAddImageClickedCallback.invoke() }
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxSize(),
            horizontalArrangement = Arrangement.Center
        ) {
            Icon(
                painter = painterResource(
                    id = R.drawable.ic_upload_picture
                ),
                tint = MaterialTheme.colorScheme.primary,
                contentDescription = stringResource(id = R.string.choose_picture),
                modifier = Modifier
                    .height(25.dp)
                    .width(25.dp)
                    .padding(end = 8.dp)
            )
            Text(
                text = stringResource(id = R.string.choose_picture),
                style = MaterialTheme.typography.bodyLarge,
                modifier = Modifier,
                color = MaterialTheme.colorScheme.primary
            )
        }
    }
}

@Composable
fun DisplayChangeImageButton(modifier: Modifier) {
    Box(
        modifier  = modifier,
    ) {
        Image(
            painter = painterResource(CLIcons.EditPencil),
            contentDescription = "",
            modifier = Modifier
                .background(MaterialTheme.colorScheme.secondary, CircleShape)
                .align(Alignment.Center)
                .width(32.dp)
                .height(32.dp),
            contentScale = ContentScale.Crop,
        )
    }
}

fun Modifier.dashedBorder(width: Dp, radius: Dp, color: Color) =
    drawBehind {
        drawIntoCanvas {
            val paint = Paint()
                .apply {
                    strokeWidth = width.toPx()
                    this.color = color
                    style = PaintingStyle.Stroke
                    pathEffect = PathEffect.dashPathEffect(floatArrayOf(25f, 25f), 0f)
                }
            it.drawRoundRect(
                (width.toPx() / 2),
                (width.toPx() / 2),
                size.width - (width.toPx() / 2),
                size.height - (width.toPx() / 2),
                radius.toPx(),
                radius.toPx(),
                paint
            )
        }
    }

@Composable
fun DisplayNoImageSelected() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(36.dp)
            .background(MaterialTheme.colorScheme.onTertiaryContainer)
            .border(
                width = 1.dp,
                color = MaterialTheme.colorScheme.tertiaryContainer,
                shape = RoundedCornerShape(6.dp)
            ),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = stringResource(id = R.string.no_picture_uploaded),
            style = MaterialTheme.typography.bodyLarge,
            color = MaterialTheme.colorScheme.tertiary
        )
    }
}

@Composable
fun DisplaySavedImage(url: String, bitmap: ImageBitmap?) {
    if (url.isNotBlank()) {
        Image(
            painter = rememberAsyncImagePainter(url),
            contentDescription = "",
            modifier = Modifier
                .fillMaxWidth()
                .aspectRatio(1f) // Make the image square.
                .clip(shape = RoundedCornerShape(6.dp)),
            contentScale = ContentScale.Crop,
        )
    } else if (bitmap != null) {
        Image(
            bitmap = bitmap,
            contentDescription = "",
            modifier = Modifier
                .fillMaxWidth()
                .aspectRatio(1f) // Make the image square.
                .clip(shape = RoundedCornerShape(6.dp)),
            contentScale = ContentScale.Crop
        )
    } else {
        DisplayNoImageSelected()
    }
}