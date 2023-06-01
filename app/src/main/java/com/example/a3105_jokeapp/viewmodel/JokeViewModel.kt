package com.example.a3105_jokeapp.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.a3105_jokeapp.model.Result
import com.example.a3105_jokeapp.network.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class JokeViewModel : ViewModel() {
    private var jokeLiveData = MutableLiveData<Result>()
    fun getJoke( type : String) {
        RetrofitClient.api.getJoke(type).enqueue(object : Callback<Result> {
            override fun onResponse(call: Call<Result>, response: Response<Result>) {
                if(response.body() != null ) {
                    jokeLiveData.value = response.body()
                }
                else {
                    return
                }
            }

            override fun onFailure(call: Call<Result>, t: Throwable) {
                Log.d("Tag", t.message.toString())
            }
        })
    }
    fun observeJokeLiveData() : LiveData<Result> {
        return jokeLiveData
    }
}