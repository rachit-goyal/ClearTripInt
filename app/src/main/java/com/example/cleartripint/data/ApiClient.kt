package com.example.cleartripint.data

import retrofit2.Response
import retrofit2.http.GET

interface ApiClient {

    @GET("products")
    suspend fun getProducts():Response<List<ProductsItem?>>?
}