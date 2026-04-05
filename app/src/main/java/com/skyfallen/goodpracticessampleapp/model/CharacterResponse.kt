package com.skyfallen.goodpracticessampleapp.model

data class CharactersResponse(
    val items: List<Character>,
    val meta: Meta,
)


data class Character(
    val id: Int,
    val image: String,
    val name: String,
    val race: String,
    val ki: String,
    val affiliation: String
)


data class Meta(
    val totalItems: Int,
    val itemCount: Int,
    val itemsPerPage: Int,
    val totalPages: Int,
    val currentPage: Int
)