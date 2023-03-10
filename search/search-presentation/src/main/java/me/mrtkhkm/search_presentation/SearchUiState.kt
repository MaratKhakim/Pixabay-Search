package me.mrtkhkm.search_presentation


data class SearchUiState(
    val query: String = "",
    val openDialog: Boolean = false,
)