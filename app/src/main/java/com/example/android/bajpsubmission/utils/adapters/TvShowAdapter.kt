package com.example.android.bajpsubmission.utils.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.android.bajpsubmission.data.domain.TvShowModel
import com.example.android.bajpsubmission.databinding.ListItemTvShowBinding

class TvShowAdapter(private val onClickListener: OnClickListener) :
    ListAdapter<TvShowModel, TvShowAdapter.TvShowViewHolder>(DiffCallback) {

    class TvShowViewHolder(private var binding: ListItemTvShowBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(tvShow: TvShowModel) {
            binding.listTvShow = tvShow
            binding.executePendingBindings()
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): TvShowViewHolder {
        return TvShowViewHolder(ListItemTvShowBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(holder: TvShowViewHolder, position: Int) {
        val listTvShow = getItem(position)
        holder.itemView.setOnClickListener {
            onClickListener.onClick(listTvShow)
        }
        holder.bind(listTvShow)
    }

    companion object DiffCallback : DiffUtil.ItemCallback<TvShowModel>() {
        override fun areItemsTheSame(oldItem: TvShowModel, newItem: TvShowModel): Boolean {
            return oldItem === newItem
        }

        override fun areContentsTheSame(oldItem: TvShowModel, newItem: TvShowModel): Boolean {
            return oldItem.tvShowId == newItem.tvShowId
        }
    }

    class OnClickListener(private val clickListener: (tvShow: TvShowModel) -> Unit) {
        fun onClick(tvShow: TvShowModel) = clickListener(tvShow)
    }
}