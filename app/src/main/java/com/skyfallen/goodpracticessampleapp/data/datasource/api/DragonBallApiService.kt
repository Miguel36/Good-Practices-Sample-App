package com.skyfallen.goodpracticessampleapp.data.datasource.api

import com.skyfallen.goodpracticessampleapp.data.characters.response.CharactersResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface DragonBallApiService {

    @GET("characters")
    suspend fun getCharacters(@Query("page") page: Int): CharactersResponse
}