package com.developerx.selected_city_weather_broadcast_data.api

import com.developerx.models.dto.CurrentWeatherResponse
import com.developerx.models.dto.WeekBroadCastWeatherResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherInterface {

    @GET("weather")
    suspend fun getCurrentWeather(
        @Query("lat") lat: Double,
        @Query("lon") lon: Double,
        @Query("units") units: String,
        @Query("appid") appid: String
    ): Response<CurrentWeatherResponse>

    @GET("forecast")
    suspend fun getWeekBroadCastWeather(
        @Query("lat") lat: Double,
        @Query("lon") lon: Double,
        @Query("units") units: String,
        @Query("appid") appid: String
    ): Response<WeekBroadCastWeatherResponse>
}
