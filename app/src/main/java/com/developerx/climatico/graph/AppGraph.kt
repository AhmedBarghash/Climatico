//package com.developerx.climatico.graph
//
//import android.util.Log
//import androidx.compose.runtime.Composable
//import androidx.navigation.compose.NavHost
//import androidx.navigation.compose.composable
//import androidx.navigation.compose.rememberNavController
//import com.developerx.city_ui.CitiesViewModel
//import com.developerx.city_ui.SelectCityScreenContent
//
//@Composable
//fun AppGraph(
//    citiesViewModel: CitiesViewModel,
////    dataManager: DataManager,
//    onBackButtonClicked: () -> Unit,
//
//    ) {
//    val navController = rememberNavController()
//
//    NavHost(navController, startDestination = Route.Climatico.SEARCH_CITY_SCREEN) {
//        composable(Route.Climatico.SEARCH_CITY_SCREEN) {
//            SelectCityScreenContent(
////                navController,
//                citiesViewModel, onBackButtonClicked = {
//                onBackButtonClicked()
//            }, navigateToHistoryView = {}, navigateToCurrentWeatherView = {
//                Log.i("Hello","${it.cityNameEn}  ${it.lon} ${it.lat} ${it.cityNameAr}")
//                navController.navigate(Route.Climatico.CURRENT_WEATHER_SCREEN)
//            })
//        }
//
//        composable(Route.Climatico.EMPTY_SCREEN) {}
//
//        composable(Route.Climatico.CURRENT_WEATHER_SCREEN) {}
//    }
//}
