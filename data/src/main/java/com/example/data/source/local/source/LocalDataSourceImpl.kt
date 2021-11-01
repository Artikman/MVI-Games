package com.example.data.source.local.source

import com.example.data.model.GameDataModel
import com.example.data.repository.LocalDataSource
import com.example.data.source.local.database.GameDao
import com.example.data.source.local.model.GameEntity
import com.example.domain.common.Mapper
import javax.inject.Inject

class LocalDataSourceImpl @Inject constructor(
    private val gameDAO: GameDao,
    private val gameMapper: Mapper<GameEntity, GameDataModel>
) : LocalDataSource {

    override suspend fun getGameItems(): List<GameDataModel> {
        val gameLocalList = gameDAO.getGameItems()
        return gameMapper.fromList(gameLocalList)
    }
}