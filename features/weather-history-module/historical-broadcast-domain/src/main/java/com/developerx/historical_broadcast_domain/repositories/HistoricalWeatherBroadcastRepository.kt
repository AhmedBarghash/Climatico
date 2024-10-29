package com.developerx.historical_broadcast_domain.repositories

import com.developerx.models.LocalWeatherCharacteristics

interface HistoricalWeatherBroadcastRepository {
    suspend fun provideLastSavedWeatherBroadcastData(): LocalWeatherCharacteristics

    suspend fun addNewHistoricalWeatherBroadcastRecord(localWeatherCharacteristics: LocalWeatherCharacteristics): Long
}
