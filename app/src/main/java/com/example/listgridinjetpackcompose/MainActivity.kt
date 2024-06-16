package com.example.listgridinjetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge

import androidx.compose.runtime.Composable

import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument

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

    NavHost(navController = navController, startDestination = "DoctorListLazyRow") {
        composable("DoctorListLazyRow") {
            DoctorListLazyRow(navController)
        }
        composable("DoctorDetailScreen/{doctorName}",
            arguments = listOf(
                navArgument("doctorName") { type = NavType.StringType }
            )) {
            val doctorName = it.arguments?.getString("doctorName")

            doctorName?.let {
                DoctorDetailScreen(navController, doctorName)

            }
        }

    }
}