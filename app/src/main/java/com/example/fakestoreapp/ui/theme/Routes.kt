package com.example.fakestoreapp.ui.theme

import com.example.fakestoreapp.models.Product
import kotlinx.serialization.Serializable

@Serializable
object HomeScreenRoute

@Serializable
data class ProductDetailScreenRoute(val id: Int)