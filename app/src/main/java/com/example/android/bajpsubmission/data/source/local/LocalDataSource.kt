package com.example.android.bajpsubmission.data.source.local

import androidx.lifecycle.LiveData
import com.example.android.bajpsubmission.data.domain.MoviesModel
import com.example.android.bajpsubmission.data.domain.TvShowModel
import com.example.android.bajpsubmission.data.source.local.dao.AppDao
import javax.inject.Inject

class LocalDataSource @Inject constructor(private val appDao: AppDao) {

    // companion object {
    //     @Volatile
    //     private var instance: LocalDataSource? = null
    //
    //     fun getInstance(appDao: AppDao): LocalDataSource =
    //         instance ?: LocalDataSource(appDao)
    // }

    fun getListMovies(): LiveData<List<MoviesModel>> = appDao.getListMovies()
    fun insertMovies(movies: List<MoviesModel>) = appDao.insertMovies(movies)
    fun getFavoriteMovies() = appDao.getFavoriteMovies()
    fun updateFavoriteMovieStatus(movie: MoviesModel) {
        movie.isFavorite = !movie.isFavorite
        appDao.updateFavoriteMovieStatus(movie)
    }

    fun getListTvShow() = appDao.getListTvShow()
    fun insertTvShow(tvShow: List<TvShowModel>) = appDao.insertTvShow(tvShow)
    fun getFavoriteTvShow() = appDao.getFavoriteTvShow()
    fun updateFavoriteTvShowStatus(tvShow: TvShowModel) {
        tvShow.isFavorite = !tvShow.isFavorite
        appDao.updateFavoriteTvShowStatus(tvShow)
    }
}