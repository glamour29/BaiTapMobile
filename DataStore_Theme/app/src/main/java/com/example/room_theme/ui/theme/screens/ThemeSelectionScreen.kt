package com.example.room_theme.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.room_theme.data.ThemePreferences
import com.example.room_theme.ui.theme.RoomTheme
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

@Composable
fun ThemeSelectionScreen() {
    val context = LocalContext.current
    val coroutineScope = rememberCoroutineScope()

    val themeFlow: Flow<String?> = remember { ThemePreferences.getTheme(context) }
    val selectedTheme by themeFlow.collectAsState(initial = null)

    var tempSelectedTheme by remember(selectedTheme) { mutableStateOf<String?>(selectedTheme) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
            .padding(horizontal = 24.dp, vertical = 32.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Setting",
            style = MaterialTheme.typography.headlineMedium.copy(
                fontWeight = FontWeight.Bold,
                fontSize = 32.sp,
                color = Color(0xFF4FC3F7)
            ),
            textAlign = TextAlign.Center
        )
        Spacer(modifier = Modifier.height(12.dp))
        Text(
            text = "Choosing the right theme sets the tone and personality of your app",
            style = MaterialTheme.typography.bodyMedium.copy(
                fontSize = 16.sp,
                color = Color(0xFF4FC3F7)
            ),
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(horizontal = 16.dp)
        )
        Spacer(modifier = Modifier.height(40.dp))

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            ThemeOption(
                color = Color(0xFF81D4FA),
                themeName = "light",
                isSelected = tempSelectedTheme == "light",
                onClick = { tempSelectedTheme = "light" }
            )
            ThemeOption(
                color = Color(0xFFF06292),
                themeName = "pink",
                isSelected = tempSelectedTheme == "pink",
                onClick = { tempSelectedTheme = "pink" }
            )
            ThemeOption(
                color = Color(0xFF1C2526),
                themeName = "dark",
                isSelected = tempSelectedTheme == "dark",
                onClick = { tempSelectedTheme = "dark" }
            )
        }
        Spacer(modifier = Modifier.height(48.dp))
        Button(
            onClick = {
                coroutineScope.launch {
                    tempSelectedTheme?.let { theme ->
                        ThemePreferences.saveTheme(context, theme)
                    }
                }
            },
            modifier = Modifier
                .fillMaxWidth(0.6f)
                .height(50.dp)
                .clip(RoundedCornerShape(25.dp))
                .shadow(4.dp, RoundedCornerShape(25.dp)),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFF4FC3F7),
                contentColor = Color.White
            ),
            enabled = tempSelectedTheme != null
        ) {
            Text(
                text = "Apply",
                style = MaterialTheme.typography.bodyLarge.copy(
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 18.sp
                )
            )
        }
    }
}

@Composable
fun ThemeOption(
    color: Color,
    themeName: String,
    isSelected: Boolean,
    onClick: () -> Unit
) {
    Box(
        modifier = Modifier
            .size(80.dp)
            .clip(RoundedCornerShape(16.dp))
            .background(color)
            .border(
                width = if (isSelected) 3.dp else 0.dp,
                color = if (isSelected) Color.Black else Color.Transparent,
                shape = RoundedCornerShape(16.dp)
            )
            .shadow(
                elevation = 6.dp,
                shape = RoundedCornerShape(16.dp)
            )
            .clickable { onClick() }
    )
}

@Preview(showBackground = true)
@Composable
fun ThemeSelectionScreenPreview() {
    RoomTheme {
        ThemeSelectionScreen()
    }
}