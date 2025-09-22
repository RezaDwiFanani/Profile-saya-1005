package com.profileandroidstudio.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.profileandroidstudio.R
import com.profileandroidstudio.navigation.NavRoutes
import com.profileandroidstudio.ui.components.PaginationButtons

@Composable
fun Page3Screen(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(
                Brush.verticalGradient(
                    listOf(Color(0xFF0F2027), Color(0xFF203A43), Color(0xFF2C5364))
                )
            )
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        // Title
        Text(
            text = "My Certificate",
            fontSize = 26.sp,
            fontWeight = FontWeight.Bold,
            color = Color.White,
            modifier = Modifier.padding(top = 12.dp, bottom = 20.dp)
        )

        // Certificate List
        Column(
            verticalArrangement = Arrangement.spacedBy(20.dp),
            modifier = Modifier.fillMaxWidth()
        ) {
            ProjectCard(
                imageRes = R.drawable.himti_1,
                title = "Himti Bootcamp 2023",
                description = "Web Developer Bootcamp Himti."
            )

            ProjectCard(
                imageRes = R.drawable.sertif_bncc,
                title = "BNCC Bootcamp 2023",
                description = "Front-End Developer Bootcamp BNCC."
            )
        }

        // Pagination Buttons
        PaginationButtons(
            navController = navController,
            destinations = listOf(NavRoutes.Page1Screen, NavRoutes.Page2Screen)
        )
    }
}

@Composable
fun ProjectCard(imageRes: Int, title: String, description: String) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(150.dp),
        shape = RoundedCornerShape(20.dp),
        colors = CardDefaults.cardColors(containerColor = Color(0xFF1E1E1E)),
        elevation = CardDefaults.cardElevation(8.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxSize()
        ) {
            // Certificate Image
            Image(
                painter = painterResource(id = imageRes),
                contentDescription = title,
                modifier = Modifier
                    .width(120.dp)
                    .fillMaxHeight()
                    .clip(RoundedCornerShape(topStart = 20.dp, bottomStart = 20.dp)),
                contentScale = ContentScale.Crop
            )

            // Certificate Info
            Column(
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxHeight(),
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = title,
                    color = Color.White,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold
                )

                Spacer(modifier = Modifier.height(6.dp))

                Text(
                    text = description,
                    color = Color(0xFFB0BEC5),
                    fontSize = 13.sp,
                    lineHeight = 16.sp
                )
            }
        }
    }
}
