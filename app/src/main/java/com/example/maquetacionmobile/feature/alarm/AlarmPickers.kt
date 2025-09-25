package com.example.maquetacionmobile.feature.alarm

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
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
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.BorderStroke
import com.example.maquetacionmobile.ui.components.HomeBottomBar
import com.example.maquetacionmobile.ui.theme.LocalExtendedColors
import com.example.maquetacionmobile.ui.theme.LocalSpacing
import com.example.maquetacionmobile.ui.theme.responsivePadding

@Composable
fun AlarmSoundScreen(
    onBack: () -> Unit = {},
    onConfigClick: () -> Unit = {},
    onAlarmClick: () -> Unit = {},
    onHomeClick: () -> Unit = {},
    onProfileClick: () -> Unit = {}
) {
    val extended = LocalExtendedColors.current
    val spacing = LocalSpacing.current
    val items = listOf("Radial (Predeterminado)", "Alba", "Arbolada", "Arpegio", "Cazatesoros", "Chalet", "Cuento")

    Box(modifier = Modifier.fillMaxSize()) {
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
                Text("Sonido", style = MaterialTheme.typography.titleLarge)
            }

            Spacer(Modifier.height(16.dp))
            Text("Tonos", fontWeight = androidx.compose.ui.text.font.FontWeight.SemiBold)
            Spacer(Modifier.height(8.dp))
            Surface(shape = RoundedCornerShape(6.dp), border = BorderStroke(1.dp, Color(0xFFB9A9AA))) {
                LazyColumn(modifier = Modifier.fillMaxWidth().background(Color.White)) {
                    items(items) { label ->
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(horizontal = 12.dp, vertical = 12.dp),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(label, color = Color.Black)
                        }
                    }
                }
            }
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
fun AlarmVibrationScreen(
    onBack: () -> Unit = {},
    onConfigClick: () -> Unit = {},
    onAlarmClick: () -> Unit = {},
    onHomeClick: () -> Unit = {},
    onProfileClick: () -> Unit = {}
) {
    val extended = LocalExtendedColors.current
    val spacing = LocalSpacing.current
    val items = listOf("Alta (Predeterminado)", "Media", "Baja")

    Box(modifier = Modifier.fillMaxSize()) {
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
                Text("Vibración", style = MaterialTheme.typography.titleLarge)
            }

            Spacer(Modifier.height(16.dp))
            Text("Modo", fontWeight = androidx.compose.ui.text.font.FontWeight.SemiBold)
            Spacer(Modifier.height(8.dp))
            Surface(shape = RoundedCornerShape(6.dp), border = BorderStroke(1.dp, Color(0xFFB9A9AA))) {
                LazyColumn(modifier = Modifier.fillMaxWidth().background(Color.White)) {
                    items(items) { label ->
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(horizontal = 12.dp, vertical = 12.dp),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(label, color = Color.Black)
                        }
                    }
                }
            }
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


