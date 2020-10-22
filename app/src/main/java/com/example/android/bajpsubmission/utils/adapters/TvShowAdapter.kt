package com.example.android.bajpsubmission.utils.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.android.bajpsubmission.data.TvShowEntity
import com.example.android.bajpsubmission.databinding.ListItemTvShowBinding

class TvShowAdapter(private val onClickListener: OnClickListener) :
    ListAdapter<TvShowEntity, TvShowAdapter.TvShowViewHolder>(DiffCallback) {

    class TvShowViewHolder(private var binding: ListItemTvShowBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(tvShow: TvShowEntity) {
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

    companion object DiffCallback : DiffUtil.ItemCallback<TvShowEntity>() {
        override fun areItemsTheSame(oldItem: TvShowEntity, newItem: TvShowEntity): Boolean {
            return oldItem === newItem
        }

        override fun areContentsTheSame(oldItem: TvShowEntity, newItem: TvShowEntity): Boolean {
            return oldItem.tvShowId == newItem.tvShowId
        }
    }

    class OnClickListener(private val clickListener: (tvShow: TvShowEntity) -> Unit) {
        fun onClick(tvShow: TvShowEntity) = clickListener(tvShow)
    }
}