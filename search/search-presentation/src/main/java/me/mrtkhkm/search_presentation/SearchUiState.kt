package me.mrtkhkm.search_presentation

import me.mrtkhkm.model.Hit

data class SearchUiState(
    val query: String = "",
    val openDialog: Boolean = false,
    val currentHit: Hit = Hit()
)