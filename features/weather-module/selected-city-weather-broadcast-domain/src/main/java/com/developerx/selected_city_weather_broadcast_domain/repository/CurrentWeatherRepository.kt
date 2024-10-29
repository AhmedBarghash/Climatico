package com.developerx.selected_city_weather_broadcast_domain.repository

import com.developerx.core.common.ResultOf
import com.developerx.models.dto.CurrentWeatherResponse
import com.developerx.models.dto.WeekBroadCastWeatherResponse
import kotlinx.coroutines.flow.Flow

interface CurrentWeatherRepository {
    suspend fun provideCurrentWeatherBasedOnLocation(
        lat: Double,
        lon: Double
    ): Flow<ResultOf<CurrentWeatherResponse>>

    suspend fun provideWeekBoardCastBasedOnLocation(
        lat: Double,
        lon: Double
    ): Flow<ResultOf<WeekBroadCastWeatherResponse>>
}
