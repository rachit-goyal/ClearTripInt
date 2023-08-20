package com.example.cleartripint.presentation.viewModel

import android.view.View
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cleartripint.data.ProductsItem
import com.example.cleartripint.domain.Repository
import dagger.hilt.android.lifecycle.HiltViewModel

import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(val repository: Repository) : ViewModel() {

    val data = MutableLiveData<List<ProductsItem>>()


    fun getData() {
        viewModelScope.launch {
            val response = repository.getData()
            if (response?.body() != null) {
                data.postValue(response.body() as List<ProductsItem>?)
            }
        }

    }
}