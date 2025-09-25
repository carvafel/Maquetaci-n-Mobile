package com.example.maquetacionmobile.feature.alarm

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
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.maquetacionmobile.ui.theme.LocalExtendedColors
import com.example.maquetacionmobile.ui.theme.LocalSpacing
import com.example.maquetacionmobile.ui.theme.responsivePadding

@Composable
fun AlarmRunScreen(
    onPause: () -> Unit = {},
    onStop: () -> Unit = {},
    vibration: String = "Alta",
    sound: String = "Radial"
) {
    val extended = LocalExtendedColors.current
    val spacing = LocalSpacing.current

    Surface(modifier = Modifier.fillMaxSize(), color = extended.brandBg) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = responsivePadding(spacing.xl)),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(Modifier.height(24.dp))
            // Circular timer
            Box(
                modifier = Modifier
                    .size(260.dp)
                    .clip(CircleShape)
                    .background(Color(0xFFFAD8BE)),
                contentAlignment = Alignment.Center
            ) {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Text(text = "00:00", style = MaterialTheme.typography.displayLarge, fontWeight = FontWeight.Black, color = Color.Black)
                    Spacer(Modifier.height(8.dp))
                    Row(horizontalArrangement = Arrangement.spacedBy(48.dp)) {
                        Text("Horas", style = MaterialTheme.typography.bodyLarge)
                        Text("Minutos", style = MaterialTheme.typography.bodyLarge)
                    }
                }
            }

            Spacer(Modifier.height(32.dp))
            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
                Column { Text("Vibración", fontWeight = FontWeight.Bold); Spacer(Modifier.height(6.dp)); Divider(color = Color(0xFFEADADA)); Text(vibration) }
                Column(horizontalAlignment = Alignment.End) { Spacer(Modifier.height(20.dp)) }
            }
            Spacer(Modifier.height(12.dp))
            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
                Column { Text("Sonido", fontWeight = FontWeight.Bold); Spacer(Modifier.height(6.dp)); Divider(color = Color(0xFFEADADA)); Text(sound) }
                Column(horizontalAlignment = Alignment.End) { Spacer(Modifier.height(20.dp)) }
            }

            Spacer(Modifier.height(32.dp))
            Row(horizontalArrangement = Arrangement.spacedBy(16.dp)) {
                Button(onClick = onPause, colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFF19995)), shape = RoundedCornerShape(5.dp)) {
                    Text("Pausar")
                }
                Button(onClick = onStop, colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFEAD0B6)), shape = RoundedCornerShape(5.dp)) {
                    Text("Detener", color = Color.Black)
                }
            }
        }
    }
}


