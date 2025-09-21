package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.myapplication.ui.theme.MyApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme { // Make sure the theme name is correct here
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    AppNavigation()
                }
            }
        }
    }
}

@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "halaman1") {
        composable("halaman1") {
            Halaman1(navController = navController)
        }
        composable("halaman2") {
            Halaman2(navController = navController)
        }
        composable("halaman3") {
            Halaman3(navController = navController)
        }
    }
}

@Composable
fun Halaman1(navController: NavController) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Ini Halaman 1")
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = { navController.navigate("halaman2") }) {
            Text(text = "Ke Halaman 2")
        }
        Spacer(modifier = Modifier.height(8.dp))
        Button(onClick = { navController.navigate("halaman3") }) {
            Text(text = "Ke Halaman 3")
        }
    }
}

@Composable
fun Halaman2(navController: NavController) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Ini Halaman 2")
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = { navController.navigate("halaman1") }) {
            Text(text = "Ke Halaman 1")
        }
        Spacer(modifier = Modifier.height(8.dp))
        Button(onClick = { navController.navigate("halaman3") }) {
            Text(text = "Ke Halaman 3")
        }
    }
}

@Composable
fun Halaman3(navController: NavController) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Ini Halaman 3")
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = { navController.navigate("halaman1") }) {
            Text(text = "Ke Halaman 1")
        }
        Spacer(modifier = Modifier.height(8.dp))
        Button(onClick = { navController.navigate("halaman2") }) {
            Text(text = "Ke Halaman 2")
        }
    }
}