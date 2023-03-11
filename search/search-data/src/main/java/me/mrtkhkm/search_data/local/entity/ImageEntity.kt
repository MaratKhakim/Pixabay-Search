package me.mrtkhkm.search_data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity (tableName = "images_table")
data class ImageEntity(
    @PrimaryKey
    val id: String,
    val imageUrl: String,
    val largeImageUrl: String,
    val webformatURL: String,
    val user: String,
    val userImageURL: String,
    val likes: Int,
    val downloads: Int,
    val tags: String,
    val comments: Int,
    val views: Int,
)
