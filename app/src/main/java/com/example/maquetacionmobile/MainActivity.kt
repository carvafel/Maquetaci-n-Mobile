package com.example.maquetacionmobile

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.maquetacionmobile.feature.login.LoginScreen
import com.example.maquetacionmobile.ui.theme.AppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppTheme {
                AppRoot()
            }
        }
    }
}

private enum class AppDestination(val route: String, val label: String) {
    Login("login", "Login"),
    Home("home", "Inicio"),
    Detail("detail", "Detalle"),
    Settings("settings", "Ajustes")
}

@Composable
private fun AppRoot() {
    val navController = rememberNavController()
    val items = listOf(
        AppDestination.Home,
        AppDestination.Detail,
        AppDestination.Settings
    )

    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route
    val showBottomBar = currentRoute != AppDestination.Login.route

    Scaffold(
        bottomBar = {
            if (showBottomBar) {
                NavigationBar {
                    items.forEach { destination ->
                        val icon = when (destination) {
                            AppDestination.Home -> Icons.Default.Home
                            AppDestination.Detail -> Icons.Default.Info
                            AppDestination.Settings -> Icons.Default.Settings
                            else -> Icons.Default.Home
                        }
                        NavigationBarItem(
                            selected = currentRoute == destination.route,
                            onClick = {
                                navController.navigate(destination.route) {
                                    popUpTo(navController.graph.findStartDestination().id) {
                                        saveState = true
                                    }
                                    launchSingleTop = true
                                    restoreState = true
                                }
                            },
                            icon = { Icon(icon, contentDescription = destination.label) },
                            label = { Text(destination.label) }
                        )
                    }
                }
            }
        }
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = AppDestination.Login.route,
            modifier = Modifier.padding(innerPadding)
        ) {
            composable(AppDestination.Login.route) {
                LoginScreen(
                    onLoginClick = {
                        navController.navigate(AppDestination.Home.route) {
                            popUpTo(AppDestination.Login.route) { inclusive = true }
                            launchSingleTop = true
                        }
                    },
                    onForgotPasswordClick = { },
                    onCreateAccountClick = { }
                )
            }
            composable(AppDestination.Home.route) { HomeScreen() }
            composable(AppDestination.Detail.route) { DetailScreen() }
            composable(AppDestination.Settings.route) { SettingsScreen() }
        }
    }
}

@Composable
private fun HomeScreen() {
    ScreenScaffold(title = "Inicio", body = "Contenido destacable y lista resumen")
}

@Composable
private fun DetailScreen() {
    ScreenScaffold(title = "Detalle", body = "Descripción extendida e información secundaria")
}

@Composable
private fun SettingsScreen() {
    ScreenScaffold(title = "Ajustes", body = "Preferencias de la app para UI/UX")
}

@Composable
private fun ScreenScaffold(title: String, body: String) {
    val elements = (1..10).map { "Elemento "+it }
    LazyColumn(
        modifier = Modifier
    ) {
        item { Text(text = title, style = androidx.compose.material3.MaterialTheme.typography.titleLarge) }
        item { Text(text = body, style = androidx.compose.material3.MaterialTheme.typography.bodyLarge) }
        items(elements) { label ->
            Text(text = label)
        }
    }
}
