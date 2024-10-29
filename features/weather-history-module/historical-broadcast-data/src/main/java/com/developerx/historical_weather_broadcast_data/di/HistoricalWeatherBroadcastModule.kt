package com.developerx.historical_weather_broadcast_data.di

import android.content.Context
import androidx.room.Room
import com.developerx.historical_broadcast_domain.repositories.HistoricalWeatherBroadcastRepository
import com.developerx.historical_weather_broadcast_data.repositories.HistoricalWeatherBroadcastRepositoryImpl
import com.developerx.historical_weather_broadcast_data.soruce.HistoricalWeatherBroadcastDao
import com.developerx.historical_weather_broadcast_data.soruce.WeatherDataBase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object HistoricalWeatherBroadcastModule {

    @Provides
    @Singleton
    fun provideAppDatabase(@ApplicationContext appContext: Context): WeatherDataBase {
        return Room.databaseBuilder(
            appContext,
            WeatherDataBase::class.java,
            "weather_history_database")
//            .allowMainThreadQueries()
            .fallbackToDestructiveMigration()
            .build()
    }

    @Provides
    fun provideChannelDao(weatherDataBase: WeatherDataBase): HistoricalWeatherBroadcastDao {
        return weatherDataBase.channelDao()
    }

    @Singleton
    @Provides
    fun provideHistoricalWeatherBroadcastRepository(
        remote: HistoricalWeatherBroadcastDao,
    ): HistoricalWeatherBroadcastRepository {
        return HistoricalWeatherBroadcastRepositoryImpl(remote)
    }
}
