package com.example.android.bajpsubmission.utils

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.android.bajpsubmission.data.source.AppRepository
import com.example.android.bajpsubmission.di.Injection
import com.example.android.bajpsubmission.ui.movies.MoviesViewModel
import com.example.android.bajpsubmission.ui.tvshow.TvShowViewModel

class ViewModelFactory private constructor(private val appRepository: AppRepository) :
    ViewModelProvider.NewInstanceFactory() {

    companion object {
        @Volatile
        private var instance: ViewModelFactory? = null

        fun getInstance(): ViewModelFactory =
            instance ?: synchronized(this) {
                instance ?: ViewModelFactory(Injection.provideRepository())
            }
    }

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return when {
            modelClass.isAssignableFrom(MoviesViewModel::class.java) -> MoviesViewModel(
                appRepository
            ) as T
            modelClass.isAssignableFrom(TvShowViewModel::class.java) -> TvShowViewModel(
                appRepository
            ) as T
            else ->
                throw IllegalArgumentException("Unknown ViewModel Class")
        }
    }
}