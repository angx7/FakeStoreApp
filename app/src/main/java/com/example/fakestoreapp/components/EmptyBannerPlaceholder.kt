package com.example.fakestoreapp.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import com.example.fakestoreapp.ui.theme.BannerPlaceholder
import com.example.fakestoreapp.ui.theme.TextGray

@Composable
fun EmptyBannerPLaceholder() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(160.dp)
            .clip(RoundedCornerShape(20.dp))
            .background(BannerPlaceholder),
        contentAlignment = Alignment.Center
    ) {
        Text("Sin productos", color = TextGray)
    }
}