package me.mrtkhkm.search_data.remote.dto

data class SearchDto(
    val total: Int,
    val totalHits: Int,
    val hits: List<HitDto>
)