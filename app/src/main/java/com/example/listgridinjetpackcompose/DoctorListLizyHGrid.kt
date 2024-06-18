package com.example.listgridinjetpackcompose

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DoctorListHGrid(navController: NavController) {

    val doctors = retrieveDoctors()
    val myContext = LocalContext.current

    Scaffold (
       topBar = {
           TopAppBar(title = { Text("Doctors List") })
       },

        content = {
            Column(modifier = Modifier.padding(it)) {
                LazyHorizontalGrid(
                    rows = GridCells.Fixed(2),
                    contentPadding = PaddingValues(16.dp),
                ){
                    items(doctors.size){ index ->

                        val doctor = doctors[index]

                        Card(onClick = {
                            Toast.makeText(myContext, doctor.name, Toast.LENGTH_SHORT).show()
                        }) {

                            Image(painter = painterResource(id = doctor.image),
                                contentDescription = doctor.name,

                                modifier = Modifier.size(150.dp)
                                    .clip(RoundedCornerShape(10.dp))

                            )

                        }

                    }
                }
            }
        }
    )
}