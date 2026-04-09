package com.skyfallen.goodpracticessampleapp.model

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
    val affiliation: String
)

@Serializable
data class Meta(
    val totalItems: Int,
    val itemCount: Int,
    val itemsPerPage: Int,
    val totalPages: Int,
    val currentPage: Int
)