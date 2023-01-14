package com.example.counteryinfo.data.repository

import com.example.counteryinfo.common.toDomain
import com.example.counteryinfo.data.network.ApiService
import com.example.counteryinfo.domail.model.Country
import com.example.counteryinfo.domail.model.CountryDetails
import com.example.counteryinfo.domail.repository.CountryRepo

class CountryRepoImpl(private val apiService: ApiService) : CountryRepo {

    override suspend fun getCountryList(): List<Country> {
        return apiService.getCountryList().map { it.toDomain() }
    }

    override suspend fun getCountryDetails(countryName: String): CountryDetails {
        return apiService.getCountryDetails(countryName = countryName).toDomain()
    }

}