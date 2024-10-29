package com.developerx.city_domain.repository


import com.developerx.core.common.ResultOf
import com.developerx.models.dto.CitiesResponse
import kotlinx.coroutines.flow.Flow

interface CitiesRepository {
    suspend fun provideAllCitiesData(): Flow<ResultOf<CitiesResponse>>
}
