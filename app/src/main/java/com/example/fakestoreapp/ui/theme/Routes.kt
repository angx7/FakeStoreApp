package com.example.fakestoreapp.ui.theme

import androidx.compose.foundation.layout.PaddingValues
import com.example.fakestoreapp.models.Product
import kotlinx.serialization.Serializable

@Serializable
object HomeScreenRoute

@Serializable
data class ProductDetailScreenRoute(val id: Int)