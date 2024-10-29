package com.developerx.selected_city_weather_broadcast_ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.developerx.base.mvi.Store
import com.developerx.core.common.AppError
import com.developerx.core.common.onError
import com.developerx.core.common.onSuccess
import com.developerx.models.LocalWeatherCharacteristics
import com.developerx.models.dto.CurrentWeatherResponse
import com.developerx.models.dto.Main
import com.developerx.models.dto.Weather
import com.developerx.selected_city_weather_broadcast_domain.usecase.GetCurrentWeatherDataUseCase
import com.developerx.selected_city_weather_broadcast_domain.usecase.GetWeekBoardCastBasedOnLocation
import com.developerx.selected_city_weather_broadcast_ui.city_ui_states.CurrentWeatherScreenActions
import com.developerx.selected_city_weather_broadcast_ui.city_ui_states.CurrentWeatherScreenReducer
import com.developerx.selected_city_weather_broadcast_ui.city_ui_states.CurrentWeatherScreenStates
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CurrentWeatherViewModel @Inject constructor(
    private val getCurrentWeatherDataUseCase: GetCurrentWeatherDataUseCase,
    private val getWeekBoardCastBasedOnLocation: GetWeekBoardCastBasedOnLocation,
) : ViewModel() {

    private val store = Store(
        initialState = CurrentWeatherScreenStates(),
        reducer = CurrentWeatherScreenReducer(),
    )

    val state: StateFlow<CurrentWeatherScreenStates> = store.state

    fun fetchWeatherDataBasedOnCoordinates(lat: Double, lon: Double) {
        store.dispatch(CurrentWeatherScreenActions.SetLoadingValue(true))
        viewModelScope.launch {
            getCurrentWeatherDataUseCase(GetCurrentWeatherDataUseCase.Request(lat, lon)).collect {
                it.onSuccess { response ->
                    store.dispatch(CurrentWeatherScreenActions.SetCurrentWeather(response))
                    fetchWeekBroadcast(lat, lon)
                }
                it.onError { error -> handleError(error) }
            }
        }
    }

    fun setWeatherData(localWeatherCharacteristics: LocalWeatherCharacteristics) {
        store.dispatch(
            CurrentWeatherScreenActions.SetCurrentWeather(
                mapWeatherDataTOSaveItInDatabase(localWeatherCharacteristics)
            )
        )
        fetchWeekBroadcast(localWeatherCharacteristics.lat, localWeatherCharacteristics.lon)
    }

    private fun mapWeatherDataTOSaveItInDatabase(localWeatherCharacteristics: LocalWeatherCharacteristics): CurrentWeatherResponse {
        return CurrentWeatherResponse(
            name = localWeatherCharacteristics.name,
            weather = arrayListOf(Weather(main = localWeatherCharacteristics.weatherStatus)),
            main = Main(
                tempMax = localWeatherCharacteristics.tempMax.toDouble(),
                tempMin = localWeatherCharacteristics.tempMin.toDouble(),
                temp = localWeatherCharacteristics.currentTemp.toDouble()
            )
        )
    }

    private fun fetchWeekBroadcast(lat: Double, lon: Double) {
        viewModelScope.launch {
            getWeekBoardCastBasedOnLocation(
                GetWeekBoardCastBasedOnLocation.Request(
                    lat,
                    lon
                )
            ).collect {
                it.onSuccess { response ->
                    store.dispatch(CurrentWeatherScreenActions.SetLoadingValue(false))
                    store.dispatch(
                        CurrentWeatherScreenActions.SetWeekBroadCastWeatherResponse(
                            response
                        )
                    )
                }
                it.onError { error -> handleError(error) }
            }
        }
    }

    private fun handleError(error: AppError) {
        store.dispatch(CurrentWeatherScreenActions.SetLoadingValue(false))
        store.dispatch(CurrentWeatherScreenActions.ShowError(error.toString()))
    }
}
