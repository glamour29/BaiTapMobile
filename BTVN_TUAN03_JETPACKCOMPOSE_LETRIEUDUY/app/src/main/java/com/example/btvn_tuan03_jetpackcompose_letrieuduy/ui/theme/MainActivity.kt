package com.example.btvn_tuan03_jetpackcompose_letrieuduy.ui.theme

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.btvn_tuan03_jetpackcompose_letrieuduy.R

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BTVN_TUAN03_JETPACKCOMPOSE_LETRIEUDUYTheme {
                val navController = rememberNavController()
                NavHost(navController = navController, startDestination = "home") {
                    composable("home") { HomeScreen(navController = navController) }
                    composable("second") { UIComponentsList(navController = navController) }
                    composable("displayText") { DisplayText(navController = navController) }
                }
                }
            }
        }
    }

@Composable
fun HomeScreen(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(4.dp)
    ) {
        // Hiển thị logo
        Image(
            painter = painterResource(id = R.drawable.jetpackcomposelogo),
            contentDescription = "Jetpack Compose Logo",
            modifier = Modifier
                .height(250.dp)
                .width(150.dp)
        )

        // Hiển thị chữ "Jetpack Compose"
        Text(
            text = stringResource(id = R.string.jetpack_compose_text),
            fontSize = 14.sp,
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.ExtraBold
        )

        // Hiển thị văn bản test_text
        Text(
            text = stringResource(id = R.string.test_text),
            fontSize = 12.sp,
            textAlign = TextAlign.Center,
            fontFamily = FontFamily.Serif
        )

        // Nút được đưa xuống dưới cùng
        ShowButton(navController = navController)
    }
}

@Composable
fun ShowButton(navController: NavController) {
    Button(
        onClick = { navController.navigate("second") },
        modifier = Modifier
            .padding(top = 150.dp)
            .width(210.dp)
            .height(35.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = Color(0xFF2196F3),
            contentColor = Color.White
        )
    ) {
        Text(text = "I'm ready", fontWeight = FontWeight.Bold)
    }
}
