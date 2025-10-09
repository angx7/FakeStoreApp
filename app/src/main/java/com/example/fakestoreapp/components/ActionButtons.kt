package com.example.fakestoreapp.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.fakestoreapp.ui.theme.DarkBlue
import com.example.fakestoreapp.ui.theme.PureWhite

@Composable
fun ActionButtons(){
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(12.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Button(
            onClick = {  },
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