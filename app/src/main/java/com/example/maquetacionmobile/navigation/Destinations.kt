package com.example.maquetacionmobile.navigation

sealed class AppDestination(val route: String, val label: String) {
    data object Login : AppDestination("login", "Login")
    data object Home : AppDestination("home", "Home")
    data object AlarmConfig : AppDestination("alarm_config", "Alarma")
    data object SignUp : AppDestination("signup", "Registro")
    data object Recover : AppDestination("recover", "Recuperar")
    companion object {
        val bottomBarItems = listOf(Home)
    }
}


