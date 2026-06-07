package com.example.finanzasnexus.ui.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ReceiptLong
import androidx.compose.material.icons.filled.AccountBalanceWallet
import androidx.compose.material.icons.filled.Flag
import androidx.compose.material.icons.filled.Schedule
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

@Composable
fun AppBottomBar(
    currentRoute: String,
    onNavigate: (String) -> Unit
) {
    val background = Color(0xFF080D12)
    val selectedColor = Color(0xFF35C8FF)
    val unselectedColor = Color(0xFF8D96A8)

    NavigationBar(containerColor = background) {

        NavigationBarItem(
            selected = currentRoute == "home",
            onClick = { onNavigate("home") },
            icon = { Icon(Icons.Default.AccountBalanceWallet, null) },
            label = { Text("Inicio") },
            colors = colors(selectedColor, unselectedColor, background)
        )

        NavigationBarItem(
            selected = currentRoute == "obligations",
            onClick = { onNavigate("obligations") },
            icon = { Icon(Icons.AutoMirrored.Filled.ReceiptLong, null) },
            label = { Text("Obligaciones") },
            colors = colors(selectedColor, unselectedColor, background)
        )

        NavigationBarItem(
            selected = currentRoute == "history",
            onClick = { onNavigate("history") },
            icon = { Icon(Icons.Default.Schedule, null) },
            label = { Text("Historial") },
            colors = colors(selectedColor, unselectedColor, background)
        )

        NavigationBarItem(
            selected = currentRoute == "goals",
            onClick = { onNavigate("goals") },
            icon = { Icon(Icons.Default.Flag, null) },
            label = { Text("Metas") },
            colors = colors(selectedColor, unselectedColor, background)
        )

        NavigationBarItem(
            selected = currentRoute == "settings",
            onClick = { onNavigate("settings") },
            icon = { Icon(Icons.Default.Settings, null) },
            label = { Text("Ajustes") },
            colors = colors(selectedColor, unselectedColor, background)
        )
    }
}

@Composable
private fun colors(
    selectedColor: Color,
    unselectedColor: Color,
    background: Color
) = NavigationBarItemDefaults.colors(
    selectedIconColor = selectedColor,
    selectedTextColor = selectedColor,
    unselectedIconColor = unselectedColor,
    unselectedTextColor = unselectedColor,
    indicatorColor = background
)