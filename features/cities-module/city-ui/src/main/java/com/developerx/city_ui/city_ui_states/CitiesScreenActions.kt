package com.developerx.city_ui.city_ui_states

import android.net.Uri
import com.developerx.base.mvi.Action
import com.developerx.models.dto.City

sealed class CitiesScreenActions: Action {
    data class  SetLoadingValue(
        val loadingValue: Boolean,
    ) : CitiesScreenActions()

    data class ShowError(
        val message: String,
    ) : CitiesScreenActions()

    data class SearchCityValue(
        val value: String,
    ) : CitiesScreenActions()


    data class SetSelectedCity(
        val selectedCity: City,
    ) : CitiesScreenActions()

    data class SetCitiesList(
       val  citiesList : ArrayList<City>,
    ) : CitiesScreenActions()

    object InvalidateError : CitiesScreenActions()
}
