package com.example.android.bajpsubmission.utils.adapters

import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import androidx.core.net.toUri
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import com.example.android.bajpsubmission.BuildConfig.IMG_URL
import com.example.android.bajpsubmission.R
import com.example.android.bajpsubmission.data.domain.MoviesModel
import com.example.android.bajpsubmission.data.domain.TvShowModel

@BindingAdapter("app:imageUrl")
fun bindImage(imageView: ImageView, imgUrl: String?) {
    imgUrl?.let {
        val completeImgUrl = "${IMG_URL}$imgUrl"
        val imgUri = completeImgUrl.toUri().buildUpon().scheme("https").build()
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
fun bindRecyclerViewMovies(recyclerView: RecyclerView, listMovies: List<MoviesModel>?) {
    listMovies?.let {
        (recyclerView.adapter as? MoviesAdapter)?.submitList(listMovies)
    }
}

@BindingAdapter("app:listTvShow")
fun bindRecyclerViewTvShow(recyclerView: RecyclerView, listTvShow: List<TvShowModel>?) {
    listTvShow?.let {
        (recyclerView.adapter as? TvShowAdapter)?.submitList(listTvShow)
    }
}

@BindingAdapter("ratingBar")
fun ratingBar(ratingBar: RatingBar, rating: Double?) {
    rating?.let {
        ratingBar.rating = rating.div(2).toFloat()
    }
}

@BindingAdapter("released")
fun releaseDate(textView: TextView, date: String?) {
    date?.let {
        textView.text = date.substring(0, 4)
    }
}