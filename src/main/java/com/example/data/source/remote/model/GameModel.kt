package com.example.data.source.remote.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class GameModel(
    @SerialName("id")
    val id: Int,
    @SerialName("title")
    val title: String,
    @SerialName("thumbnail")
    val thumbnail: String,
    @SerialName("short_description")
    val shortDescription: String,
    @SerialName("game_url")
    val gameUrl: String,
    @SerialName("genre")
    val genre: String,
    @SerialName("platform")
    val platform: String,
    @SerialName("publisher")
    val publisher: String,
    @SerialName("developer")
    val developer: String,
    @SerialName("release_date")
    val releaseDate: String,
    @SerialName("freetogame_profile_url")
    val freetogameProfileUrl: String
)