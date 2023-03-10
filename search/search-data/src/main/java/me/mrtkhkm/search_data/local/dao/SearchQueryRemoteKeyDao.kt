package me.mrtkhkm.search_data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import me.mrtkhkm.search_data.local.entity.SearchQueryRemoteKey

@Dao
interface SearchQueryRemoteKeyDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(remoteKey: List<SearchQueryRemoteKey>)

    @Query("SELECT * FROM search_query_remote_keys WHERE id = :imageId")
    suspend fun remoteKeysByImageId(imageId: String): SearchQueryRemoteKey

    @Query("DELETE FROM search_query_remote_keys")
    suspend fun clearRemoteKeys()
}