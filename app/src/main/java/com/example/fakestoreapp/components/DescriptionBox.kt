package com.example.fakestoreapp.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.fakestoreapp.models.Product

@Composable
fun DescriptionBox(p: Product){
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
}