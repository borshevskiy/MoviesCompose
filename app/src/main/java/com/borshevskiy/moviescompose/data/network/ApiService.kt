package com.borshevskiy.moviescompose.data.network

import com.borshevskiy.moviescompose.data.models.Movies
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {

    @GET("/shows")
    suspend fun getAllMovies(): Response<List<Movies>>
}