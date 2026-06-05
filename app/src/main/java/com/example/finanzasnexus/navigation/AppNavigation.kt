package com.example.finanzasnexus.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.finanzasnexus.ui.screens.goals.GoalsScreen
import com.example.finanzasnexus.ui.screens.home.HomeScreen
import com.example.finanzasnexus.ui.screens.obligations.ObligationsScreen

@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "home"
    ) {
        composable("home") {
            HomeScreen(
                currentRoute = "home",
                onNavigate = { route ->
                    navController.navigate(route) {
                        launchSingleTop = true
                    }
                }
            )
        }

        composable("goals") {
            GoalsScreen(
                currentRoute = "goals",
                onNavigate = { route ->
                    navController.navigate(route) {
                        launchSingleTop = true
                    }
                }
            )
        }

        composable("obligations") {
            ObligationsScreen(
                currentRoute = "obligations",
                onNavigate = { route ->
                    navController.navigate(route) {
                    launchSingleTop = true
                    }
                }
            )
        }
    }
}