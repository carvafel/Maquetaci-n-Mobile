package com.example.maquetacionmobile

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.maquetacionmobile.navigation.AppNavGraph
import com.example.maquetacionmobile.ui.theme.AppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppTheme {
                AppNavGraph()
            }
        }
    }
}
