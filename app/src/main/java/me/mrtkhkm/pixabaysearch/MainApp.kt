package me.mrtkhkm.pixabaysearch

import android.net.Uri
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import me.mrtkhkm.detail_presentation.DetailsScreen
import me.mrtkhkm.pixabaysearch.navigation.NavArgument.IMAGE_DETAILS_ARG
import me.mrtkhkm.pixabaysearch.navigation.NavigationUtil
import me.mrtkhkm.pixabaysearch.navigation.Route
import me.mrtkhkm.search_presentation.SearchScreen

@Composable
fun MainApp() {
    val navController = rememberNavController()
    val navigationUtil = NavigationUtil()
    Scaffold {
        NavHost(
            navController = navController,
            startDestination = Route.SEARCH
        ) {
            composable(Route.SEARCH) {
                SearchScreen {
                    val hitJson = Uri.encode(navigationUtil.toJson(it))
                    navController.navigate(Route.DETAILS.replace("{$IMAGE_DETAILS_ARG}", hitJson))
                }
            }
            composable(
                Route.DETAILS,
                arguments = listOf(
                    navArgument(IMAGE_DETAILS_ARG) {
                        type = NavType.StringType
                    }
                )
            ) {
                val arg = it.arguments?.getString(IMAGE_DETAILS_ARG)!!
                DetailsScreen(navigationUtil.fromJson(arg))
            }
        }
    }
}