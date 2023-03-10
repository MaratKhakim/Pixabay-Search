package me.mrtkhkm.search_data.local.dao

import androidx.paging.PagingSource
import androidx.room.*
import me.mrtkhkm.search_data.local.entity.ImageEntity

@Dao
interface ImageDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertImages(images: List<ImageEntity>)

    @Query("DELETE FROM images_table")
    suspend fun deleteImages()

    @Query("SELECT * FROM images_table")
    fun getImages(): PagingSource<Int, ImageEntity>
}