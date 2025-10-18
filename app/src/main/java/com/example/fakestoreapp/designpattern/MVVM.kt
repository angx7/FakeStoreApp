//package com.example.fakestoreapp.designpattern
//
//import androidx.compose.runtime.getValue
//import androidx.compose.runtime.mutableStateOf
//import androidx.compose.runtime.setValue
//import androidx.lifecycle.ViewModel
//import androidx.lifecycle.viewModelScope
//import com.example.fakestoreapp.models.Product
//import com.example.fakestoreapp.services.ProductService
//import kotlinx.coroutines.Dispatchers
//import kotlinx.coroutines.launch
//import kotlinx.coroutines.withContext
//
//// 4. Model-View-ViewModel (MVVM) Pattern -> Clean Architecture
//// Separa la lógica de negocio (Model) de la interfaz de usuario (View)
//// mediante un intermediario (ViewModel).
//
//class HomeViewModel : ViewModel() {
//    var products by mutableStateOf<List<Product>>(emptyList())
//    var isLoading by mutableStateOf(true)
//
//    fun loadProducts(productList: List<Product>) {
//        products = productList
//        isLoading = false
//
//        viewModelScope.launch {
//            try {
//                val productService = RetrofitInstance.retrofit.create(ProductService::class.java)
//                products = withContext(Dispatchers.IO){
//                    productService.getAllProducts()
//                }
//                isLoading = false
//            }catch (w: Exception){
//
//            }
//        }
//    }
//}
package com.example.fakestoreapp.designpattern

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.fakestoreapp.models.Product
import com.example.fakestoreapp.services.ProductService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class HomeViewModel : ViewModel() {
    var products by mutableStateOf<List<Product>>(emptyList())
        private set

    var isLoading by mutableStateOf(false)
        private set

    var error by mutableStateOf<String?>(null)
        private set

    fun loadProducts() {
        if (isLoading) return
        isLoading = true
        error = null

        viewModelScope.launch {
            try {
                val productService = RetrofitInstance.retrofit.create(ProductService::class.java)
                val result = withContext(Dispatchers.IO) { productService.getAllProducts() }
                products = result
            } catch (e: Exception) {
                error = e.message ?: "Error desconocido"
            } finally {
                isLoading = false
            }
        }
    }
}

// Puedes dejarlo aquí o en su propio archivo (RetrofitInstance.kt)
//object RetrofitInstance {
//    val retrofit: Retrofit by lazy {
//        Retrofit.Builder()
//            .baseUrl("https://fakestoreapi.com/")
//            .addConverterFactory(GsonConverterFactory.create())
//            .build()
//    }
//}
