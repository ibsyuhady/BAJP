package com.example.android.bajpsubmission.ui.tvshow.detail

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.android.bajpsubmission.data.TvShowEntity

class DetailTvShowViewModel(private val tvShow: TvShowEntity, app: Application) :
    AndroidViewModel(app) {

    private val _detailTvShow = MutableLiveData<TvShowEntity>()
    val detailTvShow: LiveData<TvShowEntity> = _detailTvShow

    init {
        getDetailTvShow()
    }

    private fun getDetailTvShow() {
        _detailTvShow.value = tvShow
    }
}
