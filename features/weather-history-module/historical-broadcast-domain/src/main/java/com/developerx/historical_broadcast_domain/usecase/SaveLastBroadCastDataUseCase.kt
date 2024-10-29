package com.developerx.historical_broadcast_domain.usecase

import com.developerx.historical_broadcast_domain.repositories.HistoricalWeatherBroadcastRepository
import com.developerx.models.LocalWeatherCharacteristics
import javax.inject.Inject

class SaveLastBroadCastDataUseCase @Inject constructor(private val currentWeatherRepository: HistoricalWeatherBroadcastRepository) {
    suspend operator fun invoke(params: Request): Long {
        return currentWeatherRepository.addNewHistoricalWeatherBroadcastRecord(params.weatherRecord)
    }

    data class Request(val weatherRecord: LocalWeatherCharacteristics)
}
