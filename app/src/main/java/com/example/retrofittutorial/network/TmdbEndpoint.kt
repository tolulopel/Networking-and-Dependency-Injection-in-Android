package com.example.retrofittutorial.network

import com.example.retrofittutorial.model.Movie
import retrofit2.http.*

interface TmdbEndpoint {

    @GET("movie/550")
    suspend fun getMovieDetails( @Query("api_key") apiKey : String ) : Movie

    @POST
    suspend fun postMessage()
}