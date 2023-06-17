package com.example.maid.data

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class pricelist(
    val imgpricelist: Int,
    val namepricelist: String,
    val descpricelist: String
) : Parcelable