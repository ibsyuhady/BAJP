package com.example.android.bajpsubmission.data.source

import androidx.lifecycle.LiveData
import com.example.android.bajpsubmission.data.Resource
import com.example.android.bajpsubmission.data.domain.MoviesModel
import com.example.android.bajpsubmission.data.domain.TvShowModel

interface DataSource {

    fun fetchMovies(): LiveData<Resource<List<MoviesModel>>>

    fun getFavoriteMovies(): LiveData<List<MoviesModel>>

    fun fetchTvShow(): LiveData<Resource<List<TvShowModel>>>

    fun getFavoriteTvShow(): LiveData<List<TvShowModel>>

    fun setFavoriteMovieStatus(movie: MoviesModel)

    fun setFavoriteTvShowStatus(tvShow: TvShowModel)
}