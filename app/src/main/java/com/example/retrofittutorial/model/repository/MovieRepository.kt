package com.example.retrofittutorial.model.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.retrofittutorial.model.Movie

interface MovieRepository {
    suspend fun getMovieDetails() : Movie
}