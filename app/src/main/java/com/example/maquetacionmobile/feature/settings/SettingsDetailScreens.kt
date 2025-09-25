package com.example.maquetacionmobile.feature.settings

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.layout.width
import com.example.maquetacionmobile.ui.components.HomeBottomBar
import com.example.maquetacionmobile.ui.theme.LocalExtendedColors
import com.example.maquetacionmobile.ui.theme.LocalSpacing
import com.example.maquetacionmobile.ui.theme.responsivePadding

@Composable
fun SettingsLanguageScreen(onBack: () -> Unit = {}) {
    val extended = LocalExtendedColors.current
    val spacing = LocalSpacing.current
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(extended.brandBg)
            .padding(horizontal = responsivePadding(spacing.xl))
            .padding(bottom = 80.dp)
    ) {
        Spacer(Modifier.height(24.dp))
        Row(verticalAlignment = Alignment.CenterVertically) {
            Icon(Icons.Filled.ArrowBack, contentDescription = "Atrás", modifier = Modifier.clickable { onBack() })
            Spacer(Modifier.width(8.dp))
            Text("Idioma", style = MaterialTheme.typography.titleLarge, fontWeight = FontWeight.Bold)
        }
        Spacer(Modifier.height(16.dp))
        OptionList(options = listOf("Español", "Inglés"))
    }
}

@Composable
fun SettingsThemeScreen(onBack: () -> Unit = {}) {
    val extended = LocalExtendedColors.current
    val spacing = LocalSpacing.current
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(extended.brandBg)
            .padding(horizontal = responsivePadding(spacing.xl))
            .padding(bottom = 80.dp)
    ) {
        Spacer(Modifier.height(24.dp))
        Row(verticalAlignment = Alignment.CenterVertically) {
            Icon(Icons.Filled.ArrowBack, contentDescription = "Atrás", modifier = Modifier.clickable { onBack() })
            Spacer(Modifier.width(8.dp))
            Text("Tema", style = MaterialTheme.typography.titleLarge, fontWeight = FontWeight.Bold)
        }
        Spacer(Modifier.height(16.dp))
        OptionList(options = listOf("Claro", "Oscuro"))
    }
}

@Composable
private fun OptionList(options: List<String>) {
    Surface {
        Column(modifier = Modifier.fillMaxWidth()) {
            options.forEachIndexed { index, label ->
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 12.dp, vertical = 12.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Text(text = if (index == 0) "✓" else "")
                        Spacer(Modifier.width(6.dp))
                        Text(label)
                    }
                }
            }
        }
    }
}


