package com.example.data.source.remote.mapper

import com.example.data.model.GameDataModel
import com.example.data.source.remote.model.GameModel
import com.example.domain.common.Mapper
import javax.inject.Inject

class GameNetworkDataMapper @Inject constructor() : Mapper<GameModel, GameDataModel> {

    override fun from(i: GameModel): GameDataModel {
        return GameDataModel(
            id = i.id,
            title = i.title,
            thumbnail = i.thumbnail,
            shortDescription = i.shortDescription,
            gameUrl = i.gameUrl,
            genre = i.genre,
            platform = i.platform,
            publisher = i.publisher,
            developer = i.developer,
            releaseDate = i.releaseDate,
            freeToGameProfileUrl = i.freetogameProfileUrl
        )
    }

    override fun to(o: GameDataModel): GameModel {
        return GameModel(
            id = o.id,
            title = o.title,
            thumbnail = o.thumbnail,
            shortDescription = o.shortDescription,
            gameUrl = o.gameUrl,
            genre = o.genre,
            platform = o.platform,
            publisher = o.publisher,
            developer = o.developer,
            releaseDate = o.releaseDate,
            freetogameProfileUrl = o.freeToGameProfileUrl
        )
    }
}