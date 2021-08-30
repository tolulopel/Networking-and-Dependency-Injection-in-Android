package com.example.retrofittutorial.network

import com.example.retrofittutorial.BASE_URL
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object NetworkClient {

    fun createTmdbEndpoint() : TmdbEndpoint{
        val logging = HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)

        // Creates an implementation of the ApiService
        return Retrofit.Builder()
            .client(
                OkHttpClient.Builder().addInterceptor(logging).build()
            )
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(TmdbEndpoint::class.java)
    }
}