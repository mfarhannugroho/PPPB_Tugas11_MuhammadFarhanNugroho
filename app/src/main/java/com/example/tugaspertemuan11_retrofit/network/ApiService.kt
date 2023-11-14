package com.example.tugaspertemuan11_retrofit.network

import com.example.tugaspertemuan11_retrofit.model.Product
import retrofit2.Call
import retrofit2.http.GET

// Interface untuk mendefinisikan endpoint-endpoint API menggunakan Retrofit
interface ApiService {
    // Mendefinisikan endpoint untuk mendapatkan daftar produk
    @GET("products")
    fun getProducts(): Call<List<Product>>
}
