package com.example.listgridinjetpackcompose

import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.snapshots.SnapshotStateList

@Composable
fun retrieveDoctors(): SnapshotStateList<DoctorModel> {

    val doctorsList = remember {
        mutableStateListOf(
            DoctorModel("Ali", "Male", "ENT", R.drawable.ali),
            DoctorModel("Bano", "Female", "ENT", R.drawable.bano),
            DoctorModel("Bilal", "Male", "Gastro", R.drawable.bilal),
            DoctorModel("Fawad", "Male", "Physio", R.drawable.fawad),
            DoctorModel("Fozia", "Female", "Physio", R.drawable.fozia),
            DoctorModel("Hina", "Female", "Gynae", R.drawable.hina),
            DoctorModel("Jin", "Male", "Nephro", R.drawable.jin),
            DoctorModel("Riaz", "Male", "Dentist", R.drawable.riaz),
            )
    }

    return doctorsList
}