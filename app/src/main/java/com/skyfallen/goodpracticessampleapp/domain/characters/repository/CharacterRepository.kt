package com.skyfallen.goodpracticessampleapp.domain.characters.repository

import com.skyfallen.goodpracticessampleapp.domain.characters.entity.CharacterEntity

interface CharacterRepository {
    suspend fun getCharacters(page: Int): List<CharacterEntity>
}