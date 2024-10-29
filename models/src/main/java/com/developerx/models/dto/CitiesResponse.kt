package com.developerx.models.dto

import com.google.gson.annotations.SerializedName

data class CitiesResponse(
    @SerializedName("cities") var cities: ArrayList<City> = arrayListOf()
)
