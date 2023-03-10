package me.mrtkhkm.search_presentation

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.debounce
import me.mrtkhkm.search_domain.model.Hit
import me.mrtkhkm.search_domain.use_case.SearchImageUseCase
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor(
    private val searchImageUseCase: SearchImageUseCase
) : ViewModel() {

    var state by mutableStateOf(SearchUiState(query = "fruits"))
        private set

    init {
        search()
    }

    fun onChange(query: String) {
        state = state.copy(query = query)
    }

    @OptIn(FlowPreview::class)
    fun search(): Flow<PagingData<Hit>> =
        searchImageUseCase(state.query)
            .cachedIn(viewModelScope)
            .debounce(500)
}