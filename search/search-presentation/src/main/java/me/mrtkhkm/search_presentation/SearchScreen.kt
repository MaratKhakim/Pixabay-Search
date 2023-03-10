package me.mrtkhkm.search_presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
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
import me.mrtkhkm.search_presentation.components.CardItem
import me.mrtkhkm.search_presentation.components.SearchInput
import me.mrtkhkm.ui.LocalSpacing
import me.mrtkhkm.common.R

@Composable
fun SearchScreen(
    viewModel: SearchViewModel = hiltViewModel()
) {
    val spacing = LocalSpacing.current
    val state = viewModel.state
    val images = viewModel.search().collectAsLazyPagingItems()

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
            ) {
                CardItem(hit = it!!)
            }
            when (images.loadState.append) {
                is LoadState.Error -> {
                    item {
                        Text(text = stringResource(id = R.string.error_message))
                    }
                }
                is LoadState.Loading -> {
                    item {

                    }
                }
                else -> {}
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun SearchScreenPreview() {
    SearchScreen()
}