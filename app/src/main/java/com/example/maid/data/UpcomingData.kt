package com.example.maid.data

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class UpcomingData(
    val imgharga: Int,
    val nameharga: String,
    val descharga: String
) : Parcelable