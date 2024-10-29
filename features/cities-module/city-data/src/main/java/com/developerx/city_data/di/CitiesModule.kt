package com.developerx.city_data.di

import com.developerx.city_data.api.CitiesApi
import com.developerx.city_data.repositories.CitiesRepositoryImp
import com.developerx.city_data.source.CitiesRemoteDataSource
import com.developerx.city_data.source.CitiesRemoteDataSourceImpl
import com.developerx.city_domain.repository.CitiesRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object CitiesModule {

    @Provides
    @Singleton
    fun provideCitiesRemoteDataSource(api: CitiesApi): CitiesRemoteDataSource {
        return CitiesRemoteDataSourceImpl(api)
    }

    @Provides
    fun provideCitiesApi(
        retrofit: Retrofit,
    ): CitiesApi {
        return retrofit.create(CitiesApi::class.java)
    }

    @Singleton
    @Provides
    fun provideCitiesRepository(
        remote: CitiesRemoteDataSourceImpl,
    ): CitiesRepository {
        return CitiesRepositoryImp(remote)
    }
}
