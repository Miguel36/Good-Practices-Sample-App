package com.skyfallen.goodpracticessampleapp.domain.characters.usecase

import com.skyfallen.goodpracticessampleapp.domain.characters.entity.CharacterEntity
import com.skyfallen.goodpracticessampleapp.domain.characters.repository.CharacterRepository
import javax.inject.Inject

class GetCharacters @Inject constructor(private val characterRepository: CharacterRepository) {

    suspend operator fun invoke(page: Int): List<CharacterEntity> {
        return characterRepository.getCharacters(page)
    }
}