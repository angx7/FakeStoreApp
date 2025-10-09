//package com.example.fakestoreapp.screens
//
//import android.util.Log
//import androidx.compose.foundation.background
//import androidx.compose.foundation.clickable
//import androidx.compose.foundation.layout.*
//import androidx.compose.foundation.lazy.LazyColumn
//import androidx.compose.foundation.lazy.LazyRow
//import androidx.compose.foundation.lazy.items
//import androidx.compose.foundation.shape.CircleShape
//import androidx.compose.foundation.shape.RoundedCornerShape
//import androidx.compose.material.icons.Icons
//import androidx.compose.material.icons.filled.AccountCircle
//import androidx.compose.material.icons.filled.ShoppingCart
//import androidx.compose.material3.Button
//import androidx.compose.material3.ButtonDefaults
//import androidx.compose.material3.Card
//import androidx.compose.material3.CardDefaults
//import androidx.compose.material3.CircularProgressIndicator
//import androidx.compose.material3.Icon
//import androidx.compose.material3.MaterialTheme
//import androidx.compose.material3.Text
//import androidx.compose.runtime.*
//import androidx.compose.ui.Alignment
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.draw.clip
//import androidx.compose.ui.graphics.Brush
//import androidx.compose.ui.graphics.Color
//import androidx.compose.ui.layout.ContentScale
//import androidx.compose.ui.text.font.FontWeight
//import androidx.compose.ui.unit.dp
//import androidx.compose.ui.unit.sp
//import androidx.navigation.NavController
//import coil3.compose.AsyncImage
//import com.example.fakestoreapp.components.ProductCard
//import com.example.fakestoreapp.models.Product
//import com.example.fakestoreapp.services.ProductService
//import com.example.fakestoreapp.ui.theme.ProductDetailScreenRoute
//import kotlinx.coroutines.Dispatchers
//import kotlinx.coroutines.withContext
//import retrofit2.Retrofit
//import retrofit2.converter.gson.GsonConverterFactory
//
//@Composable
//fun HomeScreen(navController: NavController) {
//    var productos by remember { mutableStateOf(listOf<Product>()) }
//    var isLoading by remember { mutableStateOf(true) }
//    var error by remember { mutableStateOf<String?>(null) }
//
//    LaunchedEffect(Unit) {
//        try {
//            val retrofit = Retrofit.Builder()
//                .baseUrl("https://fakestoreapi.com/")
//                .addConverterFactory(GsonConverterFactory.create())
//                .build()
//            val service = retrofit.create(ProductService::class.java)
//            val result = withContext(Dispatchers.IO) { service.getAllProducts() }
//            productos = result
//            isLoading = false
//        } catch (e: Exception) {
//            Log.e("HomeScreen", "Error: ${e.message}")
//            error = e.message
//            isLoading = false
//        }
//    }
//
//    // 3) UI
//    when {
//        isLoading -> {
//            Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
//                CircularProgressIndicator()
//            }
//        }
//        error != null -> {
//            Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
//                Text("Ocurrió un error: $error")
//            }
//        }
//        else -> {
//            val first: Product? = productos.firstOrNull()
//            val rest: List<Product> = if (productos.size > 1) productos.drop(1) else emptyList()
//            val categories = listOf("electronics", "jewelery", "men's clothing", "women's clothing")
//
//            LazyColumn(
//                modifier = Modifier
//                    .fillMaxSize()
//                    .padding(bottom = 16.dp),
//                verticalArrangement = Arrangement.spacedBy(12.dp)
//            ) {
//                // Search + icon row (simple placeholder, opcional)
//                item {
//                    TopBarStub()
//                }
//
//                // Hot Sales
//                item {
//                    SectionHeader(title = "Hot Sales", action = "see more")
//                }
//                item {
//                    first?.let {
//                        HotSaleBanner(
//                            product = it,
//                            onSee = { navController.navigate(ProductDetailScreenRoute(it.id)) }
//                        )
//                    }
//                }
//
//                // Categories
//                item {
//                    SectionHeader(title = "Select Category", action = "view all")
//                }
//                item {
//                    CategoryRow(
//                        categories = categories,
//                        onCategoryClick = { /* aquí filtrar si luego quieres */ }
//                    )
//                }
//
//                // Recently Viewed (usamos el resto de objetos)
//                if (rest.isNotEmpty()) {
//                    item {
//                        SectionHeader(title = "Recently Viewed", action = "see more")
//                    }
//                    item {
//                        RecentlyRow(
//                            products = rest,
//                            onClick = { p -> navController.navigate(ProductDetailScreenRoute(p.id)) }
//                        )
//                    }
//                }
//
//                // Grid/lista completa (si además quieres listarlo todo)
//                item {
//                    Spacer(Modifier.height(8.dp))
//                }
//                items(productos) { product ->
//                    ProductCard(
//                        product = product,
//                        onClick = { navController.navigate(ProductDetailScreenRoute(product.id)) }
//                    )
//                }
//            }
//        }
//    }
//}
//
///* ---------- Composables auxiliares ---------- */
//
//@Composable
//private fun TopBarStub() {
//    // Un encabezado mínimo para no dejar vacío el top (puedes sustituir por tu Search real)
//    Row(
//        modifier = Modifier
//            .fillMaxWidth()
//            .padding(horizontal = 16.dp, vertical = 8.dp),
//        verticalAlignment = Alignment.CenterVertically,
//        horizontalArrangement = Arrangement.SpaceBetween
//    ) {
//        Row(verticalAlignment = Alignment.CenterVertically) {
//            Box(
//                modifier = Modifier
//                    .size(36.dp)
//                    .clip(CircleShape)
//                    .background(Color(0xFFEAEAEA)),
//                contentAlignment = Alignment.Center
//            ) {
//                Icon(Icons.Default.ShoppingCart, contentDescription = null)
//            }
//            Spacer(Modifier.width(12.dp))
//            Text("Shop", fontSize = 20.sp, fontWeight = FontWeight.SemiBold)
//        }
//        Icon(Icons.Default.AccountCircle, contentDescription = null)
//
//    }
//}
//
//@Composable
//private fun SectionHeader(title: String, action: String) {
//    Row(
//        modifier = Modifier
//            .fillMaxWidth()
//            .padding(horizontal = 16.dp),
//        horizontalArrangement = Arrangement.SpaceBetween,
//        verticalAlignment = Alignment.CenterVertically
//    ) {
//        Text(title, fontSize = 20.sp, fontWeight = FontWeight.SemiBold)
//        Text(action, color = Color(0xFF6B6B6B))
//    }
//}
//
//@Composable
//private fun HotSaleBanner(product: Product, onSee: () -> Unit) {
//    // Card grande estilo “iPhone 14” del mock
//    val darkBlue = Color(0xFF0F1B3D)
//    Card(
//        modifier = Modifier
//            .padding(horizontal = 16.dp)
//            .fillMaxWidth()
//            .height(160.dp),
//        shape = RoundedCornerShape(20.dp),
//        colors = CardDefaults.cardColors(containerColor = darkBlue)
//    ) {
//        Box(Modifier.fillMaxSize()) {
//            // Fondo con degradado sutil
//            Box(
//                Modifier
//                    .matchParentSize()
//                    .background(
//                        Brush.horizontalGradient(
//                            listOf(darkBlue, darkBlue.copy(alpha = 0.85f))
//                        )
//                    )
//            )
//            // Texto
//            Column(
//                modifier = Modifier
//                    .align(Alignment.CenterStart)
//                    .padding(start = 16.dp, top = 16.dp, bottom = 16.dp),
//                verticalArrangement = Arrangement.SpaceBetween
//            ) {
//                Box(
//                    modifier = Modifier
//                        .clip(RoundedCornerShape(12.dp))
//                        .background(Color(0xFFFF8A00))
//                        .padding(horizontal = 8.dp, vertical = 4.dp)
//                ) {
//                    Text("New", color = Color.White, fontSize = 12.sp)
//                }
//                Spacer(Modifier.height(6.dp))
//                Text(
//                    text = product.title.take(20),
//                    color = Color.White,
//                    fontSize = 22.sp,
//                    fontWeight = FontWeight.Bold
//                )
//                Spacer(Modifier.height(4.dp))
//                Text(
//                    text = "Mega Deal!",
//                    color = Color(0xFFD6E0FF),
//                    fontSize = 14.sp
//                )
//                Spacer(Modifier.height(8.dp))
//                Button(
//                    onClick = onSee,
//                    shape = RoundedCornerShape(12.dp),
//                    colors = ButtonDefaults.buttonColors(containerColor = Color.White)
//                ) {
//                    Text("Buy now!", color = darkBlue, fontWeight = FontWeight.SemiBold)
//                }
//            }
//            // Imagen del producto
//            AsyncImage(
//                model = product.image,
//                contentDescription = product.title,
//                modifier = Modifier
//                    .align(Alignment.CenterEnd)
//                    .padding(end = 12.dp)
//                    .size(140.dp)
//                    .clip(RoundedCornerShape(16.dp)),
//                contentScale = ContentScale.Crop
//            )
//        }
//    }
//}
//
//@Composable
//private fun CategoryRow(
//    categories: List<String>,
//    onCategoryClick: (String) -> Unit
//) {
//    LazyRow(
//        modifier = Modifier
//            .fillMaxWidth()
//            .padding(top = 6.dp),
//        contentPadding = PaddingValues(horizontal = 16.dp),
//        horizontalArrangement = Arrangement.spacedBy(12.dp)
//    ) {
//        items(categories) { cat ->
//            CategoryItem(
//                label = cat,
//                onClick = { onCategoryClick(cat) }
//            )
//        }
//    }
//}
//
//@Composable
//private fun CategoryItem(label: String, onClick: () -> Unit) {
//    Column(
//        modifier = Modifier
//            .width(90.dp)
//            .clip(RoundedCornerShape(18.dp))
//            .background(Color(0xFFF5F5F7))
//            .clickable { onClick() }
//            .padding(vertical = 14.dp),
//        horizontalAlignment = Alignment.CenterHorizontally
//    ) {
//        // Circulito para un icono (placeholder)
//        Box(
//            modifier = Modifier
//                .size(46.dp)
//                .clip(CircleShape)
//                .background(Color.White),
//            contentAlignment = Alignment.Center
//        ) {
//            Text(label.first().uppercase(), fontWeight = FontWeight.Bold)
//        }
//        Spacer(Modifier.height(8.dp))
//        Text(
//            text = label.replaceFirstChar { if (it.isLowerCase()) it.titlecase() else it.toString() },
//            fontSize = 13.sp
//        )
//    }
//}
//
//@Composable
//private fun RecentlyRow(
//    products: List<Product>,
//    onClick: (Product) -> Unit
//) {
//    LazyRow(
//        modifier = Modifier
//            .fillMaxWidth(),
//        contentPadding = PaddingValues(horizontal = 16.dp),
//        horizontalArrangement = Arrangement.spacedBy(12.dp)
//    ) {
//        items(products) { p ->
//            RecentlyCard(product = p, onClick = { onClick(p) })
//        }
//    }
//}
//
//@Composable
//private fun RecentlyCard(product: Product, onClick: () -> Unit) {
//    Card(
//        modifier = Modifier
//            .width(180.dp)
//            .height(230.dp)
//            .clickable { onClick() },
//        shape = RoundedCornerShape(16.dp),
//        colors = CardDefaults.cardColors(containerColor = Color.White),
//        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
//    ) {
//        AsyncImage(
//            model = product.image,
//            contentDescription = product.title,
//            contentScale = ContentScale.Crop,
//            modifier = Modifier
//                .fillMaxWidth()
//                .height(130.dp)
//        )
//        Column(Modifier.padding(10.dp)) {
//            Text(
//                text = product.title,
//                maxLines = 2,
//                fontSize = 14.sp,
//                fontWeight = FontWeight.SemiBold
//            )
//            Spacer(Modifier.height(6.dp))
//            Text(
//                text = "$${"%.2f".format(product.price)}",
//                color = MaterialTheme.colorScheme.primary,
//                fontWeight = FontWeight.Bold
//            )
//        }
//    }
//}

package com.example.fakestoreapp.screens

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
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
                // TopBar
                item(span = { GridItemSpan(2) }) { TopBarStub() }

                // Hot Sales header + banner (usa primer producto)
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
                        onCategoryClick = { /* TODO: aplicar filtro si lo deseas */ }
                    )
                }

                // Recently Viewed header
                if (rest.isNotEmpty()) {
                    item(span = { GridItemSpan(2) }) {
                        SectionHeader(title = "Recently Viewed", action = "see more")
                    }
                    // Grid de productos (2 columnas)
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