package com.example.maquetacionmobile.feature.recover

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
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
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.shape.RoundedCornerShape
import com.example.maquetacionmobile.R
import com.example.maquetacionmobile.ui.theme.LocalExtendedColors
import com.example.maquetacionmobile.ui.theme.LocalSpacing
import com.example.maquetacionmobile.ui.theme.responsivePadding

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RecoverPasswordScreen(
    onConfirmClick: () -> Unit
) {
    val userOrEmail = remember { mutableStateOf("") }
    val newPassword = remember { mutableStateOf("") }
    val confirmPassword = remember { mutableStateOf("") }
    val showNew = remember { mutableStateOf(false) }
    val showConfirm = remember { mutableStateOf(false) }

    val extended = LocalExtendedColors.current
    val spacing = LocalSpacing.current

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(extended.brandBg)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = responsivePadding(spacing.xl))
                .verticalScroll(rememberScrollState())
                .imePadding(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Image(
                painter = painterResource(id = R.drawable.logo),
                contentDescription = "Logo",
                modifier = Modifier.size(responsivePadding(160.dp)),
                contentScale = ContentScale.Fit
            )

            Spacer(modifier = Modifier.height(40.dp))

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(color = extended.card, shape = MaterialTheme.shapes.small)
                    .border(width = 1.dp, color = MaterialTheme.colorScheme.onSurface, shape = MaterialTheme.shapes.small)
                    .padding(horizontal = responsivePadding(spacing.lg), vertical = responsivePadding(20.dp))
            ) {
                Column(modifier = Modifier.fillMaxWidth()) {
                    Text(
                        text = "Recupera tu contraseña",
                        style = MaterialTheme.typography.titleLarge,
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.onSurface
                    )

                    Spacer(modifier = Modifier.height(responsivePadding(spacing.lg)))
                    Text(text = "Usuario o correo", style = MaterialTheme.typography.bodyLarge, fontWeight = FontWeight.SemiBold)
                    Spacer(modifier = Modifier.height(responsivePadding(6.dp)))
                    OutlinedTextField(
                        value = userOrEmail.value,
                        onValueChange = { userOrEmail.value = it },
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(Color.White, shape = MaterialTheme.shapes.extraSmall),
                        singleLine = true,
                        colors = TextFieldDefaults.outlinedTextFieldColors(
                            focusedBorderColor = MaterialTheme.colorScheme.onSurface,
                            unfocusedBorderColor = MaterialTheme.colorScheme.onSurface,
                            cursorColor = MaterialTheme.colorScheme.onSurface
                        )
                    )

                    Spacer(modifier = Modifier.height(responsivePadding(spacing.md)))
                    Text(text = "Contraseña nueva", style = MaterialTheme.typography.bodyLarge, fontWeight = FontWeight.SemiBold)
                    Spacer(modifier = Modifier.height(responsivePadding(6.dp)))
                    OutlinedTextField(
                        value = newPassword.value,
                        onValueChange = { newPassword.value = it },
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(Color.White, shape = MaterialTheme.shapes.extraSmall),
                        singleLine = true,
                        visualTransformation = if (showNew.value) androidx.compose.ui.text.input.VisualTransformation.None else androidx.compose.ui.text.input.PasswordVisualTransformation(),
                        trailingIcon = {
                            val icon = if (showNew.value) Icons.Default.VisibilityOff else Icons.Default.Visibility
                            IconButton(onClick = { showNew.value = !showNew.value }) {
                                Icon(imageVector = icon, contentDescription = "Mostrar/Ocultar")
                            }
                        },
                        colors = TextFieldDefaults.outlinedTextFieldColors(
                            focusedBorderColor = MaterialTheme.colorScheme.onSurface,
                            unfocusedBorderColor = MaterialTheme.colorScheme.onSurface,
                            cursorColor = MaterialTheme.colorScheme.onSurface
                        )
                    )

                    Spacer(modifier = Modifier.height(responsivePadding(spacing.md)))
                    Text(text = "Confirmar contraseña", style = MaterialTheme.typography.bodyLarge, fontWeight = FontWeight.SemiBold)
                    Spacer(modifier = Modifier.height(responsivePadding(6.dp)))
                    OutlinedTextField(
                        value = confirmPassword.value,
                        onValueChange = { confirmPassword.value = it },
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(Color.White, shape = MaterialTheme.shapes.extraSmall),
                        singleLine = true,
                        visualTransformation = if (showConfirm.value) androidx.compose.ui.text.input.VisualTransformation.None else androidx.compose.ui.text.input.PasswordVisualTransformation(),
                        trailingIcon = {
                            val icon = if (showConfirm.value) Icons.Default.VisibilityOff else Icons.Default.Visibility
                            IconButton(onClick = { showConfirm.value = !showConfirm.value }) {
                                Icon(imageVector = icon, contentDescription = "Mostrar/Ocultar")
                            }
                        },
                        colors = TextFieldDefaults.outlinedTextFieldColors(
                            focusedBorderColor = MaterialTheme.colorScheme.onSurface,
                            unfocusedBorderColor = MaterialTheme.colorScheme.onSurface,
                            cursorColor = MaterialTheme.colorScheme.onSurface
                        )
                    )

                    Spacer(modifier = Modifier.height(responsivePadding(spacing.lg)))
                    Button(
                        onClick = onConfirmClick,
                        modifier = Modifier
                            .fillMaxWidth(0.55f)
                            .align(Alignment.CenterHorizontally),
                        colors = ButtonDefaults.buttonColors(containerColor = extended.card),
                        shape = RoundedCornerShape(5.dp),
                        contentPadding = PaddingValues(vertical = responsivePadding(10.dp))
                    ) {
                        Text(text = "Confirmar", color = MaterialTheme.colorScheme.onSurface, fontWeight = FontWeight.SemiBold)
                    }

                    Spacer(modifier = Modifier.height(responsivePadding(40.dp)))
                }
            }
        }
    }
}


