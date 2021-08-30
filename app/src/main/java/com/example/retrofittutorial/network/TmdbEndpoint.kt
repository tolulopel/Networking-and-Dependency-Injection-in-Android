package com.example.retrofittutorial.network

import com.example.retrofittutorial.model.Movie
import retrofit2.http.*

interface TmdbEndpoint {

    @GET("pokemon")
    suspend fun getMovieDetails( @Query("limit") limit : Int , @Query("offset") offset : Int) : Movie

    @POST
    suspend fun postMessage()
}