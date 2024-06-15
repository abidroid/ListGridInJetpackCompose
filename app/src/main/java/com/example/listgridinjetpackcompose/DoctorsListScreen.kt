package com.example.listgridinjetpackcompose

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.rounded.ArrowForward
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SegmentedButtonDefaults.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DoctorsListScreen() {

    val doctorsList = retrieveDoctors()
    val myContext = LocalContext.current

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Doctors List", color = Color.White) },
                colors = TopAppBarDefaults.topAppBarColors(containerColor = Color.Blue)
            )
        },

        content = {

            LazyColumn(
                modifier = Modifier.padding(it),

                ) {
                items(
                    count = doctorsList.count(),
                    itemContent = { index ->
                        val doctor = doctorsList[index]

                        Card(

                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(7.dp),
                            onClick = {
                                Toast.makeText(myContext, "You clicked ${doctor.name}", Toast.LENGTH_SHORT)

                            },
                            content = {

                                Row(
                                    modifier = Modifier
                                        .padding(7.dp)
                                        .fillMaxWidth(),
                                    horizontalArrangement = Arrangement.SpaceBetween,
                                    verticalAlignment = Alignment.CenterVertically
                                ) {
                                    Row(
                                        verticalAlignment = Alignment.CenterVertically
                                    ) {

                                        Image(
                                            painter = painterResource(id = doctor.image),
                                            contentDescription = "Doctor Image",
                                            contentScale = ContentScale.Crop,
                                            modifier = Modifier.size(80.dp)
                                                .clip(shape = CircleShape)

                                            )

                                        Spacer(modifier = Modifier.padding(8.dp))
                                        Column(
                                            verticalArrangement = Arrangement.Center,
                                        ) {
                                            Text(doctor.name, fontSize = 30.sp)
                                            Spacer(modifier = Modifier.padding(4.dp))
                                            Text(doctor.spe)
                                        }
                                    }

                                    Button(onClick = { /*TODO*/ }) {
                                        androidx.compose.material3.Icon(imageVector = Icons.Filled.Favorite, contentDescription = "Favorite")
                                    }


                                }
                            }
                        )

                    }
                )
            }
        }
    )
}

@Preview
@Composable
fun DoctorsListScreenPreview() {
    DoctorsListScreen()
}