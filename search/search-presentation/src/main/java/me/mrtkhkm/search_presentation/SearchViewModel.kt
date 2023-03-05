package me.mrtkhkm.search_presentation

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import me.mrtkhkm.search_domain.use_case.SearchImageUseCase
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor(
    private val searchImageUseCase: SearchImageUseCase
) : ViewModel() {

    var state by mutableStateOf(SearchUiState())
        private set

    init {
        search("fruits")
    }

    fun search(query: String) {
        viewModelScope.launch {
            val result = searchImageUseCase(query, 3, 10)
            result
                .onSuccess { list ->
                state = state.copy(hits = list)
            }
                .onFailure {
                    Log.d("SearchViewModel", it.toString())
                }
        }
    }
}