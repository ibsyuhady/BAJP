package com.example.android.bajpsubmission.utils.adapters

import android.widget.ImageView
import androidx.core.net.toUri
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import com.example.android.bajpsubmission.R
import com.example.android.bajpsubmission.data.MoviesEntity
import com.example.android.bajpsubmission.data.TvShowEntity

@BindingAdapter("app:imageUrl")
fun bindImage(imageView: ImageView, imgUrl: String?) {
    imgUrl?.let {
        val imgUri = imgUrl.toUri().buildUpon().scheme("https").build()
        Glide.with(imageView.context)
            .load(imgUri)
            .transform(RoundedCorners(16))
            .apply(
                RequestOptions()
                    .placeholder(R.drawable.loading_animation)
                    .error(R.drawable.ic_broken_image)
            )
            .into(imageView)
    }
}

@BindingAdapter("app:listMovies")
fun bindRecyclerViewMovies(recyclerView: RecyclerView, listMovies: List<MoviesEntity>?) {
    listMovies?.let {
        (recyclerView.adapter as MoviesAdapter).submitList(listMovies)
    }
}

@BindingAdapter("app:listTvShow")
fun bindRecyclerViewTvShow(recyclerView: RecyclerView, listTvShow: List<TvShowEntity>?) {
    listTvShow?.let {
        (recyclerView.adapter as TvShowAdapter).submitList(listTvShow)
    }
}