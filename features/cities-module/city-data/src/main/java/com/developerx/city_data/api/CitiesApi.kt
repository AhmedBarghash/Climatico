package com.developerx.city_data.api

import com.developerx.models.dto.CitiesResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Url

interface CitiesApi {
    @GET
    suspend fun fetchCitiesApi(
        @Url url: String = "https://dev-orcas.s3.eu-west-1.amazonaws.com/uploads/cities.json",
    ): Response<CitiesResponse>
}
