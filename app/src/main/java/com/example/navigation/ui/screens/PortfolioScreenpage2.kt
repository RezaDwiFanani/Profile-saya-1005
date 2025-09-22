package com.profileandroidstudio.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.text.font.FontWeight
import androidx.navigation.NavController
import com.profileandroidstudio.navigation.NavRoutes
import com.profileandroidstudio.ui.components.PaginationButtons

@Composable
fun Page2Screen(navController: NavController) {
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
            text = "My Skills",
            fontSize = 26.sp,
            fontWeight = FontWeight.Bold,
            color = Color.White,
            modifier = Modifier.padding(top = 12.dp, bottom = 20.dp)
        )

        // Skill List
        Column(
            verticalArrangement = Arrangement.spacedBy(16.dp),
            modifier = Modifier.fillMaxWidth()
        ) {
            SkillItem(skill = "UI/UX", level = 0.85f)
            SkillItem(skill = "Laravel", level = 0.80f)
            SkillItem(skill = "HTML/CSS", level = 0.95f)
            SkillItem(skill = "JavaScript", level = 0.70f)
        }

        // Pagination Buttons
        PaginationButtons(
            navController = navController,
            destinations = listOf(NavRoutes.Page1Screen, NavRoutes.Page3Screen)
        )
    }
}

@Composable
fun SkillItem(skill: String, level: Float) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(70.dp),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = Color(0xFF1E1E1E)),
        elevation = CardDefaults.cardElevation(6.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 16.dp, vertical = 10.dp),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Text(text = skill, color = Color.White, fontSize = 16.sp, fontWeight = FontWeight.SemiBold)

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(8.dp)
                    .background(Color(0xFF2C2C2C), RoundedCornerShape(4.dp))
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxHeight()
                        .fillMaxWidth(level)
                        .background(
                            Brush.horizontalGradient(
                                listOf(Color(0xFF00C6FF), Color(0xFF0072FF))
                            ),
                            RoundedCornerShape(4.dp)
                        )
                )
            }
        }
    }
}
