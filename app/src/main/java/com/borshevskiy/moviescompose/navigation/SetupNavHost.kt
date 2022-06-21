package com.borshevskiy.moviescompose.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.borshevskiy.moviescompose.MainViewModel
import com.borshevskiy.moviescompose.screens.DetailsScreen
import com.borshevskiy.moviescompose.screens.MainScreen
import com.borshevskiy.moviescompose.screens.SplashScreen
import com.borshevskiy.moviescompose.utils.Constants.Screens.DETAILS_SCREEN
import com.borshevskiy.moviescompose.utils.Constants.Screens.MAIN_SCREEN
import com.borshevskiy.moviescompose.utils.Constants.Screens.SPLASH_SCREEN

sealed class Screens(val route: String) {
    object Splash: Screens(SPLASH_SCREEN)
    object Main: Screens(MAIN_SCREEN)
    object Details: Screens(DETAILS_SCREEN)
}

@Composable
fun SetupNavHost(navController: NavHostController, viewModel: MainViewModel) {
    NavHost(navController = navController, startDestination = Screens.Splash.route) {
        composable(Screens.Splash.route) { SplashScreen(navController = navController, viewModel = viewModel) }
        composable(Screens.Main.route) { MainScreen(navController = navController, viewModel = viewModel) }
        composable(Screens.Details.route) { DetailsScreen(navController = navController, viewModel = viewModel) }
    }
}