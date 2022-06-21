package com.borshevskiy.moviescompose.data.models


import com.google.gson.annotations.SerializedName

data class Rating(
    @SerializedName("average")
    val average: Double?
)