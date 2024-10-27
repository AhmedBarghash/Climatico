package com.developerx.core.data.interceptors

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Provides
import javax.inject.Singleton


object GSONHamad{
    fun create(): Gson {
        return GsonBuilder()
            .setLenient()
            .serializeNulls() // to allow sending null values
            .create()
    }
}
