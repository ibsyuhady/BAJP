package com.example.android.bajpsubmission.data.source.local.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.android.bajpsubmission.data.domain.MoviesModel
import com.example.android.bajpsubmission.data.domain.TvShowModel

@Dao
interface AppDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE, entity = MoviesModel::class)
    fun insertMovies(movies: List<MoviesModel>)

    @Update(entity = MoviesModel::class)
    fun updateFavoriteMovieStatus(movies: MoviesModel)

    @Query("SELECT * FROM favorite_movies_table")
    fun getListMovies(): LiveData<List<MoviesModel>>

    @Query("SELECT * FROM favorite_movies_table WHERE isFavorite = 1")
    fun getFavoriteMovies(): LiveData<List<MoviesModel>>

    @Insert(onConflict = OnConflictStrategy.REPLACE, entity = TvShowModel::class)
    fun insertTvShow(tvShow: List<TvShowModel>)

    @Update(entity = TvShowModel::class)
    fun updateFavoriteTvShowStatus(tvShow: TvShowModel)

    @Query("SELECT * FROM favorite_tv_show_table")
    fun getListTvShow(): LiveData<List<TvShowModel>>

    @Query("SELECT * FROM favorite_tv_show_table WHERE isFavorite = 1")
    fun getFavoriteTvShow(): LiveData<List<TvShowModel>>
}