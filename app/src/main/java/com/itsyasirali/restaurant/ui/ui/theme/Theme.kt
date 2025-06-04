package com.itsyasirali.restaurant.ui.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

private val DarkColorPalette = darkColors(
    primary = orange,
    background = Color(0xFF1E1E1E), // Dark gray
    surface = Color(0xFF2A2A2A),    // Slightly lighter gray
    onPrimary = Color.White,
    onBackground = Color.White,
    onSurface = Color.White
)

private val LightColorPalette = lightColors(
    primary = orange,
    background = Color(0xFFF5F5F5), // Light gray background
    surface = Color(0xFFFFFFFF),   // White card/surface
    onPrimary = Color.White,
    onBackground = Color.Black,
    onSurface = Color.Black
)

@Composable
fun BahgatResturantTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }

    MaterialTheme(
        colors = colors,
        typography = Typography,
        shapes = Shapes,
    ) {
        androidx.compose.material.Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colors.background
        ) {
            content()
        }
    }
}
