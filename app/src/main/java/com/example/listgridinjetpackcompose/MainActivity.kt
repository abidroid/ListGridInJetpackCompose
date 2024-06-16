package com.example.listgridinjetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.listgridinjetpackcompose.ui.theme.ListGridInJetpackComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyNavigation()
        }
    }
}


@Composable
fun MyNavigation() {

    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "DoctorsListScreen") {
        composable("DoctorsListScreen") {
            DoctorsListScreen()
        }
//        composable("DoctorsDetailsScreen/{doctor}",
//            arguments = listOf(
//                navArgument("doctor") {type = NavType.DoctorModelType}
//            ) ){}

    }
}