package me.mrtkhkm.search_presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.AlertDialog
import androidx.compose.material.Button
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
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
            item {
                ReactToPagingLoadState(images.loadState.refresh) {
                    images.retry()
                }
                ReactToPagingLoadState(images.loadState.append) {
                    images.retry()
                }
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

@Composable
private fun ReactToPagingLoadState(
    loadState: LoadState,
    onRetry: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        when (loadState) {
            is LoadState.Error -> {
                Text(text = stringResource(id = R.string.error_message))
                Button(onClick = onRetry) {
                    Text(text = stringResource(id = R.string.retry))
                }
            }
            is LoadState.Loading -> {
                Loading()
            }
            else -> {}
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun SearchScreenPreview() {
    SearchScreen() {}
}