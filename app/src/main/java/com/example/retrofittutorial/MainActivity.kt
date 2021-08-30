package com.example.retrofittutorial

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.lifecycleScope
import com.example.retrofittutorial.network.NetworkClient
import com.example.retrofittutorial.network.TmdbEndpoint
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import javax.inject.Inject
import javax.inject.Named

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    @Inject
   // @Named("retro1")
    lateinit var tmdbEndpoint: TmdbEndpoint
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
          val movie1 =  tmdbEndpoint.getMovieDetails(API_KEY)
          //  Log.d("MainActivity", "onCreate: ${movie1.genres[0].name}")
        }
    }
}