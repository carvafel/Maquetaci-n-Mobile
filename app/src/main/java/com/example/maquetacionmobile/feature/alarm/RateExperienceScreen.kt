package com.example.maquetacionmobile.feature.alarm

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.maquetacionmobile.R
import com.example.maquetacionmobile.ui.theme.LocalExtendedColors
import com.example.maquetacionmobile.ui.theme.LocalSpacing
import com.example.maquetacionmobile.ui.theme.responsivePadding

@Composable
fun RateExperienceScreen(
    onSkip: () -> Unit = {},
    onSave: () -> Unit = {}
) {
    val extended = LocalExtendedColors.current
    val spacing = LocalSpacing.current
    val clarity = remember { mutableStateOf(3) }
    val ease = remember { mutableStateOf(3) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(extended.brandBg)
            .padding(horizontal = responsivePadding(spacing.xl)),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(Modifier.height(16.dp))
        Row(modifier = Modifier.align(Alignment.End)) {
            Text("Omitir", color = Color(0xFF0F172A), modifier = Modifier.clickable { onSkip() })
        }
        Spacer(Modifier.height(8.dp))
        Text("Califica tu", style = MaterialTheme.typography.titleLarge, fontWeight = FontWeight.Black)
        Text("experiencia", style = MaterialTheme.typography.titleLarge, fontWeight = FontWeight.Black)

        Spacer(Modifier.height(24.dp))
        Text("Claridad al despertar", style = MaterialTheme.typography.bodyLarge)
        Spacer(Modifier.height(8.dp))
        StarsRow(selected = clarity.value, onSelect = { clarity.value = it })

        Spacer(Modifier.height(20.dp))
        Text("Facilidad al despertar", style = MaterialTheme.typography.bodyLarge)
        Spacer(Modifier.height(8.dp))
        StarsRow(selected = ease.value, onSelect = { ease.value = it })

        Spacer(Modifier.height(30.dp))
        Button(
            onClick = onSave,
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFF19995)),
            shape = RoundedCornerShape(5.dp)
        ) { Text("Guardar", color = Color.White) }
    }
}

@Composable
private fun StarsRow(selected: Int, onSelect: (Int) -> Unit) {
    Row(horizontalArrangement = Arrangement.spacedBy(6.dp)) {
        repeat(5) { idx ->
            val filled = idx < selected
            Image(
                painter = painterResource(id = R.drawable.star),
                contentDescription = null,
                modifier = Modifier.size(24.dp).clickable { onSelect(idx + 1) },
                alpha = if (filled) 1f else 0.3f
            )
        }
    }
}


