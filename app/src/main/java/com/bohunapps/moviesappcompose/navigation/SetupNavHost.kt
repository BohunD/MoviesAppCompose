package com.bohunapps.moviesappcompose.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.bohunapps.moviesappcompose.Screens.DetailsScreen
import com.bohunapps.moviesappcompose.Screens.MainScreen
import com.bohunapps.moviesappcompose.Screens.SplashScreen
import com.bohunapps.moviesappcompose.utils.Constants

sealed class Destination(val route: String) {
    object Splash : Destination(Constants.Screens.SPLASH_SCREEN)
    object Main : Destination(Constants.Screens.MAIN_SCREEN)
    object Details : Destination(Constants.Screens.DETAILS_SCREEN)
}

@Composable
fun SetupNavHost(navController: NavHostController) {
    NavHost(navController = navController, startDestination = Destination.Splash.route) {
        composable(Destination.Splash.route){
            SplashScreen(navController)
        }
        composable(Destination.Main.route){
            MainScreen()
        }
        composable(Destination.Details.route){
            DetailsScreen()
        }
    }
}