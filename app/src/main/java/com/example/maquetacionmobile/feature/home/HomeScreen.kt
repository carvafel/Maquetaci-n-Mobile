package com.example.maquetacionmobile.feature.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.shape.RoundedCornerShape
import com.example.maquetacionmobile.R
import com.example.maquetacionmobile.ui.theme.LocalExtendedColors
import com.example.maquetacionmobile.ui.theme.LocalSpacing
import com.example.maquetacionmobile.ui.theme.responsivePadding
import com.example.maquetacionmobile.ui.components.HomeBottomBar

@Composable
fun HomeScreen(
    userName: String = "Juan",
    onConfigClick: () -> Unit = {},
    onAlarmClick: () -> Unit = {},
    onReportClick: () -> Unit = {},
    onProfileClick: () -> Unit = {},
    onBottomConfigClick: () -> Unit = {}
) {
    val extended = LocalExtendedColors.current
    val spacing = LocalSpacing.current

    Box(modifier = Modifier.fillMaxSize()) {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = extended.brandBg
        ) {
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = responsivePadding(spacing.xl))
                    .padding(bottom = 80.dp)
            ) {
            item {
                Spacer(Modifier.height(responsivePadding(24.dp)))
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.logo),
                        contentDescription = "Logo",
                        modifier = Modifier.size(responsivePadding(72.dp)),
                        contentScale = ContentScale.Fit
                    )
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Text(text = "Bienvenido, $userName", style = MaterialTheme.typography.bodyLarge)
                        Spacer(Modifier.size(spacing.lg))
                        Image(
                            painter = painterResource(id = R.drawable.profilepicture),
                            contentDescription = "Perfil",
                            modifier = Modifier.size(responsivePadding(40.dp))
                        )
                    }
                }

                Spacer(Modifier.height(responsivePadding(24.dp)))
                Button(
                    onClick = onAlarmClick,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(responsivePadding(56.dp)),
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFF19995)),
                    shape = RoundedCornerShape(5.dp),
                    contentPadding = PaddingValues()
                )
                {
                    Text(text = "Empezar alarma", style = MaterialTheme.typography.titleLarge, color = Color.White, fontWeight = FontWeight.Bold)
                }

                Spacer(Modifier.height(30.dp))
                Box(modifier = Modifier
                    .fillMaxWidth()
                    .clickable(onClick = onConfigClick), contentAlignment = Alignment.Center) {
                    Text(
                        text = "Configurar alarma",
                        style = MaterialTheme.typography.bodyLarge,
                        color = MaterialTheme.colorScheme.onSurface
                    )
                }

                Spacer(Modifier.height(80.dp))
                Text(text = "Historial de siestas", style = MaterialTheme.typography.titleLarge, fontWeight = FontWeight.Bold)
                Spacer(Modifier.height(8.dp))

                val rows = listOf(
                    Triple("07/10/2025", "0h 25min", 4),
                    Triple("27/10/2025", "0h 15min", 5),
                    Triple("10/11/2025", "0h 45min", 4)
                )
                rows.forEach { (date, duration, rating) ->
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 6.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(date)
                        Text(duration)
                        Row {
                            repeat(5) { idx ->
                                val filled = idx < rating
                                Image(
                                    painter = painterResource(id = R.drawable.star),
                                    contentDescription = null,
                                    modifier = Modifier.size(16.dp),
                                    colorFilter = ColorFilter.tint(
                                        if (filled) Color(0xFF000000) else Color(0x33000000)
                                    )
                                )
                            }
                        }
                    }
                }

                Spacer(Modifier.height(30.dp))
                Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
                    Button(
                        onClick = onReportClick,
                        modifier = Modifier.fillMaxWidth(0.5f),
                        colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFF19995)),
                        shape = RoundedCornerShape(5.dp),
                        contentPadding = PaddingValues(vertical = responsivePadding(10.dp))
                    ) {
                        Text(text = "Ver reporte", color = Color.White, fontWeight = FontWeight.SemiBold)
                    }
                }

                Spacer(Modifier.height(responsivePadding(24.dp)))
            }
            }
        }
        HomeBottomBar(
            modifier = Modifier.align(Alignment.BottomCenter),
            onConfig = onBottomConfigClick,
            onAlarm = onAlarmClick,
            onHome = { },
            onReport = { /* stub */ },
            onProfile = onProfileClick
        )
    }
}

