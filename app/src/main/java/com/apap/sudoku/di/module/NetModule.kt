package com.apap.sudoku.di.module

import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
class NetModule {

    private val okHttpClient: OkHttpClient = OkHttpClient()
    private val baseUrl = "https://sugoku.herokuapp.com"

    @Provides
    @Singleton
    fun provideOkHttpClient() : OkHttpClient {
        return okHttpClient
    }

    @Provides
    @Singleton
    fun provideRetrofit(okHttpClient: OkHttpClient) : Retrofit {
        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .client(okHttpClient)
            .build()
    }
}