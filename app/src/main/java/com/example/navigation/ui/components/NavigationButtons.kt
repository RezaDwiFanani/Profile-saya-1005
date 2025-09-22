package com.profileandroidstudio.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.profileandroidstudio.navigation.NavRoutes

@Composable
fun PaginationButtons(
    navController: NavController,
    destinations: List<NavRoutes>
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        destinations.forEach { destination ->
            Button(
                onClick = { navController.navigate(destination.route) }
            ) {
                Text(text = destination.route)
            }
        }
    }
}
