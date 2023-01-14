package com.example.counteryinfo.data.di

import com.example.counteryinfo.data.network.ApiService
import com.example.counteryinfo.data.repository.CountryRepoImpl
import com.example.counteryinfo.domail.repository.CountryRepo
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object DataModule {

    // this is for ApiService provide api Service is not be many time so create a @Singleton
    @Singleton
    @Provides
    fun provideApiService() : ApiService {
        return Retrofit.Builder().baseUrl("https://travelbriefing.org/")
            .addConverterFactory(GsonConverterFactory.create()).build()
            .create(ApiService::class.java)
    }

    @Provides
    fun provideCountryRepo(apiService: ApiService) : CountryRepo{
        return CountryRepoImpl(apiService)
    }
}