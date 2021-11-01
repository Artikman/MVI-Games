package com.example.data.mapper

import com.example.data.model.GameDataModel
import com.example.domain.common.Mapper
import com.example.domain.entity.GameEntityModel
import javax.inject.Inject

class GameDataDomainMapper @Inject constructor() : Mapper<GameDataModel, GameEntityModel> {

    override fun from(i: GameDataModel): GameEntityModel {
        return GameEntityModel(
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

    override fun to(o: GameEntityModel): GameDataModel {
        return GameDataModel(
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