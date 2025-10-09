package com.example.fakestoreapp.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.fakestoreapp.ui.theme.* // DarkBlue, AccentOrange, CardGray, PureWhite, AccountColor, etc.
import androidx.compose.material.icons.Icons
import com.example.fakestoreapp.ui.theme.Memory as ElectronicsIcon
import com.example.fakestoreapp.ui.theme.Category as CategoryIcon
import com.example.fakestoreapp.ui.theme.Diamond as JewelryIcon
import com.example.fakestoreapp.ui.theme.Male as MaleIcon
import com.example.fakestoreapp.ui.theme.Female as FemaleIcon

@Composable
fun CategoryRow(
    categories: List<String>,
    onCategoryClick: (String) -> Unit
) {
    val ui = categories.map { mapCategory(it) }

    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        items(ui) { cat ->
            CategoryItem(
                category = cat,
                onClick = { onCategoryClick(cat.key) }
            )
        }
    }
}

private data class CategoryUi(
    val key: String,       // valor original ("electronics", ...)
    val label: String,     // etiqueta mostrada
    val icon: ImageVector, // ImageVector para el icono
    val tint: Color        // color del icono
)

@Composable
private fun mapCategory(key: String): CategoryUi {
    val normalized = key.lowercase()
    return when (normalized) {
        "electronics" -> CategoryUi(
            key = key,
            label = "Electronics",
            icon = ElectronicsIcon,
            tint = DarkBlue
        )
        "jewelery", "jewelry" -> CategoryUi(
            key = key,
            label = "Jewelery",
            icon = JewelryIcon,
            tint = AccountColor
        )
        "men's clothing" -> CategoryUi(
            key = key,
            label = "Men",
            icon = MaleIcon,
            tint = AccountColor
        )
        "women's clothing" -> CategoryUi(
            key = key,
            label = "Women",
            icon = FemaleIcon,
            tint = AccountColor
        )
        else -> CategoryUi(
            key = key,
            label = key.replaceFirstChar { if (it.isLowerCase()) it.titlecase() else it.toString() },
            icon = CategoryIcon,
            tint = AccountColor
        )
    }
}

@Composable
private fun CategoryItem(
    category: CategoryUi,
    onClick: () -> Unit
) {
    Column(
        modifier = Modifier
            .width(100.dp)
            .clip(RoundedCornerShape(18.dp))
            .background(CardGray)
            .clickable { onClick() }
            .padding(vertical = 14.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            modifier = Modifier
                .size(46.dp)
                .clip(CircleShape)
                .background(PureWhite),
            contentAlignment = Alignment.Center
        ) {
            Icon(
                imageVector = category.icon,
                contentDescription = category.label,
                tint = category.tint
            )
        }
        Spacer(Modifier.height(8.dp))
        Text(
            text = category.label,
            fontSize = 13.sp,
            maxLines = 1,
            color = AccountColor,
            fontWeight = FontWeight.Medium
        )
    }
}
