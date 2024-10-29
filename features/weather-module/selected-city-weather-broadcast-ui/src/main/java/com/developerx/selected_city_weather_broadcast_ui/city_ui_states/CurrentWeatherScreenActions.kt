package com.developerx.selected_city_weather_broadcast_ui.city_ui_states

import com.developerx.base.mvi.Action
import com.developerx.models.dto.City
import com.developerx.models.dto.CurrentWeatherResponse
import com.developerx.models.dto.WeekBroadCastWeatherResponse

sealed class CurrentWeatherScreenActions: Action {
    data class  SetLoadingValue(
        val loadingValue: Boolean,
    ) : CurrentWeatherScreenActions()

    data class ShowError(
        val message: String,
    ) : CurrentWeatherScreenActions()

    data class SetWeekBroadCastWeatherResponse(
        val weekBroadCastWeatherResponse: WeekBroadCastWeatherResponse,
    ) : CurrentWeatherScreenActions()


    data class SetCurrentWeather(
        val currentWeatherData: CurrentWeatherResponse,
    ) : CurrentWeatherScreenActions()

    object InvalidateError : CurrentWeatherScreenActions()
}
