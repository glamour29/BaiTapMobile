package com.example.btvn_tuan03_jetpackcompose_letrieuduy.ui.theme

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.thuchanh01_tuan04_letrieuduy.ui.theme.THUCHANH01_TUAN04_LETRIEUDUYTheme

@Composable
fun DetailScreen(navController: NavController, quote: String) {
    val decodedQuote = quote.replace("\\n", "\n")
    val context = LocalContext.current

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.SpaceBetween
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
            Text(
                text = "Detail",
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(start = 16.dp),
                color = Color(0xFF2196F3),
            )
        }

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = "\"$decodedQuote\"",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(horizontal = 16.dp)
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = "Steve Jobs",
                fontSize = 16.sp,
                fontWeight = FontWeight.Medium,
                color = Color.Gray
            )
            Spacer(modifier = Modifier.height(8.dp))
            ClickableText(
                text = AnnotatedString("http://quotes.thisgrandpablogs.com/"),
                style = androidx.compose.ui.text.TextStyle(
                    fontSize = 12.sp,
                    color = Color(0xFF2196F3)
                ),
                modifier = Modifier.padding(bottom = 16.dp),
                onClick = {
                    // Mở link trong trình duyệt
                    val intent = Intent(Intent.ACTION_VIEW, Uri.parse("http://quotes.thisgrandpablogs.com/"))
                    context.startActivity(intent)
                }
            )
        }

        Button(
            onClick = {
                navController.popBackStack("home", inclusive = false)
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 32.dp),
            shape = RoundedCornerShape(8.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF2196F3))
        ) {
            Text(
                text = "BACK TO ROOT",
                color = Color.White,
                fontSize = 16.sp
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DetailScreenPreview() {
    THUCHANH01_TUAN04_LETRIEUDUYTheme {
        DetailScreen(
            navController = rememberNavController(),
            quote = "01 | The only way to do great work\nis to love what you do."
        )
    }
}