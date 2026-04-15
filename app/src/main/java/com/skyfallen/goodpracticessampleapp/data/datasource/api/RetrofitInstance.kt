package com.skyfallen.goodpracticessampleapp.data.datasource.api

import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit
import retrofit2.converter.kotlinx.serialization.asConverterFactory

object RetrofitInstance {
    private const val BASE_URL = "https://dragonball-api.com/api/"

    private val json = Json {
        ignoreUnknownKeys = true
    }

    val api: DragonBallApiService by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(json.asConverterFactory("application/json; charset=utf-8".toMediaType()))
            .build()
            .create(DragonBallApiService::class.java)
    }
}