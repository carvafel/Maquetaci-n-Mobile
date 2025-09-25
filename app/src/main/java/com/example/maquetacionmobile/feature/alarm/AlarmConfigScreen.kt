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
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.BorderStroke
import androidx.compose.material3.Surface
import androidx.compose.foundation.clickable
import com.example.maquetacionmobile.ui.components.HomeBottomBar
import com.example.maquetacionmobile.ui.theme.LocalExtendedColors
import com.example.maquetacionmobile.ui.theme.LocalSpacing
import com.example.maquetacionmobile.ui.theme.responsivePadding

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AlarmConfigScreen(
    onSave: () -> Unit = {},
    onCancel: () -> Unit = {},
    onStartAlarm: () -> Unit = {},
    onClickSound: () -> Unit = {},
    onClickVibration: () -> Unit = {}
) {
    val extended = LocalExtendedColors.current
    val spacing = LocalSpacing.current

    val hours = remember { mutableStateOf("") }
    val minutes = remember { mutableStateOf("") }
    val sound = remember { mutableStateOf("Radial") }
    val vibration = remember { mutableStateOf("Alta") }

    Box(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(extended.brandBg)
                .padding(horizontal = responsivePadding(spacing.xl))
                .padding(bottom = 80.dp)
        ) {
            Spacer(Modifier.height(24.dp))
            Text(text = "Configurar alarma", style = MaterialTheme.typography.titleLarge, fontWeight = FontWeight.Bold)

            Spacer(Modifier.height(24.dp))
            Text(text = "Duración", style = MaterialTheme.typography.bodyLarge, fontWeight = FontWeight.SemiBold)
            Spacer(Modifier.height(8.dp))
            Row(verticalAlignment = Alignment.CenterVertically) {
                NumberField(value = hours.value, onChange = { hours.value = it }, placeholder = "00")
                Spacer(Modifier.width(8.dp))
                Text(text = ":")
                Spacer(Modifier.width(8.dp))
                NumberField(value = minutes.value, onChange = { minutes.value = it }, placeholder = "15")
                Spacer(Modifier.width(8.dp))
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Text("Horas", style = MaterialTheme.typography.bodyLarge)
                }
            }

            Spacer(Modifier.height(24.dp))
            SettingRow(label = "Sonido", value = sound.value, onClick = onClickSound)
            SettingRow(label = "Vibración", value = vibration.value, onClick = onClickVibration)

            Spacer(Modifier.height(24.dp))
            Row(horizontalArrangement = Arrangement.spacedBy(16.dp)) {
                Button(
                    onClick = onSave,
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFF19995)),
                    shape = RoundedCornerShape(5.dp)
                ) {
                    Text("Guardar")
                }
                Button(
                    onClick = onCancel,
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFEAD0B6)),
                    shape = RoundedCornerShape(5.dp)
                ) {
                    Text("Cancelar", color = Color(0xFF000000))
                }
            }

            Spacer(Modifier.height(24.dp))
            Button(
                onClick = onStartAlarm,
                modifier = Modifier.fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFF19995)),
                shape = RoundedCornerShape(5.dp)
            ) { Text("Empezar alarma", color = Color.White, fontWeight = FontWeight.Bold) }
        }

        HomeBottomBar(
            modifier = Modifier.align(Alignment.BottomCenter)
        )
    }
}

@Composable
private fun SettingRow(label: String, value: String, onClick: () -> Unit) {
    Column(modifier = Modifier.fillMaxWidth()) {
        Text(text = label, style = MaterialTheme.typography.bodyLarge, fontWeight = FontWeight.SemiBold)
        Spacer(Modifier.height(8.dp))
        Surface(
            modifier = Modifier
                .fillMaxWidth()
                .clickable(onClick = onClick),
            color = Color(0xFFEAD0B6),
            shape = RoundedCornerShape(5.dp),
            border = BorderStroke(1.dp, Color(0xFFB9A9AA))
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 12.dp, vertical = 10.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(value, color = Color(0xFF000000))
                Icon(Icons.Filled.KeyboardArrowRight, contentDescription = "Cambiar")
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun NumberField(value: String, onChange: (String) -> Unit, placeholder: String) {
    OutlinedTextField(
        value = value,
        onValueChange = { if (it.all { ch -> ch.isDigit() } && it.length <= 2) onChange(it) },
        modifier = Modifier.width(54.dp),
        singleLine = true,
        placeholder = { Text(placeholder) },
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = MaterialTheme.colorScheme.onSurface,
            unfocusedBorderColor = MaterialTheme.colorScheme.onSurface,
            cursorColor = MaterialTheme.colorScheme.onSurface
        )
    )
}


