package com.example.data.source.local.database

import androidx.room.Dao
import androidx.room.Query
import com.example.data.source.local.model.GameEntity

@Dao
interface GameDao {
    @Query("SELECT * FROM games")
    suspend fun getGameItems(): List<GameEntity>
}