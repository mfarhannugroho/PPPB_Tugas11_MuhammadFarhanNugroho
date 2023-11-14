package com.example.tugaspertemuan11_retrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.tugaspertemuan11_retrofit.model.Product
import com.example.tugaspertemuan11_retrofit.network.ApiClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: ProductAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Inisialisasi RecyclerView
        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        // Inisialisasi Adapter untuk RecyclerView
        adapter = ProductAdapter()
        recyclerView.adapter = adapter

        // Memanggil fungsi untuk mengambil data produk dari API
        fetchProducts()
    }

    // Fungsi untuk mengambil data produk dari API menggunakan Retrofit
    private fun fetchProducts() {
        // Membuat panggilan ke API menggunakan Retrofit
        val call: Call<List<Product>> = ApiClient.apiService.getProducts()

        // Menangani respons dari panggilan ke API
        call.enqueue(object : Callback<List<Product>> {
            override fun onResponse(call: Call<List<Product>>, response: Response<List<Product>>) {
                // Memeriksa apakah respons berhasil
                if (response.isSuccessful) {
                    // Mendapatkan daftar produk dari respons atau menggunakan daftar kosong jika null
                    val products: List<Product> = response.body() ?: emptyList()

                    // Mengatur produk pada adapter untuk ditampilkan di RecyclerView
                    adapter.setProducts(products)
                }
            }

            // Menangani kegagalan panggilan ke API
            override fun onFailure(call: Call<List<Product>>, t: Throwable) {
                // Mencetak stack trace dari error
                t.printStackTrace()
            }
        })
    }
}