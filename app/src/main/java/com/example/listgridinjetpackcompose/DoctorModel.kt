package com.example.listgridinjetpackcompose

import android.os.Parcel
import android.os.Parcelable

data class DoctorModel(
    val name: String,
    val gender: String,
    val spe: String,
    val image: Int,
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString().toString(),
        parcel.readString().toString(),
        parcel.readString().toString(),
        parcel.readInt()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(name)
        parcel.writeString(gender)
        parcel.writeString(spe)
        parcel.writeInt(image)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<DoctorModel> {
        override fun createFromParcel(parcel: Parcel): DoctorModel {
            return DoctorModel(parcel)
        }

        override fun newArray(size: Int): Array<DoctorModel?> {
            return arrayOfNulls(size)
        }
    }
}