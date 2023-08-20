package com.example.cleartripint.di

import com.example.cleartripint.data.ApiClient
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object GetRetrofit {


    @Provides
    @Singleton
    fun provideRetrofit():Retrofit{
        return Retrofit.Builder().baseUrl("https://fakestoreapi.com/").addConverterFactory(GsonConverterFactory.create()).build()
    }

    @Provides
    @Singleton
    fun getApiClient(retrofit: Retrofit): ApiClient {
        return retrofit.create(ApiClient::class.java)
    }
}