package me.mrtkhkm.search_data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import me.mrtkhkm.search_data.local.dao.ImageDao
import me.mrtkhkm.search_data.local.dao.SearchQueryRemoteKeyDao
import me.mrtkhkm.search_data.local.entity.ImageEntity
import me.mrtkhkm.search_data.local.entity.SearchQueryRemoteKey

@Database(
    entities = [ImageEntity::class, SearchQueryRemoteKey::class],
    version = 1
)
abstract class ImagesDatabase: RoomDatabase() {
    abstract val imageDao: ImageDao
    abstract val searchQueryRemoteKeyDao: SearchQueryRemoteKeyDao
}