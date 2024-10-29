package com.developerx.historical_broadcast_ui

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.developerx.core.common.onError
import com.developerx.core.common.onSuccess
import com.developerx.historical_broadcast_domain.usecase.GetLastBroadcastDataUseCase
import com.developerx.historical_broadcast_domain.usecase.SaveLastBroadCastDataUseCase
import com.developerx.models.LocalWeatherCharacteristics
import com.developerx.models.dto.City
import com.developerx.models.dto.CurrentWeatherResponse
import com.developerx.historical_broadcast_domain.NoRequest
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HistoryBroadCastViewModel @Inject constructor(
    private val saveLastBroadCastDataUseCase: SaveLastBroadCastDataUseCase,
    private val getLastBroadcastDataUseCase: GetLastBroadcastDataUseCase,
) : ViewModel() {

    fun saveWeatherDataInDatabase(
        selectedCity: City,
        currentWeatherData: CurrentWeatherResponse,
    ) {
        viewModelScope.launch {
            val saveStatus = saveLastBroadCastDataUseCase(
                SaveLastBroadCastDataUseCase.Request(
                    mapWeatherDataTOSaveItInDatabase(
                        selectedCity,
                        currentWeatherData
                    )
                )
            )
            Log.i("Hello", saveStatus.toString())
        }
    }

    private fun mapWeatherDataTOSaveItInDatabase(
        selectedCity: City,
        currentWeatherData: CurrentWeatherResponse
    ): LocalWeatherCharacteristics {
        return LocalWeatherCharacteristics(
            cityId = selectedCity.id,
            cityNameAr = selectedCity.cityNameAr,
            cityNameEn = selectedCity.cityNameEn,
            lat = selectedCity.lat,
            lon = selectedCity.lon,

            name = currentWeatherData.name,
            weatherStatus = currentWeatherData.weather[0].main.toString(),
            currentTemp = currentWeatherData.main.temp.toString(),
            tempMax = currentWeatherData.main.tempMax.toString(),
            tempMin = currentWeatherData.main.tempMin.toString()
        )
    }

    fun loadLastedSearchedCityWeatherData(onLoadFinished: (response: LocalWeatherCharacteristics) -> Unit) {
        viewModelScope.launch {
            val response = getLastBroadcastDataUseCase()
            if (response != null) {
                onLoadFinished(response)
            }
        }
    }
}
