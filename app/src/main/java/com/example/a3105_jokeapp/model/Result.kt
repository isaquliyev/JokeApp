package com.example.a3105_jokeapp.model

data class Result(
    val category: String,
    val type: String,
    val setup : String?,
    val delivery : String?,
    val joke : String?,
)
