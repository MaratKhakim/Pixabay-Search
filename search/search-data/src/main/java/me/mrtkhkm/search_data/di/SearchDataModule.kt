package me.mrtkhkm.search_data.di

import android.app.Application
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import me.mrtkhkm.search_data.BuildConfig
import me.mrtkhkm.search_data.local.ImagesDatabase
import me.mrtkhkm.search_data.remote.SearchApi
import me.mrtkhkm.search_data.repository.SearchRepositoryImpl
import me.mrtkhkm.search_domain.repository.SearchRepository
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.create
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object SearchDataModule {
    @Provides
    @Singleton
    fun provideOkHttpClient(): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(
                HttpLoggingInterceptor().apply {
                    level = HttpLoggingInterceptor.Level.BODY
                }
            )
            .build()
    }

    @Provides
    @Singleton
    fun provideSearchApi(client: OkHttpClient): SearchApi {
        return Retrofit.Builder()
            .baseUrl(BuildConfig.BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create())
            .client(client)
            .build()
            .create()
    }

    @Provides
    @Singleton
    fun provideSearchRepository(api: SearchApi, database: ImagesDatabase): SearchRepository {
        return SearchRepositoryImpl(api, database)
    }

    @Provides
    @Singleton
    fun provideTrackerDatabase(app: Application): ImagesDatabase {
        return Room.databaseBuilder(
            app,
            ImagesDatabase::class.java,
            "images_db"
        ).build()
    }
}