package com.developerx.historical_broadcast_domain.usecase

import com.developerx.historical_broadcast_domain.repositories.HistoricalWeatherBroadcastRepository
import com.developerx.models.LocalWeatherCharacteristics
import javax.inject.Inject

class GetLastBroadcastDataUseCase @Inject constructor(
    private val currentWeatherRepository: HistoricalWeatherBroadcastRepository,
) {
    suspend operator fun invoke(): LocalWeatherCharacteristics {
        return currentWeatherRepository.provideLastSavedWeatherBroadcastData()
    }
}
