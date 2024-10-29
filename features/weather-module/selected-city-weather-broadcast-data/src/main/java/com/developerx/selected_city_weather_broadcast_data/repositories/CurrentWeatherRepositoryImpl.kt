package com.developerx.selected_city_weather_broadcast_data.repositories

import com.developerx.core.common.ResultOf
import com.developerx.models.dto.CurrentWeatherResponse
import com.developerx.models.dto.WeekBroadCastWeatherResponse
import com.developerx.selected_city_weather_broadcast_data.source.CurrentWeatherRemoteDataSourceImpl
import com.developerx.selected_city_weather_broadcast_domain.repository.CurrentWeatherRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

class CurrentWeatherRepositoryImpl @Inject constructor(
    private val citiesRemoteDataSourceImpl: CurrentWeatherRemoteDataSourceImpl,
) : CurrentWeatherRepository {

    override suspend fun provideCurrentWeatherBasedOnLocation(
        lat: Double,
        lon: Double
    ): Flow<ResultOf<CurrentWeatherResponse>> {
        return citiesRemoteDataSourceImpl.fetchCurrentWeather(lat, lon).onEach { }
    }

    override suspend fun provideWeekBoardCastBasedOnLocation(
        lat: Double,
        lon: Double
    ): Flow<ResultOf<WeekBroadCastWeatherResponse>> {
        return citiesRemoteDataSourceImpl.fetchWeekBoardCast(lat, lon).onEach { }
    }
}
