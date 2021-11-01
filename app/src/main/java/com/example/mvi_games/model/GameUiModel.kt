package com.example.mvi_games.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class GameUiModel(
    val id: Int,
    val title: String,
    val thumbnail: String,
    val shortDescription: String,
    val gameUrl: String,
    val genre: String,
    val platform: String,
    val publisher: String,
    val developer: String,
    val releaseDate: String,
    val freetogameProfileUrl: String
) : Parcelable