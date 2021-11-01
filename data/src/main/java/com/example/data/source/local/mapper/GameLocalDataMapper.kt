package com.example.data.source.local.mapper

import com.example.data.model.GameDataModel
import com.example.data.source.local.model.GameEntity
import com.example.domain.common.Mapper
import javax.inject.Inject

class GameLocalDataMapper @Inject constructor() : Mapper<GameEntity, GameDataModel> {

    override fun from(i: GameEntity): GameDataModel {
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
            freeToGameProfileUrl = i.freeToGameProfileUrl
        )
    }

    override fun to(o: GameDataModel): GameEntity {
        return GameEntity(
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
            freeToGameProfileUrl = o.freeToGameProfileUrl
        )
    }
}