package com.example.counteryinfo.persentation.country_details

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.counteryinfo.common.Resource
import com.example.counteryinfo.domail.use_cases.GetCountryDetailsUseCase
import com.example.counteryinfo.persentation.country_list.CountryListState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class CountryDetailsViewModel @Inject constructor(
    private val getCountryDetailsUseCase: GetCountryDetailsUseCase,
    savedStateHandle: SavedStateHandle)
    : ViewModel() {

        private val _countryDetails = mutableStateOf(CountryDetailsState())
        val countryDetails : State<CountryDetailsState> = _countryDetails

        init {
            savedStateHandle.getLiveData<String>("country_name").value?.let {
                getCountryDetails(it)
            }
        }

        fun getCountryDetails(countryName : String) {
            getCountryDetailsUseCase(countryName = countryName).onEach {

                when(it) {
                    is Resource.Loading -> {
                        _countryDetails.value = CountryDetailsState(isLoading = true)
                    }
                    is Resource.Success -> {
                        _countryDetails.value= CountryDetailsState(data = it.data)
                    }
                    is Resource.Error -> {
                        _countryDetails.value = CountryDetailsState(error = it.message.toString())
                    }
                }
            }.launchIn(viewModelScope)
        }


}