package com.developerx.models.dto

import com.google.gson.annotations.SerializedName

data class City(

    @SerializedName("id") var id: Int,
    @SerializedName("cityNameAr") var cityNameAr: String,
    @SerializedName("cityNameEn") var cityNameEn: String,
    @SerializedName("lat") var lat: Double,
    @SerializedName("lon") var lon: Double

)
