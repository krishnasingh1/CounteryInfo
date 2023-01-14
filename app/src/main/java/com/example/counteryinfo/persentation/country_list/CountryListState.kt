package com.example.counteryinfo.persentation.country_list

import com.example.counteryinfo.domail.model.Country

data class CountryListState(
    val isLoading : Boolean=false,
    val error : String = "",
    val data : List<Country>?=null
)
