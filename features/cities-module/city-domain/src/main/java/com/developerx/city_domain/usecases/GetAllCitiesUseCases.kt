package com.developerx.city_domain.usecases

import com.developerx.city_domain.repository.CitiesRepository
import com.developerx.core.common.ResultOf
import com.developerx.core.domain.FlowUseCase
import com.developerx.models.dto.CitiesResponse
import com.developerx.models.dto.NoRequest
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetAllCitiesUseCases @Inject constructor(
    private val citiesRepository: CitiesRepository,
) : FlowUseCase<ResultOf<CitiesResponse>, NoRequest>() {

    override suspend fun run(params: NoRequest): Flow<ResultOf<CitiesResponse>> {
        return citiesRepository.provideAllCitiesData()
    }
}
