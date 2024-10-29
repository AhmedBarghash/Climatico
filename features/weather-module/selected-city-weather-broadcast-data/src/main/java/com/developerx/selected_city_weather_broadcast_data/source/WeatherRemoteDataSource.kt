package com.developerx.selected_city_weather_broadcast_data.source

import com.developerx.core.common.ResultOf
import com.developerx.core.data.BuildConfig
import com.developerx.core.data.extensions.toFlow
import com.developerx.models.dto.CurrentWeatherResponse
import com.developerx.models.dto.WeekBroadCastWeatherResponse
import com.developerx.selected_city_weather_broadcast_data.api.WeatherInterface
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

interface CurrentWeatherRemoteDataSource {
    suspend fun fetchCurrentWeather(
        lat: Double,
        lon: Double
    ): Flow<ResultOf<CurrentWeatherResponse>>

    suspend fun fetchWeekBoardCast(
        lat: Double,
        lon: Double
    ): Flow<ResultOf<WeekBroadCastWeatherResponse>>
}

class CurrentWeatherRemoteDataSourceImpl @Inject constructor(
    private val api: WeatherInterface
) : CurrentWeatherRemoteDataSource {
    override suspend fun fetchCurrentWeather(
        lat: Double,
        lon: Double
    ): Flow<ResultOf<CurrentWeatherResponse>> {
        return api.getCurrentWeather(lat, lon, "metric",BuildConfig.APP_KEY).toFlow()
    }

    override suspend fun fetchWeekBoardCast(
        lat: Double,
        lon: Double
    ): Flow<ResultOf<WeekBroadCastWeatherResponse>> {
        return api.getWeekBroadCastWeather(lat, lon,"metric",BuildConfig.APP_KEY).toFlow()
    }
}
