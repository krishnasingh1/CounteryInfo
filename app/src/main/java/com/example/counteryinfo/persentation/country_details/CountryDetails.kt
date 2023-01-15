package com.example.counteryinfo.persentation.country_details

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.counteryinfo.persentation.country_details.compoents.*

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun CountryDetails(countryName : String, viewModel : CountryDetailsViewModel = hiltViewModel()) {

    Scaffold(topBar = { TopAppBar(title = { Text(text = countryName)}) }) {

        val res = viewModel.countryDetails.value

        if (res.isLoading) {
            Box(
                modifier = Modifier
                    .fillMaxSize(),
                contentAlignment = Alignment.Center){

                CircularProgressIndicator()
            }
        }
        if (res.error.isNotBlank()){
            Box(
                modifier = Modifier
                    .fillMaxSize(),
                contentAlignment = Alignment.Center){

                Text(text = res.error)
            }
        }
        res.data?.let {
            Column(modifier = Modifier.verticalScroll(rememberScrollState())) {
                CountryHeader(it)
                LanguageComp(it.language)
                VaccinationComp(it.vaccinations)
                CurrencyComp(it.currency)
                NeighbourComp(it.neighbors)

                
            }
        }
    }
    
}