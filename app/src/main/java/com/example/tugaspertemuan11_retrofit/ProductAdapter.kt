package com.example.tugaspertemuan11_retrofit

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.tugaspertemuan11_retrofit.model.Product

// Adapter untuk RecyclerView yang menangani tampilan item produk
class ProductAdapter : RecyclerView.Adapter<ProductAdapter.ProductViewHolder>() {

    // Daftar produk yang akan ditampilkan
    private var products: List<Product> = emptyList()

    // Fungsi untuk mengatur daftar produk dan memberitahu adapter bahwa data telah berubah
    fun setProducts(products: List<Product>) {
        this.products = products
        notifyDataSetChanged()
    }

    // Membuat tampilan untuk item produk
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_product, parent, false)
        return ProductViewHolder(view)
    }

    // Menghubungkan data produk dengan tampilan item produk
    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        val product = products[position]
        holder.bind(product)
    }

    // Mendapatkan jumlah item dalam daftar produk
    override fun getItemCount(): Int = products.size

    // ViewHolder untuk menangani tampilan item produk
    class ProductViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        // Komponen tampilan item produk
        private val titleTextView: TextView = itemView.findViewById(R.id.titleTextView)
        private val priceTextView: TextView = itemView.findViewById(R.id.priceTextView)
        private val imageView: ImageView = itemView.findViewById(R.id.imageView)

        // Fungsi untuk menghubungkan data produk dengan tampilan item produk
        fun bind(product: Product) {
            titleTextView.text = product.title
            priceTextView.text = "$${product.price}"

            // Menggunakan Glide untuk memuat gambar produk ke dalam ImageView
            Glide.with(itemView.context)
                .load(product.image)
                .into(imageView)
        }
    }
}
