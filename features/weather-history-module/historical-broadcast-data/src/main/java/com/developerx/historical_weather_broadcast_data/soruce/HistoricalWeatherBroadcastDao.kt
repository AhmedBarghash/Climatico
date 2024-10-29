package com.developerx.historical_weather_broadcast_data.soruce

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.developerx.models.LocalWeatherCharacteristics

@Dao
interface HistoricalWeatherBroadcastDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(localWeatherCharacteristics: LocalWeatherCharacteristics): Long

    @Query("SELECT * FROM weather_history_Characteristics ORDER BY cityId DESC LIMIT 1")
    suspend fun getWeatherHistory(): LocalWeatherCharacteristics
}
