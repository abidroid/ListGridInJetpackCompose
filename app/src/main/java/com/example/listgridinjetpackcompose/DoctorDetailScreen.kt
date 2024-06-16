package com.example.listgridinjetpackcompose

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DoctorDetailScreen(navController: NavController, doctorName: String) {

    val doctorsList = retrieveDoctors()

    val doctor = doctorsList.find { doctor -> doctor.name == doctorName }

    Scaffold(
        topBar = {
            TopAppBar(title = { Text("Doctor Details") },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Back")
                    }
                }

            )
        },

        content = {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(it),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                if (doctor == null) {
                    Text("Doctor not found")
                    return@Column
                }

                if( doctor.image != null ){
                    Image(painter = painterResource(id = doctor.image), contentDescription = "Doctor Image",
                        modifier = Modifier.size(300.dp)
                        )

                }
                Spacer(modifier = Modifier.height(16.dp))
                Text("Name: ${doctor?.name}")
                Spacer(modifier = Modifier.height(16.dp))
                Text(text = "Gender: ${doctor?.gender}")
                Spacer(modifier = Modifier.height(16.dp))
                Text(text = "Specialization: ${doctor?.spe}")
            }
        }


    )
}