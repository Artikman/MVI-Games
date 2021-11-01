package com.example.data.repository

import com.example.data.model.GameDataModel

interface LocalDataSource {
    suspend fun getGameItems(): List<GameDataModel>
}