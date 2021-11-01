package com.example.data.source.remote.api

import com.example.data.source.remote.model.GameModel
import retrofit2.http.GET

interface ApiService {
    @GET("games")
    suspend fun getGames(): List<GameModel>
}