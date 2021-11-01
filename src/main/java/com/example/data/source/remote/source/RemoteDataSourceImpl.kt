package com.example.data.source.remote.source

import com.example.data.model.GameDataModel
import com.example.data.repository.RemoteDataSource
import com.example.data.source.remote.api.ApiService
import com.example.data.source.remote.model.GameModel
import com.example.domain.common.Mapper
import javax.inject.Inject

class RemoteDataSourceImpl @Inject constructor(
    private val apiService: ApiService,
    private val gameMapper: Mapper<GameModel, GameDataModel>
) : RemoteDataSource {

    override suspend fun getGames(): List<GameDataModel> {
        val networkData = apiService.getGames()
        return gameMapper.fromList(networkData)
    }
}