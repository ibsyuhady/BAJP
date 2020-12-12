package com.example.android.bajpsubmission.ui.tvshow

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.android.bajpsubmission.data.domain.TvShowModel
import com.example.android.bajpsubmission.data.source.AppRepository

class TvShowViewModel(private val appRepository: AppRepository) : ViewModel() {

    private var _tvShow: LiveData<List<TvShowModel>> = MutableLiveData()
    val tvShow: LiveData<List<TvShowModel>>
        get() = _tvShow

    fun getListTvShow(): LiveData<List<TvShowModel>> {
        if (_tvShow.value == null) {
            _tvShow = appRepository.fetchTvShow()
        }
        return tvShow
    }
}