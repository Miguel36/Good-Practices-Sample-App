package com.skyfallen.goodpracticessampleapp.data.characters.response

import com.skyfallen.goodpracticessampleapp.domain.characters.entity.CharacterEntity
import kotlinx.serialization.Serializable

@Serializable
data class CharactersResponse(
    val items: List<Character>,
    val meta: Meta,
)

@Serializable
data class Character(
    val id: Int,
    val image: String,
    val name: String,
    val race: String,
    val ki: String,
    val affiliation: String,
    val gender: String
)

@Serializable
data class Meta(
    val totalItems: Int,
    val itemCount: Int,
    val itemsPerPage: Int,
    val totalPages: Int,
    val currentPage: Int
)

fun Character.toDomain(): CharacterEntity {
    return CharacterEntity(
        id = id,
        image = image,
        name = name,
        race = race,
        ki = ki,
        affiliation = affiliation
    )
}