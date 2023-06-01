package com.example.a3105_jokeapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.a3105_jokeapp.databinding.ActivityMainBinding
import com.example.a3105_jokeapp.viewmodel.JokeViewModel

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var viewModel: JokeViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        onPressSingleJoke()
        onPressTwoPartJoke()
        viewModel = ViewModelProvider(this)[JokeViewModel::class.java]
        viewModel.getJoke("single")
        viewModel.observeJokeLiveData().observe(this,
            Observer { jokeData ->
                if (jokeData.joke != null) {
                    binding.jokeId.setText(jokeData.joke)
                } else {
                    binding.jokeId.setText("${jokeData.setup}\n${jokeData.delivery}")
                }
            })
    }

    fun onPressSingleJoke() {
        binding.singleJokeId.setOnClickListener {
            viewModel.getJoke("single")
        }
    }
    fun onPressTwoPartJoke() {
        binding.twoPartId.setOnClickListener {
            viewModel.getJoke("twopart")
        }
    }
}