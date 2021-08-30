package com.example.retrofittutorial.di

import android.content.SharedPreferences
import com.example.retrofittutorial.BASE_URL
import com.example.retrofittutorial.network.TmdbEndpoint
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
   // @Named("retro1")
    //ApplicationContext can be accessed from @ApplicationContext
    //viewmodel @ViewModelInject constructor() else @Inject constructor()
    fun provideApiServiceEndPoint(): TmdbEndpoint {
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