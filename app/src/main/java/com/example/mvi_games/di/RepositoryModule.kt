package com.example.mvi_games.di

import com.example.data.repository.LocalDataSource
import com.example.data.repository.RemoteDataSource
import com.example.data.repository.RepositoryImpl
import com.example.data.source.local.source.LocalDataSourceImpl
import com.example.data.source.remote.source.RemoteDataSourceImpl
import com.example.domain.repository.Repository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun provideLocalDataSource(localDataSourceImpl: LocalDataSourceImpl): LocalDataSource

    @Binds
    abstract fun provideRemoteDataSource(remoteDataSourceImp: RemoteDataSourceImpl): RemoteDataSource

    @Binds
    @ViewModelScoped
    abstract fun provideRepository(repository: RepositoryImpl): Repository

}