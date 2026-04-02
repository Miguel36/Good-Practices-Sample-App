package com.skyfallen.goodpracticessampleapp.data.datasource.api

import retrofit2.http.GET

interface DragonBallApiService {

    @GET("characters")
    suspend fun getCharacters()
}