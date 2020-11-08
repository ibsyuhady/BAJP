package com.example.android.bajpsubmission.ui.movies.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.android.bajpsubmission.data.MoviesEntity

class DetailMoviesViewModel : ViewModel() {

    private val _detailMovies = MutableLiveData<MoviesEntity>()
    val detailMovies: LiveData<MoviesEntity> = _detailMovies

    fun getDetailMovie(movies: MoviesEntity?) {
        if (_detailMovies.value == null) {
            _detailMovies.value = movies
        }
    }
}
