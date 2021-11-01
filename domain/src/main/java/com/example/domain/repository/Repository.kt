package com.example.domain.repository

import com.example.domain.common.Resource
import com.example.domain.entity.GameEntityModel
import kotlinx.coroutines.flow.Flow

interface Repository {
    suspend fun getGames(): Flow<Resource<List<GameEntityModel>>>
}