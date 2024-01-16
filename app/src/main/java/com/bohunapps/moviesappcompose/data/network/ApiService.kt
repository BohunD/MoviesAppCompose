package com.bohunapps.moviesappcompose.data.network

import com.bohunapps.moviesappcompose.data.models.Movie
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {

    @GET("/shows")
    suspend fun getAllMovies(): Response<List<Movie>>
}