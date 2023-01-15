package com.example.counteryinfo.persentation.navigation

sealed class NavigationItem(val route : String) {

    object CountryListNavigationItem : NavigationItem("country_list")
    object CountryDetailsNavigationItem : NavigationItem(route = "country_detail/{country_name}")
}
