package com.example.maquetacionmobile.navigation

sealed class AppDestination(val route: String, val label: String) {
    data object Login : AppDestination("login", "Login")
    data object Home : AppDestination("home", "Home")
    data object AlarmConfig : AppDestination("alarm_config", "Alarma")
    data object AlarmRun : AppDestination("alarm_run", "En curso")
    data object AlarmWake : AppDestination("alarm_wake", "Despertar")
    data object RateExperience : AppDestination("rate_experience", "Calificar")
    data object Profile : AppDestination("profile", "Perfil")
    data object Settings : AppDestination("settings", "Ajustes")
    data object SettingsLanguage : AppDestination("settings_language", "Idioma")
    data object SettingsTheme : AppDestination("settings_theme", "Tema")
    data object AlarmSound : AppDestination("alarm_sound", "Sonido")
    data object AlarmVibration : AppDestination("alarm_vibration", "Vibración")
    data object SignUp : AppDestination("signup", "Registro")
    data object Recover : AppDestination("recover", "Recuperar")
    companion object {
        val bottomBarItems = listOf(Home)
    }
}


