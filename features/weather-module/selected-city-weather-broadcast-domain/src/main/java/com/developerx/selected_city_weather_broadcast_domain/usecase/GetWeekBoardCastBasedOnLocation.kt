package com.developerx.selected_city_weather_broadcast_domain.usecase

import com.developerx.core.common.ResultOf
import com.developerx.core.domain.FlowUseCase
import com.developerx.models.dto.WeekBroadCastWeatherResponse
import com.developerx.selected_city_weather_broadcast_domain.repository.CurrentWeatherRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetWeekBoardCastBasedOnLocation @Inject constructor(
    private val currentWeatherRepository: CurrentWeatherRepository,
) : FlowUseCase<ResultOf<WeekBroadCastWeatherResponse>, GetWeekBoardCastBasedOnLocation.Request>() {

    override suspend fun run(params: Request): Flow<ResultOf<WeekBroadCastWeatherResponse>> {
        return currentWeatherRepository.provideWeekBoardCastBasedOnLocation(
            params.latitude, params.longitude
        )
    }

    data class Request(val latitude: Double, val longitude: Double)
}
