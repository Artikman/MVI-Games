package com.example.mvi_games.ui.games

import android.content.Context
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.domain.common.DateUtil
import com.example.mvi_games.databinding.RowGameItemLayoutBinding
import com.example.mvi_games.model.GameUiModel

class GameViewHolder constructor(
    private val context: Context,
    private val binding: RowGameItemLayoutBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(item: GameUiModel) {
        binding.apply {
            Glide.with(context)
                .load(item.thumbnail)
                .into(imageViewGames)
            textViewTitle.text = item.title
            textViewDescription.text = item.shortDescription
            textViewTime.text = DateUtil.getTimeAgo(item.releaseDate)
        }
    }
}