package com.example.retrofittutorial.model.repository

import com.example.retrofittutorial.model.Movie

interface MovieRepository {
    suspend fun getMovieDetails() : Movie
}