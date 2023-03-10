package me.mrtkhkm.search_data.mediator

import androidx.paging.ExperimentalPagingApi
import androidx.paging.LoadType
import androidx.paging.PagingState
import androidx.paging.RemoteMediator
import androidx.room.withTransaction
import me.mrtkhkm.search_data.BuildConfig
import me.mrtkhkm.search_data.local.ImagesDatabase
import me.mrtkhkm.search_data.local.entity.ImageEntity
import me.mrtkhkm.search_data.local.entity.SearchQueryRemoteKey
import me.mrtkhkm.search_data.mapper.asEntity
import me.mrtkhkm.search_data.remote.SearchApi
import retrofit2.HttpException
import java.io.IOException

private const val STARTING_PAGE_INDEX = 1

@OptIn(ExperimentalPagingApi::class)
class SearchImagesRemoteMediator(
    private val apiKey: String,
    private val searchQuery: String,
    private val searchApi: SearchApi,
    private val imagesDatabase: ImagesDatabase
) : RemoteMediator<Int, ImageEntity>() {
    private val imageDao = imagesDatabase.imageDao
    private val searchQueryRemoteKeyDao = imagesDatabase.searchQueryRemoteKeyDao

    override suspend fun load(
        loadType: LoadType,
        state: PagingState<Int, ImageEntity>
    ): MediatorResult {
        val page = when (loadType) {
            LoadType.REFRESH -> {
                val remoteKeys = getRemoteKeyClosestToCurrentPosition(state)
                remoteKeys?.nextPageKey?.minus(1) ?: STARTING_PAGE_INDEX
            }
            LoadType.PREPEND -> return MediatorResult.Success(endOfPaginationReached = true)
            LoadType.APPEND -> {
                val remoteKeys = getRemoteKeyForLastItem(state)
                val nextPageKey =
                    remoteKeys?.nextPageKey ?: return MediatorResult.Success(endOfPaginationReached = true)
                nextPageKey
            }
        }

        try {
            val response = searchApi.searchImage(apiKey, searchQuery, page, BuildConfig.PER_PAGE)
            val hitDtoList = response.hits
            val imageEntities = hitDtoList.map { it.asEntity() }

            val endOfPaginationReached = hitDtoList.size < state.config.pageSize
            val prevKey = if (page == STARTING_PAGE_INDEX) null else page - 1
            val nextKey = if (endOfPaginationReached) null else page + 1

            imagesDatabase.withTransaction {
                if (loadType == LoadType.REFRESH) {
                    imageDao.deleteImages()
                    searchQueryRemoteKeyDao.clearRemoteKeys()
                }

                val keys = imageEntities.map {
                    SearchQueryRemoteKey(
                        id = it.id,
                        prevPageKey = prevKey,
                        nextPageKey = nextKey
                    )
                }
                searchQueryRemoteKeyDao.insertAll(keys)
                imageDao.insertImages(imageEntities)
            }
            return MediatorResult.Success(endOfPaginationReached = endOfPaginationReached)
        } catch (exception: IOException) {
            return MediatorResult.Error(exception)
        } catch (exception: HttpException) {
            return MediatorResult.Error(exception)
        }
    }

    private suspend fun getRemoteKeyForLastItem(state: PagingState<Int, ImageEntity>): SearchQueryRemoteKey? {
        return state.pages.lastOrNull { it.data.isNotEmpty() }?.data?.lastOrNull()
            ?.let { image ->
                searchQueryRemoteKeyDao.remoteKeysByImageId(image.id)
            }
    }

    private suspend fun getRemoteKeyClosestToCurrentPosition(state: PagingState<Int, ImageEntity>): SearchQueryRemoteKey? {
        return state.anchorPosition?.let { position ->
            state.closestItemToPosition(position)?.id?.let { id ->
                searchQueryRemoteKeyDao.remoteKeysByImageId(id)
            }
        }
    }
}