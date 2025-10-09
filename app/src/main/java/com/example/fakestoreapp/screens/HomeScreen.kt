package com.example.fakestoreapp.screens

import android.util.Log
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.fakestoreapp.components.ProductCard
import com.example.fakestoreapp.models.Product
import com.example.fakestoreapp.services.ProductService
import com.example.fakestoreapp.ui.theme.ProductDetailScreenRoute
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Composable
fun HomeScreen(navController: NavController) {
    val BASE_URL = "https://fakestoreapi.com/"
    // Efectos secundarios

    var productos by remember {
        mutableStateOf(listOf<Product>())
    }

    var isLoading by remember {
        mutableStateOf(true)
    }


    LaunchedEffect(true) {
        try {
            Log.i("HomeScreen", "Creando instancia de Retrofit")
            val retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
            val service = retrofit.create(ProductService::class.java)
            val result = withContext(Dispatchers.IO){
                service.getAllProducts()
            }
            Log.i("HomeScreen", "Productos recibidos: ${result}")
            productos = result
            isLoading = false
        }
        catch (e: Exception) {
            Log.e("HomeScreen", "Esta mal: ${e.message}")
            isLoading = false
        }
    }

    if (isLoading) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            CircularProgressIndicator()
//            LinearProgressIndicator()
        }
    }
    else{
        LazyColumn (
            modifier = Modifier
                .fillMaxSize()
        ){
            items(productos){ product ->
                ProductCard(
                    product = product,
                    onClick = {
                        navController.navigate(ProductDetailScreenRoute(product.id))
                    }
                )
            }
        }
    }
}