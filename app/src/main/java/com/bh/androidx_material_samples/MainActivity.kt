package com.bh.androidx_material_samples

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.bh.androidx_material_samples.ui.AlertDialogSample
import com.bh.androidx_material_samples.ui.BackdropScaffoldSample
import com.bh.androidx_material_samples.ui.SimpleTopAppBar
import com.bh.androidx_material_samples.ui.theme.AndroidxmaterialsamplesTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AndroidxmaterialsamplesTheme {
                val navController = rememberNavController()
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    NavigationComponent(
                        navController = navController, modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun HomeScreen(navController: NavHostController, modifier: Modifier = Modifier) {
    Column(modifier = modifier.padding(16.dp)) {
        Button(onClick = { navController.navigate("alertDialog") }) {
            Text(text = "AlertDialogSample")
        }
        Button(onClick = { navController.navigate("appBar") }) {
            Text(text = "TopAppBarSimple")
        }
        Button(onClick = { navController.navigate("backdropScaffold") }) {
            Text(text = "BackdropScaffoldSample")
        }
    }
}

@Composable
fun NavigationComponent(navController: NavHostController, modifier: Modifier = Modifier) {
    NavHost(navController = navController, startDestination = "home") {
        composable("home") {
            HomeScreen(navController = navController, modifier = modifier)
        }
        composable("alertDialog") {
            AlertDialogSample()
        }
        composable("appBar") {
            SimpleTopAppBar()
        }
        composable("backdropScaffold") {
            BackdropScaffoldSample()
        }
    }
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    val navController = rememberNavController()
    AndroidxmaterialsamplesTheme {
        HomeScreen(navController = navController)
    }
}
