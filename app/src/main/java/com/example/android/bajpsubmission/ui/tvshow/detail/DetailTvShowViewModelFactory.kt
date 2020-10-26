package com.example.android.bajpsubmission.ui.tvshow.detail

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.android.bajpsubmission.data.TvShowEntity

class DetailTvShowViewModelFactory(
    private val tvShow: TvShowEntity,
    private val app: Application
) : ViewModelProvider.Factory {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(DetailTvShowViewModel::class.java)) {
            return DetailTvShowViewModel(tvShow, app) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}