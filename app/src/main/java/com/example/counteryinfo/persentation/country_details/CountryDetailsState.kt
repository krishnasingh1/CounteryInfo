package com.example.counteryinfo.persentation.country_details

import com.example.counteryinfo.domail.model.CountryDetails

data class CountryDetailsState(
    val isLoading : Boolean = false,
    val error : String = "",
    val data : CountryDetails? = null
)
