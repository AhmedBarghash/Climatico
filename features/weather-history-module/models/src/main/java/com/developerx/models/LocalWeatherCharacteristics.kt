package com.developerx.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "weather_history_Characteristics")
data class LocalWeatherCharacteristics(
    @PrimaryKey(autoGenerate = false)
    var cityId: Int,
    // City Info
    var cityNameAr: String,
    var cityNameEn: String,
    var lat: Double,
    var lon: Double,

    // Current Weather Info
    var name: String,
    var weatherStatus: String,
    var currentTemp:String,
    var tempMax: String,
    var tempMin: String,
)
