package com.developerx.climatico.presentation

import android.util.Log
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
import com.developerx.climatico.R
import com.developerx.historical_broadcast_ui.HistoryBroadCastViewModel
import com.developerx.models.dto.City

@Composable
fun MainScreenContent() {

    val citiesViewModel: CitiesViewModel = hiltViewModel()
    // Have instance from this so I can fetch teh Current and the next 5 days weather records
    val currentWeatherViewModel: CurrentWeatherViewModel = hiltViewModel()
    val historyBroadCastViewModel: HistoryBroadCastViewModel = hiltViewModel()

    val citiesStates by citiesViewModel.state.collectAsStateWithLifecycle()
    val currentWeatherViewModelStates by currentWeatherViewModel.state.collectAsStateWithLifecycle()

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
            if (it != null) {
                citiesViewModel.setSelectedCity(it)
                currentWeatherViewModel.fetchWeatherDataBasedOnCoordinates(it.lat, it.lon)
                if (citiesStates.selectedCity != null && currentWeatherViewModelStates.currentWeatherData != null) {
                    historyBroadCastViewModel.saveWeatherDataInDatabase(
                        citiesStates.selectedCity!!,
                        currentWeatherViewModelStates.currentWeatherData!!
                    )
                }
            }
        }

        // show the empty screen in case there no data from the data base
        if (currentWeatherViewModelStates.currentWeatherData == null) {
            historyBroadCastViewModel.loadLastedSearchedCityWeatherData {
                if (it != null) {
                    citiesViewModel.setSelectedCity(
                        City(
                            it.cityId,
                            it.cityNameAr,
                            it.cityNameEn,
                            it.lat,
                            it.lon
                        )
                    )
                    currentWeatherViewModel.setWeatherData(it)
                }
            }
        } else {
            // Load the view for the Selected City
            CurrentWeatherScreen{}
        }
    }
}


@Preview
@Composable
fun MainScreenContentPreview() {
    MainScreenContent()
}
