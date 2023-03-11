package me.mrtkhkm.detail_presentation

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.outlined.Warning
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import coil.compose.SubcomposeAsyncImage
import me.mrtkhkm.common.R
import me.mrtkhkm.model.Hit
import me.mrtkhkm.ui.Loading
import me.mrtkhkm.ui.LocalSpacing
import me.mrtkhkm.ui.Tags

@Composable
fun DetailsScreen(
    hit: Hit
) {
    val spacing = LocalSpacing.current
    Column(
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxWidth()
            .padding(spacing.spaceMedium)
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
        ) {
            SubcomposeAsyncImage(
                model = hit.userImageURL,
                contentDescription = hit.id,
                contentScale = ContentScale.FillBounds,
                modifier = Modifier
                    .height(60.dp)
                    .clip(CircleShape)
                    .aspectRatio(1f),
                loading = {
                    Loading()
                },
                error = {
                    Icon(imageVector = Icons.Filled.AccountCircle, contentDescription = null)
                }
            )
            Text(modifier = Modifier.padding(start =  spacing.spaceSmall), text = hit.user)
        }
        Spacer(modifier = Modifier.height(spacing.spaceMedium))
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
                Icon(imageVector = Icons.Outlined.Warning, contentDescription = null, tint = MaterialTheme.colors.error)
            }
        )
        Spacer(modifier = Modifier.height(spacing.spaceMedium))
        Tags(hit.tags)
        Text(text = stringResource(id = R.string.likes, hit.likes))
        Text(text = stringResource(id = R.string.downloads, hit.downloads))
        Text(text = stringResource(id = R.string.comments, hit.comments))
    }
}