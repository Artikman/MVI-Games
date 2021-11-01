package com.example.mvi_games.vm

import androidx.lifecycle.viewModelScope
import com.example.domain.common.Mapper
import com.example.domain.common.Resource
import com.example.domain.entity.GameEntityModel
import com.example.domain.usecase.GetGamesUseCase
import com.example.mvi_games.base.BaseViewModel
import com.example.mvi_games.model.GameUiModel
import com.example.mvi_games.store.GameStore
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class GameViewModel @Inject constructor(
    private val gamesUseCase: GetGamesUseCase,
    private val gameMapper: Mapper<GameEntityModel, GameUiModel>
) : BaseViewModel<GameStore.Event, GameStore.State, GameStore.Action>() {

    override fun createInitialState(): GameStore.State {
        return GameStore.State(
            gamesState = GameStore.GamesState.Hide,
            selectedGame = null
        )
    }

    override fun handleEvent(event: GameStore.Event) {
        when (event) {
            is GameStore.Event.OnFetchGames -> {
                fetchGames()
            }
        }
    }

    private fun fetchGames() {
        viewModelScope.launch {
            gamesUseCase.invoke(null)
                .onStart { emit(Resource.Loading) }
                .collect {
                    when (it) {
                        is Resource.Loading -> {
                            setState { copy(gamesState = GameStore.GamesState.Loading) }
                        }
                        is Resource.Empty -> {
                            setState { copy(gamesState = GameStore.GamesState.Hide) }
                        }
                        is Resource.Success -> {
                            val games = gameMapper.fromList(it.data)
                            setState { copy(gamesState = GameStore.GamesState.Success(games = games)) }
                        }
                        is Resource.Error -> {
                            setAction { GameStore.Action.ShowError(message = it.exception.message) }
                        }
                    }
                }
        }
    }
}