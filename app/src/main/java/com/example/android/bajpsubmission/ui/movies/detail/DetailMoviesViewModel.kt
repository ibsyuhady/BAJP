package com.example.android.bajpsubmission.ui.movies.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.android.bajpsubmission.data.domain.MoviesModel

class DetailMoviesViewModel : ViewModel() {

    private val _detailMovies = MutableLiveData<MoviesModel>()
    val detailMovies: LiveData<MoviesModel> = _detailMovies

    fun getDetailMovie(movies: MoviesModel?) {
        if (_detailMovies.value == null) {
            _detailMovies.value = movies
        }
    }
}
