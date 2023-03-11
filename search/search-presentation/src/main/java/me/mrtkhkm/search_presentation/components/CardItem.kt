package me.mrtkhkm.search_presentation.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Warning
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.SubcomposeAsyncImage
import me.mrtkhkm.common.R
import me.mrtkhkm.model.Hit
import me.mrtkhkm.ui.Loading
import me.mrtkhkm.ui.LocalSpacing
import me.mrtkhkm.ui.Tags

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun CardItem(
    hit: Hit,
    onClick: (hit: Hit) -> Unit
) {
    val spacing = LocalSpacing.current

    Card(
        modifier = Modifier
            .fillMaxWidth(),
        backgroundColor = Color.Gray.copy(alpha = 0.2f),
        shape = RoundedCornerShape(10.dp),
        elevation = 0.dp,
        onClick = { onClick(hit) }
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
                },
                error = {
                    Icon(
                        imageVector = Icons.Outlined.Warning,
                        contentDescription = null,
                        tint = MaterialTheme.colors.error
                    )
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

@Preview(showBackground = true)
@Composable
private fun Preview() {
    Tags("first, second, third")
}