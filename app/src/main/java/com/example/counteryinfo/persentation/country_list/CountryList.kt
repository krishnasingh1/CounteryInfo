package com.example.counteryinfo.persentation.country_list

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.counteryinfo.domail.model.Country

@Composable
fun CountryListScreen(viewModel: CountryListViewModel = hiltViewModel()) {

    val res = viewModel.list.value

    if (res.isLoading) {
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            CircularProgressIndicator()
        }
    }
    if (res.error.isNotBlank()) {
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            Text(text = res.error.toString())
        }
    }
    res.data?.let {
        
        LazyColumn {
            items(it) {
                CountryListItem(country = it) {

                }
                
            }
        }
    }
    
}

@Composable
fun CountryListItem( country: Country, onClick : (String) -> Unit) {
    
    Card(modifier = Modifier
        .padding(8.dp)
        .clickable {
            onClick.invoke(country.name)
        },
        shape = RoundedCornerShape(4.dp)) {

        Text(
            text = country.name,
            modifier = Modifier.padding(8.dp),
            style = TextStyle(color = Color.Black, fontSize = 18.sp)
        )
        
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    Column {
        CountryListScreen()
    }
}