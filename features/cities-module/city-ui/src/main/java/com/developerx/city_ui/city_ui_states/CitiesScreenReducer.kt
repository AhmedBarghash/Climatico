package com.developerx.city_ui.city_ui_states

import com.developerx.base.mvi.Reducer

class CitiesScreenReducer : Reducer<CitiesScreenStates, CitiesScreenActions> {
    override fun reduce(
        currentState: CitiesScreenStates,
        action: CitiesScreenActions
    ): CitiesScreenStates {
        return when (action) {
            CitiesScreenActions.InvalidateError -> invalidateErrorState(currentState)
            is CitiesScreenActions.SetLoadingValue -> updateLoadingStats(currentState, action)
            is CitiesScreenActions.ShowError -> errorState(currentState, action)
            is CitiesScreenActions.SetSelectedCity -> setSelectedCity(currentState, action)
            is CitiesScreenActions.SetCitiesList -> setCitiesList(currentState, action)
            is CitiesScreenActions.SearchCityValue -> updateSearchCityValue(currentState, action)
        }
    }

    private fun setSelectedCity(
        currentState: CitiesScreenStates,
        action: CitiesScreenActions.SetSelectedCity,
    ): CitiesScreenStates = currentState.copy(
        errorMessage = "",
        selectedCity = action.selectedCity,
    )

    private fun setCitiesList(
        currentState: CitiesScreenStates,
        action: CitiesScreenActions.SetCitiesList,
    ): CitiesScreenStates = currentState.copy(
        errorMessage = "",
        cities = action.citiesList,
    )


    private fun updateSearchCityValue(
        currentState: CitiesScreenStates,
        action: CitiesScreenActions.SearchCityValue,
    ): CitiesScreenStates = currentState.copy(
        errorMessage = "",
        searchCityValue = action.value,
    )

    private fun updateLoadingStats(
        currentState: CitiesScreenStates,
        action: CitiesScreenActions.SetLoadingValue,
    ): CitiesScreenStates = currentState.copy(
        errorMessage = "",
        isLoading = action.loadingValue,
    )

    private fun invalidateErrorState(currentState: CitiesScreenStates): CitiesScreenStates =
        currentState.copy(
            errorMessage = "",
        )

    private fun errorState(
        currentState: CitiesScreenStates,
        action: CitiesScreenActions.ShowError,
    ): CitiesScreenStates = currentState.copy(
        errorMessage = action.message,
    )
}
