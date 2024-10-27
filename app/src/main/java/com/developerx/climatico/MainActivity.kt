package com.developerx.climatico

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.developerx.climatico.ui.theme.ClimaticoTheme
import androidx.compose.foundation.clickable
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import java.util.Locale

//AIzaSyBu3D7uxNnCkrSM0BJFXpq-duHsTWut96I
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ClimaticoTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    CountryList(innerPadding)
                }
            }
        }
    }
}

@Composable
fun CountryList(innerPadding: PaddingValues) {
    val searchText = rememberSaveable { mutableStateOf("") }
    val countries = remember { mutableStateOf(getCountries()) }
    var filteredCountries: ArrayList<String>

    Column(
        Modifier
            .fillMaxWidth()
            .padding(innerPadding)
    ) {
        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            value = searchText.value,
            onValueChange = {
                searchText.value = it
            },
            trailingIcon = {
                Icon(
                    Icons.Default.Clear,
                    contentDescription = "clear text",
                    modifier = Modifier
                        .clickable {
                            searchText.value = ""
                        }
                )
            }
        )
        LazyColumn(Modifier.padding(top = 8.dp)) {
            filteredCountries = if (searchText.value.isEmpty()) {
                countries.value
            } else {
                val resultList = ArrayList<String>()
                for (country in countries.value) {
                    if (country.lowercase(Locale.getDefault())
                            .contains(searchText.value.lowercase(Locale.getDefault()))
                    ) {
                        resultList.add(country)
                    }
                }
                resultList
            }
            items(filteredCountries, itemContent = { item ->
                Text(modifier = Modifier.padding(top = 6.dp), text = item)
                Divider(modifier = Modifier.padding(top = 6.dp))
            })
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ClimaticoTheme {
        val searchText = rememberSaveable { mutableStateOf("") }
        val countries = remember { mutableStateOf(getCountries()) }
        var filteredCountries: ArrayList<String>

        Column(
            Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                value = searchText.value,
                onValueChange = {
                    searchText.value = it
                },
                trailingIcon = {
                    Icon(
                        Icons.Default.Clear,
                        contentDescription = "clear text",
                        modifier = Modifier
                            .clickable {
                                searchText.value = ""
                            }
                    )
                }
            )
            LazyColumn(Modifier.padding(top = 8.dp)) {
                filteredCountries = if (searchText.value.isEmpty()) {
                    countries.value
                } else {
                    val resultList = ArrayList<String>()
                    for (country in countries.value) {
                        if (country.lowercase(Locale.getDefault())
                                .contains(searchText.value.lowercase(Locale.getDefault()))
                        ) {
                            resultList.add(country)
                        }
                    }
                    resultList
                }
                items(filteredCountries, itemContent = { item ->

                    Text(modifier = Modifier.padding(top = 6.dp), text = item)
                    Divider(modifier = Modifier.padding(top = 6.dp))
                })
            }
        }
    }
}

fun getCountries(): ArrayList<String> {
    val isoCountryCodes: Array<String> = Locale.getISOCountries()
    val countriesWithEmojis: ArrayList<String> = arrayListOf()
    for (countryCode in isoCountryCodes) {
        val locale = Locale("", countryCode)
        val countryName: String = locale.displayCountry
        val flagOffset = 0x1F1E6
        val asciiOffset = 0x41
        val firstChar = Character.codePointAt(countryCode, 0) - asciiOffset + flagOffset
        val secondChar = Character.codePointAt(countryCode, 1) - asciiOffset + flagOffset
        val flag =
            (String(Character.toChars(firstChar)) + String(Character.toChars(secondChar)))
        countriesWithEmojis.add("$countryName $flag")
    }
    return countriesWithEmojis
}
