package com.developerx.selected_city_weather_broadcast_ui.city_ui_states

import com.developerx.base.mvi.State
import com.developerx.models.dto.CurrentWeatherResponse
import com.developerx.models.dto.WeekBroadCastWeatherResponse

data class CurrentWeatherScreenStates(
    val isLoading: Boolean = false,
    val errorMessage: String = "",
    val currentWeatherData: CurrentWeatherResponse? = null,
    val weekBroadCastWeatherResponse: WeekBroadCastWeatherResponse? = null,
) : State
