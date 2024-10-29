package com.developerx.historical_weather_broadcast_data.soruce

import androidx.room.Database
import androidx.room.RoomDatabase
import com.developerx.models.LocalWeatherCharacteristics

@Database(entities = [LocalWeatherCharacteristics::class], version = 1, exportSchema = false)
abstract class WeatherDataBase : RoomDatabase() {
    abstract fun channelDao(): HistoricalWeatherBroadcastDao
}
