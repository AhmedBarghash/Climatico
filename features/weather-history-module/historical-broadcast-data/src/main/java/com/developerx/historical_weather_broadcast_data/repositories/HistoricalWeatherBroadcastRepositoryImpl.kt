package com.developerx.historical_weather_broadcast_data.repositories

import com.developerx.core.common.ResultOf
import com.developerx.historical_broadcast_domain.repositories.HistoricalWeatherBroadcastRepository
import com.developerx.models.WeatherCharacteristics
import kotlinx.coroutines.flow.Flow

class HistoricalWeatherBroadcastRepositoryImpl : HistoricalWeatherBroadcastRepository {
    override suspend fun provideHistoricalWeatherBroadcastData(): Flow<ResultOf<WeatherCharacteristics>> {
        TODO("Not yet implemented")
    }

}
