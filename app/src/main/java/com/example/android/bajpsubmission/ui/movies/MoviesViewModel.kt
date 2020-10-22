package com.example.android.bajpsubmission.ui.movies

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.android.bajpsubmission.data.MoviesEntity
import com.example.android.bajpsubmission.utils.DataDummy

class MoviesViewModel : ViewModel() {

    private val _movies = MutableLiveData<List<MoviesEntity>>()
    val movies: LiveData<List<MoviesEntity>> = _movies

    init {
        getListMovies()
    }

    private fun getListMovies(): List<MoviesEntity>? {
        _movies.value = DataDummy.generateDummyMovies()
        return _movies.value
    }
}