package com.skyfallen.goodpracticessampleapp.di

import com.skyfallen.goodpracticessampleapp.data.characters.repository.CharacterRepositoryImpl
import com.skyfallen.goodpracticessampleapp.domain.characters.repository.CharacterRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun providesCharacterRepository(repoImpl: CharacterRepositoryImpl): CharacterRepository
}