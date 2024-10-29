package com.developerx.selected_city_weather_broadcast_ui

import android.graphics.drawable.Drawable
import android.widget.ImageView
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.viewinterop.AndroidView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.target.CustomTarget
import com.bumptech.glide.request.transition.Transition
import com.developerx.models.dto.BroadCastWeather
import java.text.SimpleDateFormat
import java.util.Locale

@Composable
fun CurrentWeatherScreen(currentWeatherViewModel: CurrentWeatherViewModel = hiltViewModel()) {
    val currentWeatherStates by currentWeatherViewModel.state.collectAsStateWithLifecycle()
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.padding(vertical = 16.dp)
        ) {
            currentWeatherStates.currentWeatherData?.name?.let {
                Text(
                    text = it,
                    style =MaterialTheme.typography.bodyLarge.copy(fontSize = 24.sp),
                    textAlign = TextAlign.Center
                )
            }
        }
        Spacer(modifier = Modifier.height(16.dp))

        // Temperature
        currentWeatherStates.currentWeatherData?.main?.let {
            Row(
                verticalAlignment = Alignment.Bottom,
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = it.temp.toString(),
                    style = MaterialTheme.typography.bodyLarge.copy(fontSize = 90.sp)
                )
                Text(
                    text = "°",
                    style = MaterialTheme.typography.bodyMedium.copy(
                        color = Color.White,
                        fontSize = 50.sp
                    ),
                    modifier = Modifier.align(Alignment.Bottom)
                )
            }
        }
        Spacer(modifier = Modifier.height(16.dp))

        // Weather Mode and Temperature Range
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.padding(vertical = 16.dp)
        ) {
            currentWeatherStates.currentWeatherData?.weather?.get(0)?.main.let {
                Text(
                    text = it.toString(),
                    style = MaterialTheme.typography.bodyLarge.copy(color = Color.White)
                )
            }
            currentWeatherStates.currentWeatherData?.main?.let {
                Row(
                    horizontalArrangement = Arrangement.Center
                ) {
                    Text(
                        text = it.tempMax.toString(),
                        style = MaterialTheme.typography.bodyMedium.copy(color = Color.White),
                        modifier = Modifier.padding(end = 8.dp)
                    )
                    Text(
                        text = it.tempMin.toString(),
                        style = MaterialTheme.typography.bodyMedium.copy(color = Color.White)
                    )
                }
            }
        }

        Spacer(modifier = Modifier.height(16.dp))
        Text(
            modifier = Modifier.fillMaxWidth(),
            text = "5 day / 3 hour forecast data",
            style = MaterialTheme.typography.titleMedium // Adjusted to use titleMedium for the section header
        )
        Spacer(modifier = Modifier.height(8.dp))

        LazyColumn {
            currentWeatherStates.weekBroadCastWeatherResponse?.let {
                items(it.list) { forecast ->
                    DailyForecastItem(forecast)
                }
            }
        }
    }
}

@Composable
fun DailyForecastItem(forecast: BroadCastWeather) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        forecast.weather[0].icon.let {
            val url = BuildConfig.ICONS_URL + it+".png"
            GlideImage(url)
        }
        Text(text = formatDate(forecast.dtTxt.toString()))
        Text(text = forecast.main?.tempMax.toString())
        Text(text = forecast.main?.tempMin.toString())
    }
}

@Composable
fun GlideImage(url: String) {
    val context = LocalContext.current

    AndroidView(
        modifier = Modifier.size(40.dp),
        factory = { context ->
        // Create an ImageView
        ImageView(context).apply {
            Glide.with(context)
                .load(url)
                .into(object : CustomTarget<Drawable>() {
                    override fun onResourceReady(resource: Drawable, transition: Transition<in Drawable>?) {
                        setImageDrawable(resource)
                    }

                    override fun onLoadCleared(placeholder: Drawable?) {
                        setImageDrawable(placeholder)
                    }
                })
        }
    })
}

fun formatDate(dateString: String): String {
    // Define the input and output date formats
    val inputFormat = SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault())
    val outputFormat = SimpleDateFormat("h:mm a", Locale.getDefault())

    // Parse the input date string
    val date = inputFormat.parse(dateString)

    // Format the date to the desired output format
    return outputFormat.format(date)
}
@Preview(showBackground = true)
@Composable
fun PreviewWeatherScreen() {
    CurrentWeatherScreen()
}
