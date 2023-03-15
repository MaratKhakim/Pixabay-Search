package me.mrtkhkm.search_data.repository

import androidx.paging.PagingData
import androidx.paging.map
import io.mockk.coEvery
import io.mockk.mockk
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.test.runTest
import me.mrtkhkm.search_data.model.TestModel
import me.mrtkhkm.search_domain.use_case.SearchImageUseCase
import org.junit.Before
import org.junit.Test

@OptIn(ExperimentalCoroutinesApi::class)
class SearchRepositoryImplTest {
    private lateinit var repository: SearchRepositoryImpl
    private lateinit var searchImageUseCase: SearchImageUseCase

    @Before
    fun setUp() {
        repository = mockk(relaxed = true)
        searchImageUseCase = SearchImageUseCase(repository)
    }

    @Test
    fun `Search images, valid response, returns results`(): Unit = runTest {
        val pagingData = PagingData.from(
            TestModel.hits
        )
        coEvery { repository.searchImage(TestModel.query) } returns flowOf(pagingData)
        val result = searchImageUseCase(TestModel.query).first()

        result.map{
            assertEquals(TestModel.firstHit.id, it.id)
        }
    }
}