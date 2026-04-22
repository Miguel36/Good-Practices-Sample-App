package com.skyfallen.goodpracticessampleapp.data.characters.repository

import com.skyfallen.goodpracticessampleapp.data.characters.response.toDomain
import com.skyfallen.goodpracticessampleapp.data.datasource.api.DragonBallApiService
import com.skyfallen.goodpracticessampleapp.domain.characters.entity.CharacterEntity
import com.skyfallen.goodpracticessampleapp.domain.characters.repository.CharacterRepository
import javax.inject.Inject

class CharacterRepositoryImpl @Inject constructor(private val api: DragonBallApiService): CharacterRepository {

    override suspend fun getCharacters(page: Int): List<CharacterEntity> {
        val characters = api.getCharacters(page).items

        return characters.map { it.toDomain() }
    }
}