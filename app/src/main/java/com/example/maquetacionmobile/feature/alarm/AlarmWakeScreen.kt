package com.example.maquetacionmobile.feature.alarm

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.maquetacionmobile.ui.theme.LocalExtendedColors
import com.example.maquetacionmobile.ui.theme.LocalSpacing
import com.example.maquetacionmobile.ui.theme.responsivePadding

@Composable
fun AlarmWakeScreen(
    onRateClick: () -> Unit = {},
    onSnoozeClick: () -> Unit = {},
    onStopClick: () -> Unit = {}
) {
    val extended = LocalExtendedColors.current
    val spacing = LocalSpacing.current

    Surface(modifier = Modifier.fillMaxSize(), color = extended.brandBg) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = responsivePadding(spacing.xl)),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top
        ) {
            Spacer(Modifier.height(24.dp))
            Text("Hora de despertar", style = MaterialTheme.typography.titleLarge, fontWeight = FontWeight.Black)
            Spacer(Modifier.height(40.dp))
            Button(
                onClick = onRateClick,
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFF19995)),
                shape = RoundedCornerShape(5.dp)
            ) { Text("Calificar experiencia", color = Color.White) }
            Spacer(Modifier.height(40.dp))
            androidx.compose.foundation.layout.Row(
                horizontalArrangement = Arrangement.spacedBy(16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Button(
                    onClick = onSnoozeClick,
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFF19995)),
                    shape = RoundedCornerShape(5.dp)
                ) { Text("Posponer", color = Color.White) }
                Button(
                    onClick = onStopClick,
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFEAD0B6)),
                    shape = RoundedCornerShape(5.dp)
                ) { Text("Detener", color = Color.Black) }
            }
        }
    }
}


