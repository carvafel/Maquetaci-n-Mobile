package com.example.maquetacionmobile.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.maquetacionmobile.feature.home.HomeScreen
import com.example.maquetacionmobile.feature.alarm.AlarmConfigScreen
import com.example.maquetacionmobile.feature.alarm.AlarmRunScreen
import com.example.maquetacionmobile.feature.alarm.AlarmSoundScreen
import com.example.maquetacionmobile.feature.alarm.AlarmVibrationScreen
import com.example.maquetacionmobile.feature.alarm.AlarmWakeScreen
import com.example.maquetacionmobile.feature.alarm.RateExperienceScreen
import com.example.maquetacionmobile.feature.login.LoginScreen
import com.example.maquetacionmobile.feature.profile.ProfileScreen
import com.example.maquetacionmobile.feature.settings.SettingsScreen
import com.example.maquetacionmobile.feature.settings.SettingsLanguageScreen
import com.example.maquetacionmobile.feature.settings.SettingsThemeScreen
import com.example.maquetacionmobile.feature.recover.RecoverPasswordScreen
import com.example.maquetacionmobile.feature.signup.SignUpScreen

@Composable
fun AppNavGraph(modifier: Modifier = Modifier) {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = AppDestination.Login.route,
        modifier = modifier
    ) {
        composable(AppDestination.Login.route) {
            LoginScreen(
                onLoginClick = { navController.navigate(AppDestination.Home.route) },
                onForgotPasswordClick = { navController.navigate(AppDestination.Recover.route) },
                onCreateAccountClick = { navController.navigate(AppDestination.SignUp.route) }
            )
        }
        composable(AppDestination.SignUp.route) {
            SignUpScreen(onCreateAccountClick = { navController.navigate(AppDestination.Home.route) })
        }
        composable(AppDestination.Recover.route) {
            RecoverPasswordScreen(onConfirmClick = { navController.navigate(AppDestination.Home.route) })
        }
        composable(AppDestination.Home.route) {
            HomeScreen(
                onConfigClick = { navController.navigate(AppDestination.AlarmConfig.route) },
                onAlarmClick = { navController.navigate(AppDestination.AlarmRun.route) },
                onProfileClick = { navController.navigate(AppDestination.Profile.route) },
                onBottomConfigClick = { navController.navigate(AppDestination.Settings.route) }
            )
        }
        composable(AppDestination.AlarmConfig.route) {
            AlarmConfigScreen(
                onSave = { navController.navigate(AppDestination.Home.route) },
                onCancel = { navController.navigate(AppDestination.Home.route) },
                onStartAlarm = { navController.navigate(AppDestination.AlarmRun.route) },
                onClickSound = { navController.navigate(AppDestination.AlarmSound.route) },
                onClickVibration = { navController.navigate(AppDestination.AlarmVibration.route) }
            )
        }
        composable(AppDestination.AlarmRun.route) {
            AlarmRunScreen(
                onPause = { },
                onStop = { navController.navigate(AppDestination.AlarmWake.route) }
            )
        }
        composable(AppDestination.AlarmWake.route) {
            AlarmWakeScreen(
                onRateClick = { navController.navigate(AppDestination.RateExperience.route) },
                onSnoozeClick = { navController.navigate(AppDestination.AlarmRun.route) },
                onStopClick = { navController.navigate(AppDestination.Home.route) }
            )
        }
        composable(AppDestination.RateExperience.route) {
            RateExperienceScreen(
                onSkip = { navController.navigate(AppDestination.Home.route) },
                onSave = { navController.navigate(AppDestination.Home.route) }
            )
        }
        composable(AppDestination.AlarmSound.route) {
            AlarmSoundScreen(
                onBack = { navController.navigate(AppDestination.AlarmConfig.route) },
                onConfigClick = { navController.navigate(AppDestination.Settings.route) },
                onAlarmClick = { navController.navigate(AppDestination.AlarmRun.route) },
                onHomeClick = { navController.navigate(AppDestination.Home.route) },
                onProfileClick = { navController.navigate(AppDestination.Profile.route) }
            )
        }
        composable(AppDestination.AlarmVibration.route) {
            AlarmVibrationScreen(
                onBack = { navController.navigate(AppDestination.AlarmConfig.route) },
                onConfigClick = { navController.navigate(AppDestination.Settings.route) },
                onAlarmClick = { navController.navigate(AppDestination.AlarmRun.route) },
                onHomeClick = { navController.navigate(AppDestination.Home.route) },
                onProfileClick = { navController.navigate(AppDestination.Profile.route) }
            )
        }
        composable(AppDestination.Profile.route) {
            ProfileScreen(
                onConfigClick = { navController.navigate(AppDestination.Settings.route) },
                onAlarmClick = { navController.navigate(AppDestination.AlarmRun.route) },
                onHomeClick = { navController.navigate(AppDestination.Home.route) },
                onProfileClick = { /* current */ }
            )
        }
        composable(AppDestination.Settings.route) {
            SettingsScreen(
                onLanguageClick = { navController.navigate(AppDestination.SettingsLanguage.route) },
                onThemeClick = { navController.navigate(AppDestination.SettingsTheme.route) },
                onConfigClick = { /* current */ },
                onAlarmClick = { navController.navigate(AppDestination.AlarmRun.route) },
                onHomeClick = { navController.navigate(AppDestination.Home.route) },
                onProfileClick = { navController.navigate(AppDestination.Profile.route) }
            )
        }
        composable(AppDestination.SettingsLanguage.route) {
            SettingsLanguageScreen(onBack = { navController.navigate(AppDestination.Settings.route) })
        }
        composable(AppDestination.SettingsTheme.route) {
            SettingsThemeScreen(onBack = { navController.navigate(AppDestination.Settings.route) })
        }
    }
}

