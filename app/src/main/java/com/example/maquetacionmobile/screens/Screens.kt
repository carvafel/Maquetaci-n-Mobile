package com.example.maquetacionmobile.screens

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@Composable
fun HomeScreen() {
    ScreenScaffold(title = "Inicio", body = "Contenido destacable y lista resumen")
}

@Composable
fun DetailScreen() {
    ScreenScaffold(title = "Detalle", body = "Descripción extendida e información secundaria")
}

@Composable
fun SettingsScreen() {
    ScreenScaffold(title = "Ajustes", body = "Preferencias de la app para UI/UX")
}

@Composable
private fun ScreenScaffold(title: String, body: String) {
    val elements = (1..10).map { "Elemento "+it }
    LazyColumn {
        item { Text(text = title, style = MaterialTheme.typography.titleLarge) }
        item { Text(text = body, style = MaterialTheme.typography.bodyLarge) }
        items(elements) { label ->
            Text(text = label)
        }
    }
}


