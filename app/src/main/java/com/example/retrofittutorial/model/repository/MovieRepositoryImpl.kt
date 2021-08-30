package com.example.retrofittutorial.model.repository

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.retrofittutorial.API_KEY
import com.example.retrofittutorial.model.Movie
import com.example.retrofittutorial.network.TmdbEndpoint
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.withContext

/**
 * This repository class abstracts access to the API endpoint, provides a clean API for
 * data access to the rest of the application, manages queries and communicates with the
 * remote data source according to request from the viewModel populates the database and retrieves
 * data from the database
 */
class MovieRepositoryImpl(private val tmdbEndpoint: TmdbEndpoint, private val apiKey : String) : MovieRepository{

    override suspend fun getMovieDetails(): Movie {
          return tmdbEndpoint.getMovieDetails(apiKey)
    }
}