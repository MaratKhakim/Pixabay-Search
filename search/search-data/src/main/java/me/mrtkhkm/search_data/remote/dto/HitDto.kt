package me.mrtkhkm.search_data.remote.dto

import com.squareup.moshi.Json

data class HitDto(
    val id: String,
    val pageUrl: String,
    val type: String,
    val previewUrl: String?,
    val previewWidth: Int,
    val previewHeight: Int,
    val webformatURL: String,
    val webformatWidth: Int,
    val webformatHeight: Int,
    val largeImageUrl: String?,
    val fullHDURL: String,
    val imageUrl: String?,
    val imageWidth: Int,
    val imageHeight: Int,
    val imageSize: Int,
    val views: Int,
    @field:Json(name = "user_id")
    val userId: Int,
    val user: String,
    val userImageURL: String,
    val likes: Int,
    val downloads: Int,
    val tags: String,
    val comments: Int,
)
