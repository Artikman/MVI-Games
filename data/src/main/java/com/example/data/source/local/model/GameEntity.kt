package com.example.data.source.local.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "games")
data class GameEntity(
    @PrimaryKey
    val id: Int,
    val title: String,
    val thumbnail: String,
    @ColumnInfo(name = "short_description")
    val shortDescription: String,
    @ColumnInfo(name = "game_url")
    val gameUrl: String,
    val genre: String,
    val platform: String,
    val publisher: String,
    val developer: String,
    @ColumnInfo(name = "release_date")
    val releaseDate: String,
    @ColumnInfo(name = "freetogame_profile_url")
    val freeToGameProfileUrl: String
)