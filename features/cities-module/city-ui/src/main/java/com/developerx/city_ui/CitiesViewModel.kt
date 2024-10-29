package com.developerx.city_ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.developerx.base.mvi.Store
import com.developerx.city_domain.usecases.GetAllCitiesUseCases
import com.developerx.city_ui.city_ui_states.CitiesScreenActions
import com.developerx.city_ui.city_ui_states.CitiesScreenReducer
import com.developerx.city_ui.city_ui_states.CitiesScreenStates
import com.developerx.core.common.onError
import com.developerx.core.common.onSuccess
import com.developerx.models.dto.City
import com.developerx.models.dto.NoRequest
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CitiesViewModel @Inject constructor(
    private val getAllCitiesUseCases: GetAllCitiesUseCases,
) : ViewModel() {

    private val store = Store(
        initialState = CitiesScreenStates(),
        reducer = CitiesScreenReducer(),
    )

    val state: StateFlow<CitiesScreenStates> = store.state

    fun setSelectedCity(city: City) {
        store.dispatch(CitiesScreenActions.SetSelectedCity(city))
    }

    fun setSearchValueText(searchValueText: String) {
        store.dispatch(CitiesScreenActions.SearchCityValue(searchValueText))
    }

    fun loadCities() {
        viewModelScope.launch {
            store.dispatch(CitiesScreenActions.SetLoadingValue(true))
            getAllCitiesUseCases(NoRequest()).collect {
                it.onSuccess { response ->
                    store.dispatch(CitiesScreenActions.SetLoadingValue(false))
                    // load the cities
                    store.dispatch(CitiesScreenActions.SetCitiesList(response.cities))
                }
                it.onError { error ->
                    store.dispatch(CitiesScreenActions.ShowError(error.toString()))
                }
            }
        }
    }
}
