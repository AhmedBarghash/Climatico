package com.developerx.historical_weather_broadcast_data.repositories

import android.util.Log
import com.developerx.core.common.ResultOf
import com.developerx.historical_broadcast_domain.repositories.HistoricalWeatherBroadcastRepository
import com.developerx.historical_weather_broadcast_data.soruce.HistoricalWeatherBroadcastDao
import com.developerx.models.LocalWeatherCharacteristics
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

class HistoricalWeatherBroadcastRepositoryImpl
@Inject constructor(private val historicalWeatherBroadcastDao: HistoricalWeatherBroadcastDao) :
    HistoricalWeatherBroadcastRepository {
    override suspend fun provideLastSavedWeatherBroadcastData(): LocalWeatherCharacteristics {
        return historicalWeatherBroadcastDao.getWeatherHistory()
    }

    override suspend fun addNewHistoricalWeatherBroadcastRecord(localWeatherCharacteristics: LocalWeatherCharacteristics): Long {
        return historicalWeatherBroadcastDao.insert(localWeatherCharacteristics)
    }
}
