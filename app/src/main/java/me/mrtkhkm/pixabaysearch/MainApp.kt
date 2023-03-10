package me.mrtkhkm.pixabaysearch

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import me.mrtkhkm.detail_presentation.DetailsScreen
import me.mrtkhkm.pixabaysearch.navigation.Route
import me.mrtkhkm.search_presentation.SearchScreen

@Composable
fun MainApp() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = Route.SEARCH
    ) {
        composable(Route.SEARCH) {
            SearchScreen{
                navController.navigate(Route.DETAILS)
            }
        }
        composable(Route.DETAILS) {
            DetailsScreen()
        }
    }
}