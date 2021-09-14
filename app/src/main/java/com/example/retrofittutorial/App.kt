package com.example.retrofittutorial

import android.app.Application
import com.example.retrofittutorial.model.repository.MovieRepository
import com.example.retrofittutorial.model.repository.MovieRepositoryImpl
import com.example.retrofittutorial.network.NetworkClient

// Provides a dependency to the app in a special way
class App : Application() {

    companion object{
        /**
         * Exposing the value as an interface, entire app uses the repository without creating it
         * manually, keeps the initialization in one place and usage in another
         */
        val repository : MovieRepository by lazy {
            MovieRepositoryImpl(
                NetworkClient.createTmdbEndpoint(),
                API_KEY
            )
        }
    }

}