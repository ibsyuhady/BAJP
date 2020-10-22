package com.example.android.bajpsubmission.utils.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.android.bajpsubmission.data.MoviesEntity
import com.example.android.bajpsubmission.databinding.ListItemMoviesBinding

class MoviesAdapter(private val onClickListener: OnClickListener) :
    ListAdapter<MoviesEntity, MoviesAdapter.MoviesViewHolder>(DiffCallback) {

    class MoviesViewHolder(private var binding: ListItemMoviesBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(listMovies: MoviesEntity) {
            binding.listMovies = listMovies
            binding.executePendingBindings()
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MoviesViewHolder {
        return MoviesViewHolder(ListItemMoviesBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(holder: MoviesViewHolder, position: Int) {
        val listMovies = getItem(position)
        holder.itemView.setOnClickListener {
            onClickListener.onClick(listMovies)
        }
        holder.bind(listMovies)
    }

    companion object DiffCallback : DiffUtil.ItemCallback<MoviesEntity>() {
        override fun areItemsTheSame(oldItem: MoviesEntity, newItem: MoviesEntity): Boolean {
            return oldItem === newItem
        }

        override fun areContentsTheSame(oldItem: MoviesEntity, newItem: MoviesEntity): Boolean {
            return oldItem.moviesId == newItem.moviesId
        }
    }

    class OnClickListener(private val clickListener: (listMovies: MoviesEntity) -> Unit) {
        fun onClick(listMovies: MoviesEntity) = clickListener(listMovies)
    }
}