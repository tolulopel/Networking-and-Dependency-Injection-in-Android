package com.example.retrofittutorial

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.lifecycleScope
import com.example.retrofittutorial.network.NetworkClient
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
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
         * branch- ft-manual-injection
         * Using Hilt
         * branch- ft-hilt
         */






        lifecycleScope.launch {
          val movie1 =  NetworkClient.createTmdbEndpoint().getMovieDetails(API_KEY)
          //  Log.d("MainActivity", "onCreate: ${movie1.genres[0].name}")
        }
    }
}