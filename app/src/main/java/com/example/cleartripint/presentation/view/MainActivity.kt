package com.example.cleartripint.presentation.view

import android.graphics.Movie
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.cleartripint.Adapter.ReclerAdapter
import com.example.cleartripint.R
import com.example.cleartripint.databinding.ActivityMainBinding
import com.example.cleartripint.presentation.viewModel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    lateinit var viewModel: MainViewModel
    lateinit var adapter:ReclerAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        viewModel.getData()
        viewModel.data.observe(this) {
         /*   binding.recyclerView.apply {
                layoutManager = LinearLayoutManager(this@MainActivity)
                setHasFixedSize(true)
                adapter = ReclerAdapter(it) {

                    Log.d("Value","it");
                }
            }*/
            binding.recyclerView.layoutManager = LinearLayoutManager(this)
            binding.recyclerView.setHasFixedSize(true)

            // Instantiating moviesAdapter & passing
            // lambda function in it's constructor
            adapter = ReclerAdapter(it){
                Log.d("value",it.toString());
            }

            // Setting adapter to moviesRecyclerView
            binding.recyclerView.adapter = adapter
        }
    }
}