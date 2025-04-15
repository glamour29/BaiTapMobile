package com.example.room_theme.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.room_theme.ui.theme.RoomTheme

@Composable
fun LightThemeScreen(navController: NavController) {
    RoomTheme(theme = "light") {
        ThemeContent(navController, "Light")
    }
}

@Composable
fun DarkThemeScreen(navController: NavController) {
    RoomTheme(theme = "dark") {
        ThemeContent(navController, "Dark")
    }
}

@Composable
fun PinkThemeScreen(navController: NavController) {
    RoomTheme(theme = "pink") {
        ThemeContent(navController, "Pink")
    }
}

@Composable
fun SkyThemeScreen(navController: NavController) {
    RoomTheme(theme = "sky") {
        ThemeContent(navController, "Sky")
    }
}

@Composable
fun ThemeContent(navController: NavController, themeName: String) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = themeName,
            style = MaterialTheme.typography.headlineMedium
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = "Choosing the right theme sets the tone and personality of your app, enhancing user experience and reinforcing your brand identity",
            style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier.padding(horizontal = 16.dp)
        )
        Spacer(modifier = Modifier.height(32.dp))
        Button(
            onClick = { navController.navigate("theme_selection") },
            modifier = Modifier
                .fillMaxWidth(0.5f)
                .height(50.dp)
        ) {
            Text("Back")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun LightThemeScreenPreview() {
    RoomTheme(theme = "light") {
        ThemeContent(rememberNavController(), "Light")
    }
}

@Preview(showBackground = true)
@Composable
fun DarkThemeScreenPreview() {
    RoomTheme(theme = "dark") {
        ThemeContent(rememberNavController(), "Dark")
    }
}

@Preview(showBackground = true)
@Composable
fun PinkThemeScreenPreview() {
    RoomTheme(theme = "pink") {
        ThemeContent(rememberNavController(), "Pink")
    }
}

@Preview(showBackground = true)
@Composable
fun SkyThemeScreenPreview() {
    RoomTheme(theme = "sky") {
        ThemeContent(rememberNavController(), "Sky")
    }
}