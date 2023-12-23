package com.example.sevenwindsstudiotest.data.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class MenuResponse(
    val id: Int,
    val name: String,
    val imageURL: String,
    val price: Int,
    var quantity: Int = 0
) : Parcelable