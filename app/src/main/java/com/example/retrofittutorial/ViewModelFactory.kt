package com.example.retrofittutorial

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.retrofittutorial.model.repository.MovieRepository


class ViewModelFactory(private val movieRepository : MovieRepository ) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return modelClass.getConstructor(MovieRepository::class.java)
            .newInstance(movieRepository)
    }
}