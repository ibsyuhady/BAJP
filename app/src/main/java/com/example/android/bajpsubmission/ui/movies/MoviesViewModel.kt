package com.example.android.bajpsubmission.ui.movies

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.android.bajpsubmission.data.MoviesEntity
import com.example.android.bajpsubmission.utils.DataDummy

class MoviesViewModel : ViewModel() {
    private val _data = MutableLiveData<List<MoviesEntity>>()
    val data: LiveData<List<MoviesEntity>> = _data

    init {
        getListMovies()
    }

    private fun getListMovies(): List<MoviesEntity>? {
        _data.value = DataDummy.generateDummyMovies()
        return _data.value
    }
}