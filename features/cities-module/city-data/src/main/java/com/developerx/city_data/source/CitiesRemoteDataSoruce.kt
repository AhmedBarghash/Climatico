package com.developerx.city_data.source

import com.developerx.city_data.api.CitiesApi
import com.developerx.core.common.ResultOf
import com.developerx.core.data.extensions.toFlow
import com.developerx.models.dto.CitiesResponse
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

interface CitiesRemoteDataSource {
    suspend fun fetchAllCitiesInfo(): Flow<ResultOf<CitiesResponse>>
}

class CitiesRemoteDataSourceImpl @Inject constructor(
    private val api: CitiesApi
) : CitiesRemoteDataSource {
    override suspend fun fetchAllCitiesInfo(): Flow<ResultOf<CitiesResponse>> {
        return api.fetchCitiesApi().toFlow()
    }
}
