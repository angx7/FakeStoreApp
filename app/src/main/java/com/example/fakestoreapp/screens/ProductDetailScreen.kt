package com.example.fakestoreapp.screens

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import com.example.fakestoreapp.models.Product
import com.example.fakestoreapp.services.ProductService
import com.example.fakestoreapp.ui.theme.* // << importa tus colores
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import kotlin.math.floor

@Composable
fun ProductDetailScreen(id: Int, paddingValues: PaddingValues = PaddingValues()) {
    val BASE_URL = "https://fakestoreapi.com/"

    var product by remember { mutableStateOf<Product?>(null) }
    var isLoading by remember { mutableStateOf(true) }
    var error by remember { mutableStateOf<String?>(null) }

    LaunchedEffect(id) {
        try {
            val retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
            val service = retrofit.create(ProductService::class.java)
            val result = withContext(Dispatchers.IO) { service.getProductById(id) }
            product = result
            isLoading = false
            Log.i("ProductDetailScreen", "Producto recibido: $result")
        } catch (e: Exception) {
            error = e.message
            isLoading = false
            Log.e("ProductDetailScreen", "Error: ${e.message}")
        }
    }

    when {
        isLoading -> {
            Box(Modifier
                .fillMaxSize()
                .padding(paddingValues), contentAlignment = Alignment.Center) {
                CircularProgressIndicator()
            }
        }
        error != null -> {
            Box(Modifier
                .fillMaxSize()
                .padding(paddingValues), contentAlignment = Alignment.Center) {
                Text("Ocurrió un error: $error")
            }
        }
        else -> {
            val p = product!!

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
                    .background(CardGray) // fondo general
                    .padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(320.dp),
                    shape = RoundedCornerShape(28.dp),
                    colors = CardDefaults.cardColors(containerColor = BannerPlaceholder),
                    elevation = CardDefaults.cardElevation(defaultElevation = 0.dp)
                ) {
                    Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                        AsyncImage(
                            model = p.image,
                            contentDescription = p.title,
                            contentScale = ContentScale.Fit,
                            modifier = Modifier
                                .fillMaxWidth(0.85f)
                                .fillMaxHeight(0.85f)
                        )
                    }
                }

                // --- Título ---
                Text(
                    text = p.title,
                    style = MaterialTheme.typography.titleLarge,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis,
                    color = AccountColor
                )

                Row (
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ){
                    // --- Precio ---
                    Text(
                        text = "$${"%.2f".format(p.price)}",
                        style = MaterialTheme.typography.titleMedium,
                        color = DarkBlue
                    )

                    RatingStars(
                        rating = p.rating?.rate?.toDouble() ?: 0.0,
                        count   = p.rating?.count ?: 0
                    )
                }

                Spacer(Modifier.height(8.dp))


                val scrollState = rememberScrollState()

                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .heightIn(max = 300.dp)
                        .verticalScroll(scrollState)
                ) {
                    Text(
                        text = p.description,
                        style = MaterialTheme.typography.bodyMedium
                    )
                }

                Spacer(Modifier.weight(1f))

                // --- Botones ---
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(12.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Button(
                        onClick = { /* TODO: acción comprar */ },
                        modifier = Modifier
                            .weight(1f)
                            .height(48.dp),
                        shape = RoundedCornerShape(14.dp),
                        colors = ButtonDefaults.buttonColors(containerColor = DarkBlue) // primario
                    ) {
                        Text("ORDER NOW", color = PureWhite, fontWeight = FontWeight.SemiBold)
                    }

                    OutlinedButton(
                        onClick = {  },
                        modifier = Modifier
                            .weight(1f)
                            .height(48.dp),
                        shape = RoundedCornerShape(14.dp),
                        border = ButtonDefaults.outlinedButtonBorder(true),
                        colors = ButtonDefaults.outlinedButtonColors(contentColor = DarkBlue) // texto/borde
                    ) {
                        Text("Add To Wishlist", color = DarkBlue)
                    }
                }
            }
        }
    }
}

/* ----------------- Auxiliares ----------------- */


@Composable
fun RatingStars(
    rating: Double,
    count: Int,
    max: Int = 5,
    filledColor: Color = AccentOrange,
    emptyColor: Color = AccountColor,
    textColor: Color = TextGray,
    halfThreshold: Double = 0.5,
    emptyThreshold: Double = 0.4
) {
    val clamped = rating.coerceIn(0.0, max.toDouble())
    val baseFull = kotlin.math.floor(clamped).toInt().coerceIn(0, max)
    val frac = clamped - baseFull

    var extraFull = 0
    var half = 0
    if (baseFull < max) {
        when {
            frac > halfThreshold -> half = 1
            frac < emptyThreshold -> {  }
            else -> extraFull = 1
        }
    }

    val full = (baseFull + extraFull).coerceAtMost(max)
    val empty = (max - full - half).coerceAtLeast(0)

    Row(verticalAlignment = Alignment.CenterVertically) {
        repeat(full) { Icon(imageVector = Star, contentDescription = null, tint = filledColor) }
        repeat(half) { Icon(imageVector = Star_half, contentDescription = null, tint = filledColor) }
        repeat(empty) { Icon(imageVector = Star, contentDescription = null, tint = emptyColor.copy(alpha = 0.45f)) }

        Spacer(Modifier.width(8.dp))
        Text(text = "${"%.1f".format(rating)} ($count)", color = textColor)
    }
}
