package com.example.data.repository

import com.example.data.model.GameDataModel

interface RemoteDataSource {
    suspend fun getGames(): List<GameDataModel>
}