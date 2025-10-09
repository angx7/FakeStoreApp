package com.example.fakestoreapp.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.fakestoreapp.ui.theme.AccentOrange
import com.example.fakestoreapp.ui.theme.AccountColor
import com.example.fakestoreapp.ui.theme.Star
import com.example.fakestoreapp.ui.theme.Star_half
import com.example.fakestoreapp.ui.theme.TextGray

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
