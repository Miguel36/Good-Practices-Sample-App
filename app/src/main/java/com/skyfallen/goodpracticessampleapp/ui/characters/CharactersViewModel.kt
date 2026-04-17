package com.skyfallen.goodpracticessampleapp.ui.characters

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.skyfallen.goodpracticessampleapp.data.datasource.api.RetrofitInstance
import com.skyfallen.goodpracticessampleapp.data.characters.response.Character
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

private const val PAGE_NUMBER = 1

class CharactersViewModel(): ViewModel() {
    private val _uiState = MutableStateFlow(CharactersUiState())
    val uiState: StateFlow<CharactersUiState> = _uiState

    init {
        loadCharacters()
    }

    private fun loadCharacters() {
        viewModelScope.launch {
            //loading
            _uiState.update { it.copy(isLoading = true, error = null) }

            try {
                //success
                val response = RetrofitInstance.api.getCharacters(PAGE_NUMBER)
                _uiState.update {
                    it.copy(characterList = response.items, isLoading = false, error = null)
                }
            }
            catch (e: Exception) {
                //error
                Log.e("CHARACTER_RESPONSE_ERROR", "error getting data", e)
                _uiState.update { it.copy(isLoading = false, error = e.message) }
            }
        }
    }
}


data class CharactersUiState(
    val characterList: List<Character> = emptyList(),
    val isLoading: Boolean = false,
    val error: String? = null
)


