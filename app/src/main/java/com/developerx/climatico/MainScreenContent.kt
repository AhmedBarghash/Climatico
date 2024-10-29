package com.developerx.climatico

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import com.developerx.city_ui.CitiesViewModel
import com.developerx.selected_city_weather_broadcast_ui.CurrentWeatherScreen
import com.developerx.selected_city_weather_broadcast_ui.CurrentWeatherViewModel
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.developerx.city_ui.SelectCityScreenContent

@Composable
fun MainScreenContent() {

    val citiesViewModel: CitiesViewModel = hiltViewModel()
    val currentWeatherViewModel: CurrentWeatherViewModel = hiltViewModel()

    val citiesStates by citiesViewModel.state.collectAsStateWithLifecycle()

    /*
    * First time in the app
    *
    * - Load the search from the city_module
    * - Load the Empty Screen with instructions how to show the current weather for the selected city
    * - When the user click on the city
    * - Then load the Current Weather View  for the selected city and the 7-days Board cast from from the Selected CIty weather Module
    * - Then save the data in the data base
    *
    * Second time open the app
    *
    * - Load the search from the city_module
    * - Load the data from the data base with Hint this OLD data saved
    * - When the user click on the city
    * - Then load the Current Weather View for the selected city and the 7-days Board cast from from the Selected CIty weather Module
    * - Then save the data in the data base
    *
    */

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(colorResource(id = R.color.gray))
            .padding(dimensionResource(id = R.dimen.margin_16))
    ) {
        LoadingScreen(citiesStates.isLoading)

        // show the Search filed in the top
        SelectCityScreenContent(citiesViewModel) {
            currentWeatherViewModel.fetchWeatherDataBasedOnCoordinates(it.lat, it.lon)
        }

        // show the empty screen in case there no data from the data base
        if (citiesStates.selectedCity == null) {
            Spacer(modifier = Modifier.height(16.dp))
            EmptyScreenView()
        } else {
            CurrentWeatherScreen()
        }
    }
}


@Preview
@Composable
fun MainScreenContentPreview() {
    MainScreenContent()
}
