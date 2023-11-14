package com.example.tugaspertemuan11_retrofit.model

import com.google.gson.annotations.SerializedName

// Data class untuk merepresentasikan objek produk dari API
data class Product(
    // Properti-properti produk dengan annotation SerializedName untuk mapping data JSON
    @SerializedName("id") val id: Int,
    @SerializedName("title") val title: String,
    @SerializedName("price") val price: Double,
    @SerializedName("description") val description: String,
    @SerializedName("category") val category: String,
    @SerializedName("image") val image: String
)
