package me.mrtkhkm.search_data.remote

import me.mrtkhkm.search_data.remote.dto.SearchDto
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface SearchApi {
    @GET("/api")
    suspend fun searchImage(
        @Query("key")key: String,
        @Query("q") query: String,
        @Query("page") page: Int,
        @Query("per_page") perPage: Int
    ): SearchDto
}