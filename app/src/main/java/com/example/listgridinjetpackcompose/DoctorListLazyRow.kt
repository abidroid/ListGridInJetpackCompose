package com.example.listgridinjetpackcompose

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DoctorListLazyRow(navController: NavController) {

    val doctors = retrieveDoctors()

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Doctors") },
            )
        },

        content = {

            LazyRow(
                modifier = Modifier.padding(it),
            ) {
                items(doctors.count(),
                    itemContent = { index ->
                        val doctor = doctors[index]
                        Card(

                            onClick = {

                            },

                            modifier = Modifier
                                .padding(10.dp)
                                .height(250.dp)

                        ) {
                            Column(
                                verticalArrangement = Arrangement.SpaceBetween,
                                horizontalAlignment = Alignment.CenterHorizontally,
                                modifier = Modifier.padding(8.dp)

                            ) {
                                Column(
                                    horizontalAlignment = Alignment.CenterHorizontally,
                                    modifier = Modifier.weight(1f)
                                ) {
                                    Image(
                                        painter = painterResource(id = doctor.image), contentDescription = doctor.name,
                                        contentScale = ContentScale.FillBounds,
                                        modifier = Modifier.size(80.dp, 80.dp)

                                    )
                                    Spacer(modifier = Modifier.height(10.dp))
                                    Text("Name: ${doctor.name}")
                                    Spacer(modifier = Modifier.height(10.dp))
                                    Text(text = "Speciality: ${doctor.spe}")
                                    Spacer(modifier = Modifier.height(10.dp))
                                    Text(text = "Gender: ${doctor.gender}")
                                    Spacer(modifier = Modifier.height(10.dp))
                                }

                                Button(onClick = { /*TODO*/ }) {
                                    Icon(imageVector = Icons.AutoMirrored.Filled.ArrowForward, contentDescription = "Favorite")
                                }
                            }
                        }
                    }
                )
            }
        }
    )
}
