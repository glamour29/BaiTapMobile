package com.example.btvn_tuan03_jetpackcompose_letrieuduy.ui.theme

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.thuchanh01_tuan04_letrieuduy.ui.theme.THUCHANH01_TUAN04_LETRIEUDUYTheme

@Composable
fun UIComponentsList(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.Top
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start,
            modifier = Modifier.fillMaxWidth()
        ) {
            IconButton(onClick = { navController.navigateUp() }) {
                Icon(
                    imageVector = Icons.Default.ArrowBack,
                    contentDescription = "Back",
                    tint = Color(0xFF2196F3)
                )
            }
            Box(
                modifier = Modifier.weight(1f)
            ) {
                Text(
                    text = "LazyColumn",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(start = 16.dp),
                    color = Color(0xFF2196F3),
                )
            }
        }

        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(6) { index ->
                when (index) {
                    0 -> ButtonWithDescription(navController, "01 | The only way to do great work\nis to love what you do.")
                    1 -> ButtonWithDescription(navController, "02 | The only way to do great work\nis to love what you do.")
                    2 -> ButtonWithDescription(navController, "03 | The only way to do great work\nis to love what you do.")
                    3 -> ButtonWithDescription(navController, "04 | The only way to do great work\nis to love what you do.")
                    4 -> ButtonWithDescription(navController, "05 | The only way to do great work\nis to love what you do.")
                    5 -> ButtonWithDescription(navController, "1.000.000 | The only way to do\ngreat work is to love what you do.")
                }
            }
        }
    }
}

@Composable
fun ButtonWithDescription(navController: NavController, buttonText: String) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(4.dp),
        horizontalAlignment = Alignment.Start
    ) {
        Box(modifier = Modifier.fillMaxWidth()) {
            Button(
                onClick = {
                    val encodedText = buttonText.replace("\n", "\\n")
                    navController.navigate("detail/$encodedText")
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(80.dp)
                    .padding(vertical = 4.dp),
                shape = RoundedCornerShape(12.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF90CAF9))
            ) {
                Row(
                    modifier = Modifier.fillMaxSize(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = buttonText,
                        color = Color.Black,
                        modifier = Modifier
                            .padding(start = 8.dp)
                            .weight(1f),
                        fontSize = 14.sp,
                        lineHeight = 18.sp
                    )
                    Icon(
                        imageVector = Icons.Default.KeyboardArrowRight,
                        contentDescription = "Arrow Icon",
                        tint = Color.White,
                        modifier = Modifier
                            .size(40.dp)
                            .background(Color.Black, shape = RoundedCornerShape(10.dp))
                            .padding(8.dp)
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun UIComponentsListPreview() {
    THUCHANH01_TUAN04_LETRIEUDUYTheme {
        UIComponentsList(navController = rememberNavController())
    }
}