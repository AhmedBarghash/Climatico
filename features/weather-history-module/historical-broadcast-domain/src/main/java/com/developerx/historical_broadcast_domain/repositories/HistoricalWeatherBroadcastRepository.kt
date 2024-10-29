package com.developerx.historical_broadcast_domain.repositories

import com.developerx.core.common.ResultOf
import kotlinx.coroutines.flow.Flow
import com.developerx.models.WeatherCharacteristics

interface HistoricalWeatherBroadcastRepository {
    suspend fun provideHistoricalWeatherBroadcastData(): Flow<ResultOf<WeatherCharacteristics>>
}
