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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.btvn_tuan03_jetpackcompose_letrieuduy.R
import com.example.thuchanh01_tuan04_letrieuduy.ui.theme.THUCHANH01_TUAN04_LETRIEUDUYTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            THUCHANH01_TUAN04_LETRIEUDUYTheme {
                val navController = rememberNavController()
                NavHost(navController = navController, startDestination = "home") {
                    composable("home") { HomeScreen(navController = navController) }
                    composable("second") { UIComponentsList(navController = navController) }
                    composable(
                        route = "detail/{quote}",
                        arguments = listOf(navArgument("quote") { type = NavType.StringType })
                    ) { backStackEntry ->
                        val quote = backStackEntry.arguments?.getString("quote") ?: ""
                        DetailScreen(navController = navController, quote = quote)
                    }
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
        Image(
            painter = painterResource(id = R.drawable.jetpackcomposelogo),
            contentDescription = "Jetpack Compose Logo",
            modifier = Modifier
                .height(250.dp)
                .width(150.dp)
        )

        Text(
            text = stringResource(id = R.string.jetpack_compose_text),
            fontSize = 14.sp,
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.ExtraBold
        )

        Text(
            text = stringResource(id = R.string.test_text),
            fontSize = 12.sp,
            textAlign = TextAlign.Center,
            fontFamily = FontFamily.Serif
        )

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
        Text(text = "PUSH", fontWeight = FontWeight.Bold)
    }
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    THUCHANH01_TUAN04_LETRIEUDUYTheme {
        HomeScreen(navController = rememberNavController())
    }
}