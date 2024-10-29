package com.developerx.city_ui.city_ui_states

import com.developerx.base.mvi.State
import com.developerx.models.dto.City

data class CitiesScreenStates(
    val isLoading: Boolean = false,
    val errorMessage: String = "",
    val selectedCity: City? = null,
    val searchCityValue: String ="",
    var cities: ArrayList<City> = arrayListOf()
) : State
