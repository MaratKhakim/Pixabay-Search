package me.mrtkhkm.search_domain.use_case

import androidx.paging.PagingData
import kotlinx.coroutines.flow.Flow
import me.mrtkhkm.model.Hit
import me.mrtkhkm.search_domain.repository.SearchRepository

class SearchImageUseCase(
    private val searchRepository: SearchRepository
) {
    operator fun invoke(
        query: String,
    ): Flow<PagingData<me.mrtkhkm.model.Hit>> {
        return searchRepository.searchImage(query)
    }
}