package com.example.btvn_tuan03_jetpackcompose_letrieuduy.ui.theme

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.navigation.NavController
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.navigation.compose.rememberNavController
import androidx.compose.foundation.shape.RoundedCornerShape

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
            // Nút quay lại
            IconButton(onClick = { navController.navigateUp() }) {
                Icon(
                    imageVector = Icons.Default.ArrowBack,
                    contentDescription = "Back",
                    tint = Color(0xFF2196F3) // Màu xanh
                )
            }
            Box(
                modifier = Modifier
                    .weight(1f)
            ) {
                Text(
                    text = "UI Components List",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(start = 16.dp),
                    color = Color(0xFF2196F3),
                )
            }
        }

        Text(
            text = "Display",
            fontSize = 14.sp,
            fontWeight = FontWeight.ExtraBold,
            modifier = Modifier.padding(start = 3.dp, bottom = 1.dp),
            color = Color.Black
        )
        ButtonWithDescription(navController, buttonText = "Text", description = "Displays text")
        ButtonWithDescription(navController, buttonText = "Image", description = "Displays an image")

        Text(
            text = "Input",
            fontSize = 14.sp,
            fontWeight = FontWeight.ExtraBold,
            modifier = Modifier.padding(start = 3.dp, bottom = 1.dp),
            color = Color.Black
        )
        ButtonWithDescription(navController, buttonText = "TextField", description = "Input field for text")
        ButtonWithDescription(navController, buttonText = "PasswordField", description = "Input field for passwords")

        Text(
            text = "Layout",
            fontSize = 14.sp,
            fontWeight = FontWeight.ExtraBold,
            modifier = Modifier.padding(start = 3.dp, bottom = 1.dp),
            color = Color.Black
        )
        ButtonWithDescription(navController, buttonText = "Column", description = "Arranges elements vertically")
        ButtonWithDescription(navController, buttonText = "Row", description = "Arranges elements horizontally")
    }
}

@Composable
fun ButtonWithDescription(navController: NavController, buttonText: String, description: String) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(4.dp),
        horizontalAlignment = Alignment.Start
    ) {
        Button(
            onClick = {
                if (buttonText == "Text") {
                    navController.navigate("displayText")
                }
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 4.dp)
                .height(60.dp),
            shape = RoundedCornerShape(8.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF90CAF9))
        ) {
            Column(
                horizontalAlignment = Alignment.Start,
                verticalArrangement = Arrangement.Center,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(start = 0.dp)
            ) {
                Text(
                    text = buttonText,
                    color = Color.Black,
                    fontWeight = FontWeight.ExtraBold,
                    modifier = Modifier.padding(start = 0.dp)
                )
                Text(
                    text = description,
                    color = Color.Black,
                    modifier = Modifier.padding(start = 0.dp)
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun UIComponentsListPreview() {
    UIComponentsList(navController = rememberNavController())
}
