package com.example.fakestoreapp.screens

import android.util.Log
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.example.fakestoreapp.models.Product
import com.example.fakestoreapp.services.ProductService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Composable
fun ProductDetailScreen(id: Int) {
    // Implementation of the Product Detail Screen
    val BASE_URL = "https://fakestoreapi.com/"
    var product by remember {
        mutableStateOf<Product?>(null)
    }
    var isLoading by remember {
        mutableStateOf(true)
    }
    Text(
        text = id.toString()
    )
    LaunchedEffect(true) {
        try {
            val retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
            val service = retrofit.create(ProductService::class.java)
            val result = withContext(Dispatchers.IO){
                service.getProductById(id)
            }
            product = result
            isLoading = false
            Log.i("ProductDetailScreen", "Producto recibido: ${result}")
        }
        catch (e: Exception) {
            Log.e("ProductDetailScreen", "Esta mal: ${e.message}")
            isLoading = false
        }
    }
}