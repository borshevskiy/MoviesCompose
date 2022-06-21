package com.borshevskiy.moviescompose.di

import com.borshevskiy.moviescompose.data.network.ApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    fun baseUrl() = "https://api.tvmaze.com/"

    @Singleton
    @Provides
    fun provideRetrofitInstance(baseUrl : String): ApiService =
        Retrofit.Builder().baseUrl(baseUrl).addConverterFactory(GsonConverterFactory.create())
            .build().create(ApiService::class.java)

}