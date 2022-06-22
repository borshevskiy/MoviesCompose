package com.borshevskiy.moviescompose.data.models


import com.google.gson.annotations.SerializedName

data class Self(
    @SerializedName("href")
    val href: String?
)