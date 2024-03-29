package me.mrtkhkm.search_domain.repository

import androidx.paging.PagingData
import kotlinx.coroutines.flow.Flow
import me.mrtkhkm.model.Hit

interface SearchRepository {
    fun searchImage(
        query: String,
    ): Flow<PagingData<Hit>>
}