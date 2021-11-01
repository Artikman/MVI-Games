package com.example.data.source.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.data.source.local.model.GameEntity

@Database(
    entities = [GameEntity::class],
    version = 1,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {

    abstract fun gameDao(): GameDao
}