package com.example.tugaspertemuan11_retrofit.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

// Objek singleton untuk menyediakan instance Retrofit dan ApiService
object ApiClient {
    // URL dasar dari API
    private const val BASE_URL = "https://fakestoreapi.com/"

    // Instance Retrofit
    val retrofit: Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    // Instance ApiService yang menggunakan Retrofit
    val apiService: ApiService by lazy {
        retrofit.create(ApiService::class.java)
    }
}
