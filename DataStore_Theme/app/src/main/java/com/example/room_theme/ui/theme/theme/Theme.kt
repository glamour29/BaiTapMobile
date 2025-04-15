package com.example.room_theme.ui.theme

import android.app.Activity
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat

private val LightColorScheme = lightColorScheme(
    primary = Color(0xFF4FC3F7),
    background = Color.White
)

private val DarkColorScheme = darkColorScheme(
    primary = Color(0xFF4FC3F7),
    background = Color(0xFF1C2526)
)

private val PinkColorScheme = lightColorScheme(
    primary = Color(0xFF4FC3F7),
    background = Color(0xFFF06292)
)

private val SkyColorScheme = lightColorScheme(
    primary = Color(0xFF4FC3F7),
    background = Color(0xFF81D4FA)
)

@Composable
fun RoomTheme(
    theme: String? = null,
    content: @Composable () -> Unit
) {
    val isDarkTheme = isSystemInDarkTheme()
    val colorScheme = when (theme) {
        "dark" -> DarkColorScheme
        "pink" -> PinkColorScheme
        "sky" -> SkyColorScheme
        else -> if (isDarkTheme) DarkColorScheme else LightColorScheme
    }

    val view = LocalView.current
    if (!view.isInEditMode) {
        SideEffect {
            val window = (view.context as Activity).window
            WindowCompat.setDecorFitsSystemWindows(window, false)
            window.statusBarColor = Color.Transparent.toArgb()
            WindowCompat.getInsetsController(window, view).isAppearanceLightStatusBars = !isDarkTheme
        }
    }

    MaterialTheme(
        colorScheme = colorScheme,
        content = content
    )
}