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
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import me.mrtkhkm.model.Hit
import me.mrtkhkm.search_domain.use_case.SearchImageUseCase
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor(
    private val searchImageUseCase: SearchImageUseCase
) : ViewModel() {

    var state by mutableStateOf(SearchUiState(query = "fruits"))
        private set

    var pagingState = MutableStateFlow<PagingData<Hit>>(PagingData.empty())
        private set

    init {
        search()
    }

    fun onChange(query: String) {
        state = state.copy(query = query)
        search()
    }

    fun onOpenDialog() {
        state = state.copy(openDialog = true)
    }

    fun onCloseDialog() {
        state = state.copy(openDialog = false)
    }

    fun onSelectHit(hit: Hit) {
        state = state.copy(currentHit = hit)
    }

    @OptIn(FlowPreview::class)
    fun search() {
        viewModelScope.launch {
            searchImageUseCase(state.query)
                .cachedIn(viewModelScope)
                .debounce(500)
                .collect {
                    pagingState.value = it
                }
        }
    }
}