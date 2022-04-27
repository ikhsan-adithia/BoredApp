package com.bored.app.di

import com.bored.app.feature_bored.data.remote.BoredApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object BoredModule {

    @Provides
    @Singleton
    fun provideBoredApi(): BoredApi =
        Retrofit.Builder()
            .baseUrl(BoredApi.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(BoredApi::class.java)
}