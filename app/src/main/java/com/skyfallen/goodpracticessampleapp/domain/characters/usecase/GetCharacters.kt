package com.skyfallen.goodpracticessampleapp.domain.characters.usecase

import com.skyfallen.goodpracticessampleapp.domain.characters.entity.CharacterEntity
import com.skyfallen.goodpracticessampleapp.domain.characters.repository.CharacterRepository

class GetCharacters(private val characterRepository: CharacterRepository) {

    suspend operator fun invoke(page: Int): List<CharacterEntity> {
        return characterRepository.getCharacters(page)
    }
}