package me.mrtkhkm.search_data.remote.dto

data class HitDto(
    val id: Int,
    val previewUrl: String?,
    val imageUrl: String?,
    val largeImageUrl: String?,
    val webformatURL: String,
    val userId: Int,
    val user: String,
    val likes: Int,
    val downloads: Int,
    val tags: String,
    val comments: Int,
    val views: Int,
)
