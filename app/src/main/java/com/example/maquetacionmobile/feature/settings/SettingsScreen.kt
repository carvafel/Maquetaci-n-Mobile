package com.example.maquetacionmobile.feature.settings

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.maquetacionmobile.R
import com.example.maquetacionmobile.ui.components.HomeBottomBar
import com.example.maquetacionmobile.ui.theme.LocalExtendedColors
import com.example.maquetacionmobile.ui.theme.LocalSpacing
import com.example.maquetacionmobile.ui.theme.responsivePadding
import androidx.compose.foundation.clickable


@Composable
fun SettingsScreen(
    onLanguageClick: () -> Unit = {},
    onThemeClick: () -> Unit = {},
    onConfigClick: () -> Unit = {},
    onAlarmClick: () -> Unit = {},
    onHomeClick: () -> Unit = {},
    onProfileClick: () -> Unit = {}
) {
    val extended = LocalExtendedColors.current
    val spacing = LocalSpacing.current

    Box(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(extended.brandBg)
                .padding(horizontal = responsivePadding(spacing.xl))
                .padding(bottom = 80.dp)
        ) {
            Spacer(Modifier.height(24.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(id = R.drawable.logo),
                    contentDescription = "Logo",
                    modifier = Modifier.size(72.dp),
                    contentScale = ContentScale.Fit
                )
                Image(
                    painter = painterResource(id = R.drawable.profilepicture),
                    contentDescription = "Perfil",
                    modifier = Modifier.size(36.dp)
                )
            }

            Spacer(Modifier.height(16.dp))
            Text("Ajustes", style = MaterialTheme.typography.titleLarge, fontWeight = FontWeight.Bold)

            Spacer(Modifier.height(16.dp))
            SettingsRow("Idioma", "Español", onClick = onLanguageClick)
            Spacer(Modifier.height(12.dp))
            SettingsRow("Tema", "Claro", onClick = onThemeClick)
        }

        HomeBottomBar(
            modifier = Modifier.align(Alignment.BottomCenter),
            onConfig = onConfigClick,
            onAlarm = onAlarmClick,
            onHome = onHomeClick,
            onProfile = onProfileClick
        )
    }
}

@Composable
private fun SettingsRow(label: String, value: String, onClick: () -> Unit) {
    Surface(shape = RoundedCornerShape(6.dp), color = Color(0xFFEAD0B6), modifier = Modifier.clickable { onClick() }) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 12.dp, vertical = 10.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(modifier = Modifier.weight(1f)) {
                Text(label, color = Color(0xFF0F172A), fontWeight = FontWeight.SemiBold)
                Divider(color = Color(0xFFEADADA))
            }
            Text(value)
            Icon(Icons.Filled.KeyboardArrowRight, contentDescription = null)
        }
    }
}


