package com.example.retrofittutorial.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import com.example.retrofittutorial.R
import dagger.hilt.android.AndroidEntryPoint
import com.example.retrofittutorial.viewmodel.MovieViewModel

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val movieViewModel: MovieViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        /**
         * Making network call in android
         *  1. Add ur dependencies
            2. Model your data class
            3. Create your interface
            4. Create your retrofit builder
            5. Hit your endpoint( enqueue, coroutine(lifecycleScope, viewlifecyleowner.lifecycleScope,
            viewModelScope), RxJava)
         */


        /**
         * Using manual dependency Injection
         * branch- ft-manual-injection:
         *   1. Add your hilt dependencies and sync
         *   2. Create your application class that will hold the dependencies for your viewModel
         *   3. Get a reference to the repository in your activity/fragment where you need the viewModel
         *   4. Create your viewModel using factory pattern, call the function to hit the endpoint
         *   and observe your result
         * Using Hilt
         * branch- ft-hilt
         *    1. Add necessary dependencies
         *    2. Create your application class and annotate with @HiltAndroidApp
         *    3. Create your di modules and declare ur dependencies
         *    4. Inject the dependencies where you require them
         */

        movieViewModel.getMovieDetails()

        movieViewModel.movieDetails.observe(this){
            Log.d("MainActivity-Hilt", "onCreate: ${it.genres[0].name}")
        }
    }
}