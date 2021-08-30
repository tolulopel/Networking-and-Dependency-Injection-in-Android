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
        //1. Add ur dependencies
        //2. Model your data class
        //3. Create your interface
        //4. Create your retrofit bulider
        //5. Hit your endpoint( enqueue, coroutine(lifecycleScope,
        //viewlifecyleowner.lifecycleScope, viewModelScope), RxJava)
        val limit = 10
        var offset = 0

        lifecycleScope.launch {
          val movie1 =  NetworkClient.createTmdbEndpoint().getMovieDetails(limit, offset)
          offset = movie1.homepage.split("=")[1].split("&")[0].toInt()
          //  Log.d("MainActivity", "onCreate: ${movie1.genres[0].name}")
        }
    }
}