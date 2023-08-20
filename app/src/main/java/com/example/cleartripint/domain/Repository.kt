package com.example.cleartripint.domain

import com.example.cleartripint.data.ApiClient
import com.example.cleartripint.data.ProductsItem
import retrofit2.Response
import javax.inject.Inject

class Repository @Inject constructor(val apiClient: ApiClient) {
    suspend fun getData(): Response<List<ProductsItem?>>? {
        return apiClient.getProducts()
    }
}