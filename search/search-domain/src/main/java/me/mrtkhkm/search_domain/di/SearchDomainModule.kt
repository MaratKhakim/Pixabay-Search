package me.mrtkhkm.search_domain.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped
import me.mrtkhkm.search_domain.repository.SearchRepository
import me.mrtkhkm.search_domain.use_case.SearchImageUseCase

@Module
@InstallIn(ViewModelComponent::class)
object SearchDomainModule {

    @Provides
    @ViewModelScoped
    fun provideSearchImageUseCase(
        searchRepository: SearchRepository
    ): SearchImageUseCase {
        return SearchImageUseCase(searchRepository)
    }
}