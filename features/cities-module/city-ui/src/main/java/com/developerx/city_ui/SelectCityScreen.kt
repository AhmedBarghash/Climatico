package com.developerx.city_ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.developerx.models.dto.City


@Composable
fun SelectCityScreenContent(
    citiesViewModel: CitiesViewModel = hiltViewModel(),
    navigateToCurrentWeatherView: (selectedCity: City) -> Unit,
) {
    LaunchedEffect(Unit) {
        citiesViewModel.loadCities()
    }

    val citiesStates by citiesViewModel.state.collectAsStateWithLifecycle()

    if (citiesStates.cities.isEmpty().not()) {
        FilterableDropdownMenu(citiesStates.cities, onItemClicked = {
            citiesViewModel.setSelectedCity(it)
        }) {
            //  citiesViewModel.setSelectedCity(it)
        }
    }

    if (citiesStates.selectedCity != null) {
        navigateToCurrentWeatherView(citiesStates.selectedCity!!)
    }
}

@Composable
fun FilterableDropdownMenu(
    cities: ArrayList<City>,
    onItemClicked: (item: City) -> Unit,
    onSearchValueChange: (value: String) -> Unit
) {
    var expanded by remember { mutableStateOf(false) }
    var textState by remember { mutableStateOf(TextFieldValue()) }
    val filteredItems = cities.filter {
        it.cityNameEn!!.contains(textState.text, ignoreCase = true)
    }

    Column {
        OutlinedTextField(
            value = textState,
            onValueChange = {
                textState = it
                onSearchValueChange(it.text)
                expanded = true
            },
            label = { Text("Search") },
            modifier = Modifier.fillMaxWidth(),
            keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Done),
            trailingIcon = {
                IconButton(onClick = { expanded = !expanded }) {
                    Icon(Icons.Default.ArrowDropDown, contentDescription = "Dropdown")
                }
            }
        )

        DropdownMenu(
            modifier = Modifier.fillMaxWidth(),
            expanded = expanded,
            onDismissRequest = { expanded = false }
        ) {
            if (filteredItems.isEmpty()) {
                DropdownMenuItem(
                    onClick = { expanded = false },
                    modifier = Modifier.fillMaxWidth(),
                    text = { Text("No results found") }
                )
            } else {
                filteredItems.forEach { item ->
                    DropdownMenuItem(
                        onClick = {
                            onItemClicked(item)
                            expanded = false
                        },
                        modifier = Modifier.fillMaxWidth(),
                        text = { item.cityNameEn?.let { Text(it) } }
                    )
                }
            }
        }
    }
}

@Preview
@Composable
fun SelectCityViewPreview() {
    SelectCityScreenContent(
        navigateToCurrentWeatherView = {})
}
