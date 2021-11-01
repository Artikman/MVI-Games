package com.example.domain.usecase

import com.example.domain.common.Resource
import com.example.domain.entity.GameEntityModel
import com.example.domain.qualifiers.IoDispatcher
import com.example.domain.repository.Repository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class GetGamesUseCase @Inject constructor(
    private val repository: Repository,
    @IoDispatcher private val dispatcher: CoroutineDispatcher
) : BaseUseCase<Unit, Flow<Resource<List<GameEntityModel>>>> {

    override suspend fun invoke(params: Unit?): Flow<Resource<List<GameEntityModel>>> =
        repository.getGames().flowOn(dispatcher)
}