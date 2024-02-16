package com.mahmoudhamdyae.kutuku.core.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.mahmoudhamdyae.kutuku.auth.screen.LoginDestination
import com.mahmoudhamdyae.kutuku.auth.screen.LoginScreen
import com.mahmoudhamdyae.kutuku.onboarding.screens.OnboardingDestination
import com.mahmoudhamdyae.kutuku.onboarding.screens.OnboardingScreen

/**
 * Provides Navigation graph for the application.
 */
@Composable
fun MainScreen(
    navController: NavHostController = rememberNavController(),
) {

    val openScreen: (String) -> Unit = { route -> navController.navigate(route) { launchSingleTop = true} }
    val openAndClear: (String) -> Unit = { route -> navController.navigate(route) {
        launchSingleTop = true
        popUpTo(0) { inclusive = true }
    } }
    val openAndPopUp: (String, String) -> Unit = { route, popUp -> navController.navigate(route) {
        launchSingleTop = true
        popUpTo(popUp) { inclusive = true }
    } }
    val navigateUp = { navController.popBackStack() }

    NavHost(
        startDestination = OnboardingDestination.route,
        navController = navController
    ) {
        composable(OnboardingDestination.route) {
            OnboardingScreen(openAndClear = openAndClear)
        }

        composable(LoginDestination.route) {
            LoginScreen()
        }
    }
}