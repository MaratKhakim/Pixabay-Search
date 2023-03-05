package me.mrtkhkm.search_domain.repository

import me.mrtkhkm.search_domain.model.Hit

interface SearchRepository {
    suspend fun searchImage(
        query: String,
        page: Int,
        perPage: Int
    ): Result<List<Hit>>
}