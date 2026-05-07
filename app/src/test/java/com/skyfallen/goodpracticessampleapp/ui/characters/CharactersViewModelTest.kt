package com.skyfallen.goodpracticessampleapp.ui.characters

import com.skyfallen.goodpracticessampleapp.domain.characters.entity.CharacterEntity
import com.skyfallen.goodpracticessampleapp.domain.characters.usecase.GetCharacters
import com.skyfallen.goodpracticessampleapp.util.MainDispatcherRule
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.advanceUntilIdle
import kotlinx.coroutines.test.runTest
import org.junit.Rule
import org.junit.Test

@OptIn(ExperimentalCoroutinesApi::class)
class CharactersViewModelTest {

    @get:Rule
    val mainDispatcherRule = MainDispatcherRule()

    @Test
    fun `should show characters when use case returns data`() = runTest {
        val fakeCharacters = listOf(
            CharacterEntity(id = 1, name = "Goku", image = "", race = "", ki = "", affiliation = ""),
            CharacterEntity(id = 1, name = "Vegeta", image = "", race = "", ki = "", affiliation = ""),
            CharacterEntity(id = 1, name = "Gohan", image = "", race = "", ki = "", affiliation = "")
        )

        val getCharacters = mockk<GetCharacters>()
        coEvery { getCharacters(1) } returns fakeCharacters

        val viewModel = CharactersViewModel(getCharacters)
        advanceUntilIdle()

        val state = viewModel.uiState.value

        assert(state.characterList == fakeCharacters)
        assert(!state.isLoading)
        assert(state.error == null)
    }
}