package com.example.android.bajpsubmission.ui.tvshow

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.android.bajpsubmission.data.TvShowEntity
import com.example.android.bajpsubmission.utils.DataDummy

class TvShowViewModel : ViewModel() {

    private val _tvShow = MutableLiveData<List<TvShowEntity>>()
    val tvShow: LiveData<List<TvShowEntity>> = _tvShow

    init {
        getListTvShow()
    }

    fun getListTvShow(): List<TvShowEntity>? {
        _tvShow.value = DataDummy.generateDummyTvShow()
        return _tvShow.value
    }
}
