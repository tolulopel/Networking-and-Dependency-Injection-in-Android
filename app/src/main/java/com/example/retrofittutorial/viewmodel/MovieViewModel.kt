package com.example.retrofittutorial.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.retrofittutorial.model.Movie
import com.example.retrofittutorial.model.repository.MovieRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MovieViewModel @Inject constructor(private val movieRepository: MovieRepository) : ViewModel() {

    private var _movieDetails = MutableLiveData<Movie>()
    val movieDetails : LiveData<Movie>
    get() = _movieDetails

    fun getMovieDetails() {
        viewModelScope.launch {
            try {
               val movieDetail = movieRepository.getMovieDetails()
               _movieDetails.postValue(movieDetail)
            }catch (ex : Exception){
                Log.d("TAG", "getMovieDetails: $ex")
            }
        }
    }

}