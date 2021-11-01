package com.example.mvi_games.di

import com.example.data.mapper.GameDataDomainMapper
import com.example.data.model.GameDataModel
import com.example.data.source.local.mapper.GameLocalDataMapper
import com.example.data.source.local.model.GameEntity
import com.example.data.source.remote.mapper.GameNetworkDataMapper
import com.example.data.source.remote.model.GameModel
import com.example.domain.common.Mapper
import com.example.domain.entity.GameEntityModel
import com.example.mvi_games.mapper.GameDomainUiMapper
import com.example.mvi_games.model.GameUiModel
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class MapperModule {

    @Binds
    abstract fun bindsGameNetworkDataMapper(mapper: GameNetworkDataMapper): Mapper<GameModel, GameDataModel>

    @Binds
    abstract fun bindsGameLocalDataMapper(mapper: GameLocalDataMapper): Mapper<GameEntity, GameDataModel>

    @Binds
    abstract fun bindsGameDataDomainMapper(mapper: GameDataDomainMapper): Mapper<GameDataModel, GameEntityModel>

    @Binds
    abstract fun bindsGameDomainUiMapper(mapper: GameDomainUiMapper): Mapper<GameEntityModel, GameUiModel>
}