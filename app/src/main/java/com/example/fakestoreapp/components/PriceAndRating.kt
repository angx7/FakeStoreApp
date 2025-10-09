package com.example.fakestoreapp.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.fakestoreapp.models.Product
import com.example.fakestoreapp.screens.RatingStars
import com.example.fakestoreapp.ui.theme.DarkBlue

@Composable
fun PriceAndRating(p: Product){
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
}