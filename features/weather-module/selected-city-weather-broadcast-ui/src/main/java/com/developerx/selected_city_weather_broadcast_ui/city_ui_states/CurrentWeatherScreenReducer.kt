package com.developerx.selected_city_weather_broadcast_ui.city_ui_states

import com.developerx.base.mvi.Reducer

class CurrentWeatherScreenReducer : Reducer<CurrentWeatherScreenStates, CurrentWeatherScreenActions> {
    override fun reduce(
        currentState: CurrentWeatherScreenStates,
        action: CurrentWeatherScreenActions
    ): CurrentWeatherScreenStates {
        return when (action) {
            CurrentWeatherScreenActions.InvalidateError -> invalidateErrorState(currentState)
            is CurrentWeatherScreenActions.SetLoadingValue -> updateLoadingStats(currentState, action)
            is CurrentWeatherScreenActions.ShowError -> errorState(currentState, action)
            is CurrentWeatherScreenActions.SetCurrentWeather -> setSelectedCity(currentState, action)
            is CurrentWeatherScreenActions.SetWeekBroadCastWeatherResponse -> setWeekBroadCastWeatherResponse(currentState, action)
        }
    }

    private fun setSelectedCity(
        currentState: CurrentWeatherScreenStates,
        action: CurrentWeatherScreenActions.SetCurrentWeather,
    ): CurrentWeatherScreenStates = currentState.copy(
        errorMessage = "",
        currentWeatherData = action.currentWeatherData,
    )

    private fun setWeekBroadCastWeatherResponse(
        currentState: CurrentWeatherScreenStates,
        action: CurrentWeatherScreenActions.SetWeekBroadCastWeatherResponse,
    ): CurrentWeatherScreenStates = currentState.copy(
        errorMessage = "",
        weekBroadCastWeatherResponse = action.weekBroadCastWeatherResponse,
    )

    private fun updateLoadingStats(
        currentState: CurrentWeatherScreenStates,
        action: CurrentWeatherScreenActions.SetLoadingValue,
    ): CurrentWeatherScreenStates = currentState.copy(
        errorMessage = "",
        isLoading = action.loadingValue,
    )

    private fun invalidateErrorState(currentState: CurrentWeatherScreenStates): CurrentWeatherScreenStates =
        currentState.copy(
            errorMessage = "",
        )

    private fun errorState(
        currentState: CurrentWeatherScreenStates,
        action: CurrentWeatherScreenActions.ShowError,
    ): CurrentWeatherScreenStates = currentState.copy(
        errorMessage = action.message,
        isLoading = false,
    )
}
