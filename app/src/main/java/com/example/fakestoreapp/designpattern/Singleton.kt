package com.example.fakestoreapp.designpattern

import com.example.fakestoreapp.services.ProductService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

// 1. Singleton Pattern
// Existe para garantizar que una instancia de una clase sea la misma
// durante todo el tiempo de vida de la aplicación.

object RetrofitInstance {
    // Aquí iría la configuración de Retrofit
    val BASE_URL = "https://fakestoreapi.com/"
    val retrofit = Retrofit.Builder()
        .baseUrl("https://fakestoreapi.com/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
}

fun main() {
    val service = RetrofitInstance.retrofit.create(ProductService::class.java)
    println(service)
}