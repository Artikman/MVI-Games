package com.example.data.repository

import com.example.data.model.GameDataModel
import com.example.domain.common.Mapper
import com.example.domain.common.Resource
import com.example.domain.entity.GameEntityModel
import com.example.domain.repository.Repository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class RepositoryImpl @Inject constructor(
    private val localDataSource: LocalDataSource,
    private val remoteDataSource: RemoteDataSource,
    private val gameMapper: Mapper<GameDataModel, GameEntityModel>
) : Repository {

    override suspend fun getGames(): Flow<Resource<List<GameEntityModel>>> {
        return flow {
            try {
                val data = remoteDataSource.getGames()
                emit(Resource.Success(gameMapper.fromList(data)))
            } catch (exception: Exception) {
                try {
                    val local = localDataSource.getGameItems()
                    emit(Resource.Success(gameMapper.fromList(local)))
                } catch (exception: Exception) {
                    emit(Resource.Error(exception))
                }
            }
        }
    }
}