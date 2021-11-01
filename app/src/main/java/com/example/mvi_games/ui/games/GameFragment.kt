package com.example.mvi_games.ui.games

import android.os.Bundle
import android.view.View
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.mvi_games.R
import com.example.mvi_games.databinding.FragmentGamesBinding
import com.example.mvi_games.store.GameStore
import com.example.mvi_games.vm.GameViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

@AndroidEntryPoint
class GameFragment : Fragment(R.layout.fragment_games) {

    private val viewModel: GameViewModel by viewModels()
    private val binding: FragmentGamesBinding by viewBinding()

    private val adapter: GameAdapter by lazy { GameAdapter() }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initObservers()
        initRecycler()
    }

    private fun initRecycler() {
        binding.rvGames.adapter = adapter
        initObservers()
        if (viewModel.currentState.gamesState is GameStore.GamesState.Hide)
            viewModel.setEvent(GameStore.Event.OnFetchGames)
    }

    private fun initObservers() {
        viewLifecycleOwner.lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.uiState.collect {
                    when (val state = it.gamesState) {
                        is GameStore.GamesState.Hide -> {
                            binding.loadingPb.isVisible = false
                        }
                        is GameStore.GamesState.Loading -> {
                            binding.loadingPb.isVisible = true
                        }
                        is GameStore.GamesState.Success -> {
                            adapter.items = state.games
                            binding.loadingPb.isVisible = false
                        }
                    }
                }
            }
        }

        viewLifecycleOwner.lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.action.collect {
                    when (it) {
                        is GameStore.Action.ShowError -> {
                            val msg = it.message
                        }
                    }
                }
            }
        }
    }
}
