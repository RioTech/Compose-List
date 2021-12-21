package com.example.compose.di

import com.example.compose.network.ApiService
import com.example.compose.repository.ListRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Singleton
    @Provides
    fun providesListRepository(apiService: ApiService): ListRepository {
        return ListRepository(apiService = apiService)
    }
}