package com.example.maquetacionmobile.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.maquetacionmobile.feature.home.HomeScreen
import com.example.maquetacionmobile.feature.alarm.AlarmConfigScreen
import com.example.maquetacionmobile.feature.login.LoginScreen
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
        composable(AppDestination.Home.route) { HomeScreen() }
        composable(AppDestination.AlarmConfig.route) { AlarmConfigScreen() }
    }
}

