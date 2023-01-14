package com.example.counteryinfo.domail.di

import com.example.counteryinfo.domail.repository.CountryRepo
import com.example.counteryinfo.domail.use_cases.GetCountryDetailsUseCase
import com.example.counteryinfo.domail.use_cases.GetCountryListUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent


@InstallIn(SingletonComponent::class)
@Module
object DomainModule {

    @Provides
    fun provideGetCountryListUseCase(countryRepo: CountryRepo): GetCountryListUseCase {
        return GetCountryListUseCase(countryRepo = countryRepo)
    }

    @Provides
    fun provideGetCountryDetailsUseCase(countryRepo: CountryRepo): GetCountryDetailsUseCase{
        return GetCountryDetailsUseCase(countryRepo = countryRepo)
    }
}