package com.example.retrofittutorial.model

import com.google.gson.annotations.SerializedName

data class Movie(
    val adult : Boolean,
    val id : Int,
    val homepage : String,
    val genres : List<Something>
)


