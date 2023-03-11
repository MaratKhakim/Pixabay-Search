package me.mrtkhkm.model

data class Hit(
    val id: String = "",
    val imageUrl: String = "",
    val largeImageUrl: String = "",
    val webformatURL: String = "",
    val user: String = "",
    val userImageURL: String = "",
    val likes: Int = 0,
    val downloads: Int = 0,
    val tags: String = "",
    val comments: Int = 0,
    val views: Int = 0,
)
