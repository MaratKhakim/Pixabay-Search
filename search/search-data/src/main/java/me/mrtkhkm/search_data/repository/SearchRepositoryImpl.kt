package me.mrtkhkm.search_data.repository

import me.mrtkhkm.search_data.mapper.toHit
import me.mrtkhkm.search_data.remote.SearchApi
import me.mrtkhkm.search_domain.model.Hit
import me.mrtkhkm.search_domain.repository.SearchRepository

class SearchRepositoryImpl(
    private val searchApi: SearchApi
): SearchRepository {
    override suspend fun searchImage(
        key: String,
        query: String,
        page: Int,
        perPage: Int
    ): Result<List<Hit>> {
        return try {
            val searchDto = searchApi.searchImage(key, query, page, perPage)
            return Result.success(
                searchDto.hits
                    .map { it.toHit() }
            )
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}