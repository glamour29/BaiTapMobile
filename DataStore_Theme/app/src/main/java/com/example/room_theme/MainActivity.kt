package com.example.room_theme

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import com.example.room_theme.data.ThemePreferences
import com.example.room_theme.ui.screens.ThemeSelectionScreen
import com.example.room_theme.ui.theme.RoomTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val context = LocalContext.current
            val themeFlow = ThemePreferences.getTheme(context)
            val selectedTheme by themeFlow.collectAsState(initial = null)

            RoomTheme(theme = selectedTheme) {
                ThemeSelectionScreen()
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ThemeSelectionScreenPreview() {
    RoomTheme {
        ThemeSelectionScreen()
    }
}