package me.mrtkhkm.search_presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.AlertDialog
import androidx.compose.material.Button
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.paging.LoadState
import androidx.paging.compose.collectAsLazyPagingItems
import androidx.paging.compose.items
import me.mrtkhkm.common.R
import me.mrtkhkm.model.Hit
import me.mrtkhkm.search_presentation.components.CardItem
import me.mrtkhkm.search_presentation.components.SearchInput
import me.mrtkhkm.ui.Loading
import me.mrtkhkm.ui.LocalSpacing

@Composable
fun SearchScreen(
    viewModel: SearchViewModel = hiltViewModel(),
    onNavigateToDetails: (hit: Hit) -> Unit
) {
    val spacing = LocalSpacing.current
    val state = viewModel.state
    val images = viewModel.pagingState.collectAsLazyPagingItems()

    if (state.openDialog) {
        Dialog(
            viewModel = viewModel,
            onNavigateToDetails = { onNavigateToDetails(state.currentHit) }
        )
    }

    Scaffold(
        topBar = {
            SearchInput(
                value = state.query,
                onValueChange = {
                    viewModel.onChange(it)
                }
            )
        }
    ) {
        LazyColumn(
            Modifier
                .fillMaxSize()
                .padding(horizontal = spacing.spaceMedium),
            verticalArrangement = Arrangement.spacedBy(spacing.spaceMedium),
        ) {
            items(
                items = images,
                key = { hit ->
                    hit.id
                }
            ) { hit ->
                hit?.let {
                    CardItem(
                        hit = it,
                        onClick = { selectedHit ->
                            viewModel.onOpenDialog()
                            viewModel.onSelectHit(selectedHit)
                        }
                    )
                }
            }
            when (images.loadState.append) {
                is LoadState.Error -> {
                    item {
                        Text(text = stringResource(id = R.string.error_message))
                    }
                }
                is LoadState.Loading -> {
                    item {
                        Loading()
                    }
                }
                else -> {}
            }
        }
    }
}

@Composable
fun Dialog(
    viewModel: SearchViewModel,
    onNavigateToDetails: () -> Unit,
) {
    AlertDialog(
        title = {
            Text(text = stringResource(id = R.string.dialog_title))
        },
        text = {
            Text(text = stringResource(id = R.string.dialog_description))
        },
        onDismissRequest = {
            viewModel.onCloseDialog()
        },
        confirmButton = {
            Button(
                onClick = {
                    viewModel.onCloseDialog()
                    onNavigateToDetails()
                }
            ) {
                Text(text = stringResource(id = R.string.yes))
            }
        },
        dismissButton = {
            Button(
                onClick = {
                    viewModel.onCloseDialog()
                }
            ) {
                Text(text = stringResource(id = R.string.no))
            }
        }
    )
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun SearchScreenPreview() {
    SearchScreen() {}
}