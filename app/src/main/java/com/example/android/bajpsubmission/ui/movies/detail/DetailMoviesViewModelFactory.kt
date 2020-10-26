package com.example.android.bajpsubmission.ui.movies.detail

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.android.bajpsubmission.data.MoviesEntity

class DetailMoviesViewModelFactory(
    private val movies: MoviesEntity,
    private val app: Application
) : ViewModelProvider.Factory {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(DetailMoviesViewModel::class.java)) {
            return DetailMoviesViewModel(movies, app) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}