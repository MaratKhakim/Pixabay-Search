package me.mrtkhkm.search_domain.use_case

import me.mrtkhkm.search_domain.model.Hit
import me.mrtkhkm.search_domain.repository.SearchRepository

class SearchImageUseCase(
    private val searchRepository: SearchRepository
) {
    suspend operator fun invoke(
        key: String,
        query: String,
        page: Int,
        perPage: Int
    ): Result<List<Hit>> {
        return searchRepository.searchImage(key, query, page, perPage)
    }
}