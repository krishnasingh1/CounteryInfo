package com.example.counteryinfo.domail.repository

import com.example.counteryinfo.domail.model.Country
import com.example.counteryinfo.domail.model.CountryDetails

interface CountryRepo {

    suspend fun getCountryList() : List<Country>
    suspend fun getCountryDetails(countryName : String) : CountryDetails
}