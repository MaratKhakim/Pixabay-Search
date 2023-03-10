package me.mrtkhkm.search_data.repository

import androidx.paging.*
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import me.mrtkhkm.search_data.BuildConfig
import me.mrtkhkm.search_data.local.ImagesDatabase
import me.mrtkhkm.search_data.mapper.asExternalModel
import me.mrtkhkm.search_data.mediator.SearchImagesRemoteMediator
import me.mrtkhkm.search_data.remote.SearchApi
import me.mrtkhkm.search_domain.model.Hit
import me.mrtkhkm.search_domain.repository.SearchRepository
import javax.inject.Inject

@OptIn(ExperimentalPagingApi::class)
class SearchRepositoryImpl @Inject constructor(
    private val searchApi: SearchApi,
    private val imagesDatabase: ImagesDatabase,
) : SearchRepository {
    override fun searchImage(
        query: String,
    ): Flow<PagingData<Hit>> =
        Pager(
            config = PagingConfig(pageSize = 10),
            remoteMediator = SearchImagesRemoteMediator(BuildConfig.PIXABAY_API_KEY, query, searchApi, imagesDatabase),
            pagingSourceFactory = { imagesDatabase.imageDao.getImages() }
        ).flow.map { it.map { it.asExternalModel() } }
}