package com.example.maquetacionmobile.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Description
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.Schedule
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp

@Composable
fun HomeBottomBar(modifier: Modifier = Modifier) {
    Surface(modifier = modifier.fillMaxWidth(), color = Color(0xFFF6E6E7)) {
        Column(modifier = Modifier.fillMaxWidth()) {
            Divider(color = Color(0xFFB9A9AA))
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 10.dp),
                horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.CenterVertically
            ) {
                BottomBarItem(icon = Icons.Outlined.Settings, label = "Config")
                BottomBarItem(icon = Icons.Outlined.Schedule, label = "Alarma")
                BottomBarItem(icon = Icons.Outlined.Home, label = "Home")
                BottomBarItem(icon = Icons.Outlined.Description, label = "Reporte")
                BottomBarItem(icon = Icons.Outlined.Person, label = "Perfil")
            }
        }
    }
}

@Composable
private fun BottomBarItem(icon: ImageVector, label: String) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Icon(icon, contentDescription = label, tint = Color(0xFF0F172A))
        Spacer(Modifier.height(4.dp))
        Text(text = label, style = MaterialTheme.typography.bodyLarge, color = Color(0xFF0F172A))
    }
}


