package com.example.android.bajpsubmission.data.source

import androidx.lifecycle.LiveData
import com.example.android.bajpsubmission.data.domain.MoviesModel
import com.example.android.bajpsubmission.data.domain.TvShowModel

interface DataSource {

    fun fetchMovies(): LiveData<List<MoviesModel>>

    fun fetchTvShow(): LiveData<List<TvShowModel>>
}