package com.example.android.bajpsubmission.ui.tvshow.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.android.bajpsubmission.data.domain.TvShowModel

class DetailTvShowViewModel : ViewModel() {

    private val _detailTvShow = MutableLiveData<TvShowModel>()
    val detailTvShow: LiveData<TvShowModel> = _detailTvShow

    fun getDetailTvShow(tvShow: TvShowModel?) {
        if (_detailTvShow.value == null) {
            _detailTvShow.value = tvShow
        }
    }
}
