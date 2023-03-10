package me.mrtkhkm.search_data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "search_query_remote_keys")
data class SearchQueryRemoteKey(
    @PrimaryKey val id: String,
    val prevPageKey: Int?,
    val nextPageKey: Int?,
)