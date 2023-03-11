package me.mrtkhkm.ui

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@Composable
fun Tags(tags: String) {
    Row {
        tags.split(",").forEach { tag ->
            Text(
                modifier = Modifier
                    .padding(end = 4.dp),
                style = TextStyle(color = Color.Blue, fontWeight = FontWeight.Bold),
                text = "#${tag.trim()}"
            )
        }
    }
}