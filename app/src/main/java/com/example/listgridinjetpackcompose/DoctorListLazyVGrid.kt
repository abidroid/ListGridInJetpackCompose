package com.example.listgridinjetpackcompose

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import java.lang.reflect.Modifier

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable

fun DoctorListLazyVGrid(navController: NavController) {

    val doctors = retrieveDoctors()

    Scaffold(
        topBar = {
            TopAppBar(title = { Text(text = "Doctors List") })
        },
        content = {
            Column(
                modifier = androidx.compose.ui.Modifier
                    .fillMaxSize()
                    .padding(it)
            ) {
                LazyVerticalGrid(
                    columns = GridCells.Fixed(2),
                    verticalArrangement = Arrangement.spacedBy(8.dp),
                    horizontalArrangement = Arrangement.spacedBy(8.dp),
                    modifier = androidx.compose.ui.Modifier.padding(8.dp)
                ) {

                    items(doctors.size) { index ->

                        val doctor = doctors[index]

                        Card {
                            Image(painter = painterResource(id = doctor.image), contentDescription = doctor.name)
                            Text(doctor.name, fontSize = 20.sp)
                            Spacer(modifier = androidx.compose.ui.Modifier.padding(4.dp))
                            Text(doctor.spe)
                        }
                    }
                }
            }
        }
    )
}