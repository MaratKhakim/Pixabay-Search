package me.mrtkhkm.search_presentation.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.SubcomposeAsyncImage
import me.mrtkhkm.common.R
import me.mrtkhkm.search_domain.model.Hit
import me.mrtkhkm.ui.Loading
import me.mrtkhkm.ui.LocalSpacing

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun CardItem(
    hit: Hit,
    onClick: () -> Unit
) {
    val spacing = LocalSpacing.current

    Card(
        modifier = Modifier
            .fillMaxWidth(),
        backgroundColor = Color.Gray.copy(alpha = 0.2f),
        shape = RoundedCornerShape(10.dp),
        elevation = 0.dp,
        onClick = onClick
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxWidth()

        ) {
            SubcomposeAsyncImage(
                model = hit.webformatURL,
                contentDescription = hit.id,
                contentScale = ContentScale.FillBounds,
                modifier = Modifier
                    .height(180.dp)
                    .fillMaxWidth(),
                loading = {
                    Loading()
                }
            )
            Spacer(modifier = Modifier.height(spacing.spaceMedium))
            Text(text = stringResource(id = R.string.author, hit.user))
            Spacer(modifier = Modifier.height(spacing.spaceMedium))
            Tags(hit.tags)
            Spacer(modifier = Modifier.height(spacing.spaceMedium))
        }
    }
}

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

@Preview(showBackground = true)
@Composable
private fun Preview() {
    Tags("first, second, third")
}