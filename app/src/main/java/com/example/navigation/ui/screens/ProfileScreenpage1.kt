package com.profileandroidstudio.ui.screens

import android.content.Intent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.net.toUri
import androidx.navigation.NavController
import com.profileandroidstudio.R
import com.profileandroidstudio.navigation.NavRoutes
import com.profileandroidstudio.ui.components.PaginationButtons

@Composable
fun Page1Screen(navController: NavController) {
    val context = LocalContext.current
    val instagramUrl = "https://www.instagram.com/rezadwifanani_/"
    val linkedinUrl = "https://www.linkedin.com/in/reza-dwi-fanani-888727294/"

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
        // Header Title
        Text(
            text = "My Profile",
            fontSize = 26.sp,
            fontWeight = FontWeight.Bold,
            color = Color.White,
            modifier = Modifier.padding(top = 12.dp, bottom = 16.dp)
        )

        // Profile Card
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 8.dp),
            shape = RoundedCornerShape(20.dp),
            colors = CardDefaults.cardColors(containerColor = Color(0xFF1E1E1E)),
            elevation = CardDefaults.cardElevation(12.dp)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(20.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                // Profile Picture
                Image(
                    painter = painterResource(id = R.drawable.profile_picture),
                    contentDescription = "Profile Picture",
                    modifier = Modifier
                        .size(120.dp)
                        .clip(CircleShape),
                    contentScale = ContentScale.Crop
                )

                Spacer(modifier = Modifier.height(16.dp))

                // Name
                Text(
                    text = "Reza Dwi Fanani",
                    fontSize = 22.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                )

                Spacer(modifier = Modifier.height(6.dp))

                // Description
                Text(
                    text = "Computer Science student specializing in Front-End Development",
                    fontSize = 14.sp,
                    color = Color(0xFFB0BEC5),
                    textAlign = TextAlign.Center,
                    lineHeight = 18.sp,
                    modifier = Modifier.padding(horizontal = 12.dp)
                )

                Spacer(modifier = Modifier.height(20.dp))

                // Social Media Buttons
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    SocialMediaButton(
                        text = "Instagram",
                        modifier = Modifier.weight(1f)
                    ) {
                        val intent = Intent(Intent.ACTION_VIEW, instagramUrl.toUri())
                        context.startActivity(intent)
                    }

                    SocialMediaButton(
                        text = "LinkedIn",
                        modifier = Modifier.weight(1f)
                    ) {
                        val intent = Intent(Intent.ACTION_VIEW, linkedinUrl.toUri())
                        context.startActivity(intent)
                    }
                }
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Pagination Buttons
        PaginationButtons(
            navController = navController,
            destinations = listOf(NavRoutes.Page2Screen, NavRoutes.Page3Screen)
        )
    }
}

@Composable
private fun SocialMediaButton(
    text: String,
    modifier: Modifier = Modifier,
    onClick: () -> Unit
) {
    Box(
        modifier = modifier
            .height(42.dp)
            .background(
                brush = Brush.horizontalGradient(
                    listOf(Color(0xFF00C6FF), Color(0xFF0072FF))
                ),
                shape = RoundedCornerShape(20.dp)
            )
            .clickable { onClick() },
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = text,
            fontSize = 14.sp,
            fontWeight = FontWeight.SemiBold,
            color = Color.White
        )
    }
}
