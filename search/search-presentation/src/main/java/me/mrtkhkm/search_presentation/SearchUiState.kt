package me.mrtkhkm.search_presentation

import me.mrtkhkm.search_domain.model.Hit

data class SearchUiState(
    val hits: List<Hit> = emptyList()
)