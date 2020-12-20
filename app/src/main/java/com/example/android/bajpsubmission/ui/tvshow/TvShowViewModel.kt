package com.example.android.bajpsubmission.ui.tvshow

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.android.bajpsubmission.data.Resource
import com.example.android.bajpsubmission.data.domain.TvShowModel
import com.example.android.bajpsubmission.data.source.AppRepository
import javax.inject.Inject

class TvShowViewModel @Inject constructor(private val appRepository: AppRepository) : ViewModel() {

    private var _tvShow: LiveData<List<TvShowModel>> = MutableLiveData()
    val tvShow: LiveData<List<TvShowModel>>
        get() = _tvShow

    private var tvShows: LiveData<Resource<List<TvShowModel>>> = MutableLiveData()

    fun getListTvShow(): LiveData<Resource<List<TvShowModel>>> {
        if (_tvShow.value == null) {
            tvShows = appRepository.fetchTvShow()
        }
        return tvShows
    }
}