package com.developerx.selected_city_weather_broadcast_data.di

import com.developerx.selected_city_weather_broadcast_data.api.WeatherInterface
import com.developerx.selected_city_weather_broadcast_data.repositories.CurrentWeatherRepositoryImpl
import com.developerx.selected_city_weather_broadcast_data.source.CurrentWeatherRemoteDataSource
import com.developerx.selected_city_weather_broadcast_data.source.CurrentWeatherRemoteDataSourceImpl
import com.developerx.selected_city_weather_broadcast_domain.repository.CurrentWeatherRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object CurrentWeatherModule {

    @Provides
    @Singleton
    fun provideCurrentWeatherRemoteDataSource(api: WeatherInterface): CurrentWeatherRemoteDataSource {
        return CurrentWeatherRemoteDataSourceImpl(api)
    }

    @Provides
    fun provideWeatherApi(
        retrofit: Retrofit,
    ): WeatherInterface {
        return retrofit.create(WeatherInterface::class.java)
    }

    @Singleton
    @Provides
    fun provideCurrentWeatherRepository(
        remote: CurrentWeatherRemoteDataSourceImpl,
    ): CurrentWeatherRepository {
        return CurrentWeatherRepositoryImpl(remote)
    }
}
