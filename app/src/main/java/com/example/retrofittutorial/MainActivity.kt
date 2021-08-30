package com.example.retrofittutorial

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.example.retrofittutorial.network.NetworkClient
import com.example.retrofittutorial.viewmodel.MovieViewModel
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private val repository by lazy { App.repository }
    private lateinit var viewModel: MovieViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        /**
         * Making network call in android
         */
        //1. Add ur dependencies
        //2. Model your data class
        //3. Create your interface
        //4. Create your retrofit bulider
        //5. Hit your endpoint( enqueue, coroutine(lifecycleScope,
        //viewlifecyleowner.lifecycleScope, viewModelScope), RxJava)

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
         */

        val viewModelFactory = ViewModelFactory(repository)
        viewModel = ViewModelProvider(this, viewModelFactory)[MovieViewModel::class.java]
        viewModel.getMovieDetails()

        viewModel.movieDetails.observe(this){
            Log.d("MainActivity", "onCreate: ${it.genres[0].name}")
        }
    }
}