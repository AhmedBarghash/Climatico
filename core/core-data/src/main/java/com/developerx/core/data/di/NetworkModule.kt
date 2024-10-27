package com.developerx.core.data.di

import android.content.Context
import com.chuckerteam.chucker.api.ChuckerCollector
import com.chuckerteam.chucker.api.ChuckerInterceptor
import com.developerx.core.data.BuildConfig
import com.developerx.core.data.interceptors.GSONHamad
import com.developerx.core.data.interceptors.HeadersInterceptor
import com.developerx.core.data.utils.AndroidLogger
import com.google.gson.Gson
import com.moczul.ok2curl.CommandComponent
import com.moczul.ok2curl.Configuration
import com.moczul.ok2curl.CurlInterceptor
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

private const val TIME_OUT = 4L
private const val CHUCKER_MAX_CONTENT = 250000L



@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {

    /**
     * provide HttploggingInterceptor
     */
    @Provides
    @Singleton
    fun provideHttpLoggingInterceptor(): HttpLoggingInterceptor {
        return HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }
    }

    @Provides
    @Singleton
    fun provideCurlInterceptor(): CurlInterceptor {
        val components = listOf(
            CommandComponent.Curl,
            CommandComponent.Method,
            CommandComponent.Url,
            CommandComponent.Body,
            CommandComponent.Header,
            CommandComponent.Flags
        )
        val configuration = Configuration(components = components)
        return CurlInterceptor(AndroidLogger(), configuration)
    }

    /**
     * provide OkHttpClient
     */
    @Provides
    fun provideOkHttpClient(
        loggingInterceptor: HttpLoggingInterceptor,
        chuckerInterceptor: ChuckerInterceptor,
        ok2CurlInterceptor: CurlInterceptor,
        headersInterceptor: HeadersInterceptor
    ): OkHttpClient {
        return OkHttpClient.Builder().apply {
            addInterceptor(headersInterceptor)
            if (BuildConfig.DEBUG) {
                addInterceptor(chuckerInterceptor)
                addInterceptor(loggingInterceptor)
                addInterceptor(ok2CurlInterceptor)
            }
            connectTimeout(TIME_OUT, TimeUnit.MINUTES)
            readTimeout(TIME_OUT, TimeUnit.MINUTES)
            writeTimeout(TIME_OUT, TimeUnit.MINUTES)
            retryOnConnectionFailure(true)
        }.build()
    }

    @Provides
    @Singleton
    fun provideGson() = GSONHamad.create()

    /**
     * provide retrofit
     */
    @Provides
    @Singleton
    fun provideRetrofitForAws(
        gson: Gson,
        okHttpClient: OkHttpClient
    ): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BuildConfig.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .client(okHttpClient)
            .build()
    }

    /**
     * provide chucker interceptor
     */

    @Provides
    @Singleton
    fun provideChuckerInterceptor(@ApplicationContext context: Context): ChuckerInterceptor {
        return ChuckerInterceptor.Builder(context)
            .collector(ChuckerCollector(context))
            .maxContentLength(CHUCKER_MAX_CONTENT)
            .redactHeaders(emptySet())
            .alwaysReadResponseBody(false)
            .build()
    }
}
