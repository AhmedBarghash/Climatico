package com.developerx.city_data.repositories

import com.developerx.city_data.source.CitiesRemoteDataSourceImpl
import com.developerx.city_domain.repository.CitiesRepository
import com.developerx.core.common.ResultOf
import com.developerx.models.dto.CitiesResponse
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

class CitiesRepositoryImp @Inject
constructor(
    private val citiesRemoteDataSourceImpl: CitiesRemoteDataSourceImpl,
) : CitiesRepository {
    override suspend fun provideAllCitiesData(): Flow<ResultOf<CitiesResponse>> {
        return citiesRemoteDataSourceImpl.fetchAllCitiesInfo().onEach { }
    }
}
