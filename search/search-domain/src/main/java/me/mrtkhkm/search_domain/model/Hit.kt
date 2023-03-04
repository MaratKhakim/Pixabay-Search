package me.mrtkhkm.search_domain.model

data class Hit(
    val id: Int = 0,
    val previewUrl: String = "",
    val imageUrl: String = "",
    val largeImageUrl: String = "",
    val user: String = "",
    val likes: Int = 0,
    val downloads: Int = 0,
    val tags: String = "",
    val comments: Int = 0,
)
