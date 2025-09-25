package com.example.maquetacionmobile.ui.theme

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color

@Immutable
data class ExtendedColors(
    val accent: Color,
    val card: Color,
    val brandBg: Color,
    val onCard: Color
)

val LocalExtendedColors = staticCompositionLocalOf {
    ExtendedColors(
        accent = Color(0xFFE97777),
        card = Color(0xFFF5B5AB),
        brandBg = Color(0xFFFCE4E7),
        onCard = Color(0xFF2E2E2E)
    )
}

val LightExtendedColors = ExtendedColors(
    accent = Color(0xFFE97777),
    card = Color(0xFFF5B5AB),
    brandBg = Color(0xFFFCE4E7),
    onCard = Color(0xFF2E2E2E)
)

val DarkExtendedColors = ExtendedColors(
    accent = Color(0xFFE97777),
    card = Color(0xFFCC8D85),
    brandBg = Color(0xFF2B2B2B),
    onCard = Color(0xFFFFFFFF)
)


