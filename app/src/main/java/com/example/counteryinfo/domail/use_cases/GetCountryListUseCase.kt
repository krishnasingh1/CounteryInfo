package com.example.counteryinfo.domail.use_cases

import com.example.counteryinfo.common.Resource
import com.example.counteryinfo.domail.model.Country
import com.example.counteryinfo.domail.repository.CountryRepo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class GetCountryListUseCase(private val countryRepo : CountryRepo) {

    operator fun invoke() : Flow<Resource<List<Country>>> = flow {
        emit(Resource.Loading())
        try{
            emit(Resource.Success(data = countryRepo.getCountryList()))
        }catch (e:java.lang.Exception){
            emit(Resource.Error(message = e.message.toString()))
        }
    }.flowOn(Dispatchers.IO )
}