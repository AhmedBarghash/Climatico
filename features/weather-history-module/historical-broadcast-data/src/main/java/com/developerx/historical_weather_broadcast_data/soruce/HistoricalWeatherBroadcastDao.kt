package com.developerx.historical_weather_broadcast_data.soruce

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.developerx.models.WeatherCharacteristics
import io.reactivex.Observable

@Dao
interface HistoricalWeatherBroadcastDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(weatherCharacteristics: WeatherCharacteristics): Long

    @Query("SELECT * FROM weather_history_Characteristics")
    fun getWeatherHistory(): Observable<List<WeatherCharacteristics>>
}
