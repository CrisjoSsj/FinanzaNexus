package com.example.finanzasnexus.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.finanzasnexus.ui.screens.auth.LoginScreen
import com.example.finanzasnexus.ui.screens.auth.RegisterScreen
import com.example.finanzasnexus.ui.screens.auth.WelcomeScreen
import com.example.finanzasnexus.ui.screens.goals.GoalsScreen
import com.example.finanzasnexus.ui.screens.history.HistoryScreen
import com.example.finanzasnexus.ui.screens.home.HomeScreen
import com.example.finanzasnexus.ui.screens.obligations.ObligationsScreen
import com.example.finanzasnexus.ui.screens.settings.SettingsScreen

@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "welcome"
    ) {
        composable("welcome") {
            WelcomeScreen(
                onNavigateToLogin = { navController.navigate("login") },
                onNavigateToRegister = { navController.navigate("register") }
            )
        }

        composable("login") {
            LoginScreen(
                onLoginSuccess = {
                    navController.navigate("home") {
                        popUpTo("welcome") { inclusive = true }
                    }
                },
                onNavigateToRegister = { navController.navigate("register") }
            )
        }

        composable("register") {
            RegisterScreen(
                onRegisterSuccess = {
                    navController.navigate("home") {
                        popUpTo("welcome") { inclusive = true }
                    }
                },
                onNavigateToLogin = { navController.navigate("login") }
            )
        }

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

        composable("history") {
            HistoryScreen(
                currentRoute = "history",
                onNavigate = { route ->
                    navController.navigate(route) {
                        launchSingleTop = true
                    }
                }
            )
        }

        composable("settings") {
            SettingsScreen(
                currentRoute = "settings",
                onNavigate = { route ->
                    navController.navigate(route) {
                        launchSingleTop = true
                    }
                }
            )
        }
    }
}