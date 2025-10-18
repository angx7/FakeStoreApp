package com.example.fakestoreapp.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.fakestoreapp.components.CategoryRow
import com.example.fakestoreapp.components.EmptyBannerPLaceholder
import com.example.fakestoreapp.components.GridProductCard
import com.example.fakestoreapp.components.HotSaleBanner
import com.example.fakestoreapp.components.SectionHeader
import com.example.fakestoreapp.components.TopBarStub
import com.example.fakestoreapp.designpattern.HomeViewModel
import com.example.fakestoreapp.ui.theme.ProductDetailScreenRoute

@Composable
fun HomeScreen(navController: NavController, paddingValues: PaddingValues) {
    val viewModel: HomeViewModel = viewModel()

    // Cargar una sola vez al entrar
    LaunchedEffect(Unit) {
        viewModel.loadProducts()
    }

    when {
        viewModel.isLoading -> {
            Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                CircularProgressIndicator()
            }
        }
        viewModel.error != null -> {
            Box(Modifier
                .fillMaxSize()
                .padding(paddingValues),
                contentAlignment = Alignment.Center
            ) {
                Text("Ocurrió un error: ${viewModel.error}")
            }
        }
        else -> {
            val productos = viewModel.products
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

                // Hot sales
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
                        onCategoryClick = { /* TODO: filtrar por categoría si quieres */ }
                    )
                }

                // Grid de productos
                if (rest.isNotEmpty()) {
                    item(span = { GridItemSpan(2) }) {
                        SectionHeader(title = "Recently Viewed", action = "see more")
                    }
                    items(rest, key = { it.id }) { p ->
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
