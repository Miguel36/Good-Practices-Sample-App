package com.skyfallen.goodpracticessampleapp.ui.characters

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.skyfallen.goodpracticessampleapp.domain.characters.entity.CharacterEntity
import com.skyfallen.goodpracticessampleapp.domain.characters.usecase.GetCharacters
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

private const val PAGE_NUMBER = 1

class CharactersViewModel(val getCharacters: GetCharacters): ViewModel() {
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
                val characters = getCharacters(PAGE_NUMBER)
                _uiState.update {
                    it.copy(characterList = characters, isLoading = false, error = null)
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
    val characterList: List<CharacterEntity> = emptyList(),
    val isLoading: Boolean = false,
    val error: String? = null
)


