package com.example.android.bajpsubmission.ui.movies

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.android.bajpsubmission.data.domain.MoviesModel
import com.example.android.bajpsubmission.data.source.AppRepository

class MoviesViewModel(private val appRepository: AppRepository) : ViewModel() {

    private var _movies: LiveData<List<MoviesModel>> = MutableLiveData()
    val movies: LiveData<List<MoviesModel>>
        get() = _movies

    init {
        getListMovies()
    }

    fun getListMovies(): LiveData<List<MoviesModel>> {
        _movies = appRepository.fetchMovies()
        return _movies
    }
}