package com.example.fakestoreapp.screens

import android.util.Log
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.fakestoreapp.components.CategoryRow
import com.example.fakestoreapp.components.EmptyBannerPLaceholder
import com.example.fakestoreapp.components.GridProductCard
import com.example.fakestoreapp.components.HotSaleBanner
import com.example.fakestoreapp.components.SectionHeader
import com.example.fakestoreapp.components.TopBarStub
import com.example.fakestoreapp.models.Product
import com.example.fakestoreapp.services.ProductService
import com.example.fakestoreapp.ui.theme.ProductDetailScreenRoute
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Composable
fun HomeScreen(navController: NavController, paddingValues: PaddingValues) {
    var productos by remember { mutableStateOf(listOf<Product>()) }
    var isLoading by remember { mutableStateOf(true) }
    var error by remember { mutableStateOf<String?>(null) }

    LaunchedEffect(Unit) {
        try {
            val retrofit = Retrofit.Builder()
                .baseUrl("https://fakestoreapi.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
            val service = retrofit.create(ProductService::class.java)
            val result = withContext(Dispatchers.IO) { service.getAllProducts() }
            productos = result
            isLoading = false
        } catch (e: Exception) {
            Log.e("HomeScreen", "Error: ${e.message}")
            error = e.message
            isLoading = false
        }
    }

    when {
        isLoading -> {
            Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                CircularProgressIndicator()
            }
        }
        error != null -> {
            Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                Text("Ocurrió un error: $error")
            }
        }
        else -> {
            val first = productos.firstOrNull()
            val rest = if (productos.size > 1) productos.drop(1) else emptyList()
            val categories = listOf("electronics", "jewelery", "men's clothing", "women's clothing")

            LazyVerticalGrid(
                columns = GridCells.Fixed(2),
                modifier = Modifier
                    .fillMaxSize()
                    .padding(bottom = 16.dp)
                    .padding(paddingValues),
                horizontalArrangement = Arrangement.spacedBy(12.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp),
                contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp)
            ) {

                item(span = { GridItemSpan(2) }) { TopBarStub() }

                item(span = { GridItemSpan(2) }) {
                    SectionHeader(title = "Hot Sales", action = "see more")
                }
                item(span = { GridItemSpan(2) }) {
                    if (first != null) {
                        HotSaleBanner(
                            product = first,
                            onSee = { navController.navigate(ProductDetailScreenRoute(first.id)) }
                        )
                    } else {
                        EmptyBannerPLaceholder()
                    }
                }

                // Categories
                item(span = { GridItemSpan(2) }) {
                    SectionHeader(title = "Select Category", action = "view all")
                }
                item(span = { GridItemSpan(2) }) {
                    CategoryRow(
                        categories = categories,
                        onCategoryClick = {  }
                    )
                }

                if (rest.isNotEmpty()) {
                    item(span = { GridItemSpan(2) }) {
                        SectionHeader(title = "Recently Viewed", action = "see more")
                    }

                    items(rest) { p ->
                        GridProductCard(
                            product = p,
                            onClick = { navController.navigate(ProductDetailScreenRoute(p.id)) }
                        )
                    }
                }
            }
        }
    }
}