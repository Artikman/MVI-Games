package com.example.mvi_games.ui.games

import com.bumptech.glide.Glide
import com.example.domain.common.DateUtil
import com.example.mvi_games.databinding.RowGameItemLayoutBinding
import com.example.mvi_games.model.GameUiModel
import com.hannesdorfmann.adapterdelegates4.AsyncListDifferDelegationAdapter
import com.hannesdorfmann.adapterdelegates4.dsl.adapterDelegateViewBinding

fun gameItemAdapterDelegate() =
    adapterDelegateViewBinding<GameUiModel, GameUiModel, RowGameItemLayoutBinding>(
        { layoutInflater, parent ->
            RowGameItemLayoutBinding.inflate(
                layoutInflater,
                parent,
                false
            )
        }
    ) {
        bind {
            with(binding) {
                Glide.with(context)
                    .load(item.thumbnail)
                    .into(imageViewGames)
                textViewTitle.text = item.title
                textViewDescription.text = item.shortDescription
                textViewTime.text = DateUtil.getTimeAgo(item.releaseDate)
            }
        }
    }

internal val gameItemDiffCallback = itemCallback<GameUiModel>(
    areItemsTheSame = { oldItem, newItem ->
        oldItem.id == newItem.id
    },
    areContentsTheSame = { oldItem, newItem ->
        oldItem == newItem
    },
    getChangePayload = { _, newItem ->
        newItem
    }
)


class GameAdapter : AsyncListDifferDelegationAdapter<GameUiModel>(
    gameItemDiffCallback
) {
    init {
        delegatesManager.addDelegate(gameItemAdapterDelegate())
    }
}
