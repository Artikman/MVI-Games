package com.example.mvi_games.mapper

import com.example.domain.common.Mapper
import com.example.domain.entity.GameEntityModel
import com.example.mvi_games.model.GameUiModel
import javax.inject.Inject

class GameDomainUiMapper @Inject constructor() : Mapper<GameEntityModel, GameUiModel> {

    override fun from(i: GameEntityModel): GameUiModel {
        return GameUiModel(
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
            freetogameProfileUrl = i.freeToGameProfileUrl
        )
    }

    override fun to(o: GameUiModel): GameEntityModel {
        return GameEntityModel(
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
            freeToGameProfileUrl = o.freetogameProfileUrl
        )
    }
}