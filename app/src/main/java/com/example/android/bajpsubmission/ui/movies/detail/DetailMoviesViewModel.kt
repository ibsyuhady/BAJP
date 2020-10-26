package com.example.android.bajpsubmission.ui.movies.detail

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.android.bajpsubmission.data.MoviesEntity

class DetailMoviesViewModel(private val movies: MoviesEntity, app: Application) :
    AndroidViewModel(app) {

    private val _detailMovies = MutableLiveData<MoviesEntity>()
    val detailMovies: LiveData<MoviesEntity> = _detailMovies

    init {
        getDetailMovie()
    }

    private fun getDetailMovie() {
        _detailMovies.value = movies
    }
}
