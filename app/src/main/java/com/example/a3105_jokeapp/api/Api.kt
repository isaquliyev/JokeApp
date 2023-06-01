package com.example.a3105_jokeapp.api

import retrofit2.Call
import retrofit2.http.GET
import com.example.a3105_jokeapp.model.Result
import retrofit2.http.Query

interface Api {
    @GET("joke/any")
    fun getJoke(@Query("type")type : String) : Call<Result>
}