package com.example.mvi_games.store

import com.example.mvi_games.base.UiAction
import com.example.mvi_games.base.UiEvent
import com.example.mvi_games.base.UiState
import com.example.mvi_games.model.GameUiModel

/**
 * an intermediary between Model and View that decides how to handle Events,
 * deliver State updates and new Actions.
 */
class GameStore {

    sealed class Event : UiEvent {
        object OnFetchGames : Event()
    }

    data class State(
        val gamesState: GamesState,
        val selectedGame: GameUiModel? = null
    ) : UiState

    sealed class GamesState {
        object Hide : GamesState()
        object Loading : GamesState()
        data class Success(val games: List<GameUiModel>) : GamesState()
    }

    sealed class Action : UiAction {
        data class ShowError(val message: String?) : Action()
    }
}