package me.mrtkhkm.search_domain.repository

import kotlinx.coroutines.flow.Flow
import me.mrtkhkm.search_domain.model.Hit

interface SearchRepository {
    suspend fun searchImage(
        query: String
    ): Flow<List<Hit>>
}