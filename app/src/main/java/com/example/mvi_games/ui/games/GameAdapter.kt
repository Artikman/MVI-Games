package com.example.mvi_games.ui.games

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.example.mvi_games.databinding.RowGameItemLayoutBinding
import com.example.mvi_games.model.GameUiModel

class GameAdapter constructor(
    private val context: Context
) : ListAdapter<GameUiModel, GameViewHolder>(GameItemDiffUtil()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GameViewHolder {
        val binding = RowGameItemLayoutBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return GameViewHolder(binding = binding, context = context)
    }

    override fun onBindViewHolder(holder: GameViewHolder, position: Int) {
        val games = getItem(position)
        if (games != null) {
            holder.bind(games)
        }
    }
}

class GameItemDiffUtil : DiffUtil.ItemCallback<GameUiModel>() {
    override fun areItemsTheSame(oldItem: GameUiModel, newItem: GameUiModel): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: GameUiModel, newItem: GameUiModel): Boolean {
        return oldItem == newItem
    }
}